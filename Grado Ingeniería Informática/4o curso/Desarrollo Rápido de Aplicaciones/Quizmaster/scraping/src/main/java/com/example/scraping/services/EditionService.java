package com.example.scraping.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.scraping.dto.EditionDataDto;

import com.google.firebase.cloud.FirestoreClient;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

@Component("editionService")
public class EditionService {
    public List<EditionDataDto> retrieveEditions() {
        List<EditionDataDto> editionData = new ArrayList<>();
        boolean videogamesFound = false;
        String name = "";
        String year = "";
        String allContent = "";
        int indexStart = -1;
        int indexEnd = -1;

        try {
            Document webPage = Jsoup.connect("https://en.wikipedia.org/wiki/List_of_Trivial_Pursuit_editions")
                    .get();
            List<Element> lis = webPage.getElementsByTag("li");

            for (Element item : lis) {
                // Get name
                Element nameElement = item.select("li > b").first();
                if (nameElement == null)
                    nameElement = item.select("li > i").first();
                if (nameElement == null)
                    continue;
                name = nameElement.text();

                // Get year
                allContent = item.text();
                if (name.equals("Star Trek Edition VCR Game") || videogamesFound) {
                    indexStart = allContent.lastIndexOf("(");
                    indexEnd = allContent.lastIndexOf(")");

                    videogamesFound = true;
                } else if (allContent.contains("(O") || allContent.contains("(i")) {
                    indexStart = allContent.lastIndexOf("(");
                    indexEnd = allContent.indexOf(",");
                    if (indexEnd == -1)
                        indexEnd = allContent.lastIndexOf(")");
                } else if (allContent.contains("(8")) {
                    indexStart = allContent.lastIndexOf("(");
                    indexEnd = allContent.lastIndexOf(")");
                } else if (allContent.contains("(W") || name.equals("Party Quiz (German)")
                        || name.equals("Polski Sport (Polish)") || name.equals("Friends (The TV Series)")) {
                    indexStart = -1;
                } else if (name.equals("Trivial Pursuit - Édition France (1989) -") || name.equals("Genus (2003)")) {
                    indexStart = name.indexOf("(");
                    indexEnd = name.indexOf(")");
                    name = name.substring(0, indexStart);
                } else {
                    indexStart = allContent.indexOf("(");
                    indexEnd = allContent.indexOf(",");
                    if (indexEnd == -1)
                        indexEnd = allContent.indexOf(")");
                }

                if (indexStart == -1) {
                    editionData.add(new EditionDataDto(name));
                } else {
                    year = allContent.substring(indexStart + 1, indexEnd);

                    editionData.add(new EditionDataDto(name, year));
                }
            }

            Firestore db = FirestoreClient.getFirestore();

            try {
                // retrieve a small batch of documents to avoid out-of-memory errors
                ApiFuture<QuerySnapshot> future = db.collection("editions").get();
                // future.get() blocks on document retrieval
                List<QueryDocumentSnapshot> documents = future.get().getDocuments();
                for (QueryDocumentSnapshot document : documents) {
                    document.getReference().delete();
                }
            } catch (Exception e) {
                System.err.println("Error deleting collection : " + e.getMessage());
            }

            for (EditionDataDto edition : editionData) {
                // DocumentReference docRef = db.collection("editions").document("alovelace");
                // Add document data using a hashmap
                Map<String, Object> data = new HashMap<>();
                data.put("name", edition.name);
                data.put("year", (edition.year != null) ? edition.year : "");
                // asynchronously write data
                ApiFuture<DocumentReference> addedDocRef = db.collection("editions").add(data);
                // ApiFuture<WriteResult> result = docRef.set(data);
            }

            return editionData;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
