import 'package:firebase_auth/firebase_auth.dart';
import 'package:trivial/models/editions_data.dart';
import 'package:trivial/models/question_data.dart';
import 'package:trivial/models/relation_data.dart';
import 'package:trivial/models/user_data.dart';
import 'package:cloud_firestore/cloud_firestore.dart';

class BDOperations {
  static Future createUser(UserData user) async {
    final document =
        FirebaseFirestore.instance.collection("users").doc(user.id);

    final json = user.toJson();

    await document.set(json);
  }

  static Future saveQuestion(QuestionData question, String idUser) async {
    String? questionId = await getQuestionId(question.question);
    //If the question is already saved it creates the relation.
    //If not, it creates a new question and saves the new ID for the relation
    if (questionId == null) {
      final documentQuestion =
          FirebaseFirestore.instance.collection("questions").doc();
      questionId = documentQuestion.id;
      question.id = questionId;
      final jsonQuestion = question.toJson();
      await documentQuestion.set(jsonQuestion);
    }

    final documentRelation =
        FirebaseFirestore.instance.collection("relations").doc();
    String idRelation = documentRelation.id;
    RelationData relation = RelationData(idRelation, questionId, idUser);
    final jsonRelation = relation.toJson();
    await documentRelation.set(jsonRelation);
  }

  static Future<UserData?> getUser(String userId) async {
    final document =
        FirebaseFirestore.instance.collection("users").doc(userId);
    final snapshot = await document.get();

    if (snapshot.exists) {
      return UserData.fromJson(snapshot.data()!);
    }
    return null;
  }

  static Future<List<QuestionData>> getQuestions(String userId) async {
    var relations = FirebaseFirestore.instance.collection("relations");
    var snapshotsRelation = await relations.get();

    List<String> questionsId = [];
    for (var x in snapshotsRelation.docs) {
      RelationData relation = RelationData.fromJson(x.data());
      if (relation.idUser == userId) {
        questionsId.add(relation.idQuestion);
      }
    }

    var allQuestions = FirebaseFirestore.instance.collection("questions");
    var snapshotsQuestions = await allQuestions.get();

    List<QuestionData> questions = [];
    for (var x in snapshotsQuestions.docs) {
      QuestionData question = QuestionData.fromJsonFirestore(x.data());
      if (questionsId.contains(question.id)) {
        questions.add(question);
      }
    }

    return questions;
  }

  static Future<String?> getQuestionId(String question) async {
    String? questionId;

    var questions = FirebaseFirestore.instance.collection("questions");
    var snapshots = await questions.get();
    for (var x in snapshots.docs) {
      QuestionData q = QuestionData.fromJsonFirestore(x.data());
      if ((q.question == question)) {
        questionId = q.id;
        break;
      }
    }

    return questionId;
  }

  static Future<RelationData?> getRelation(
      String questionId, String userId) async {
    RelationData? relation;

    var relations = FirebaseFirestore.instance.collection("relations");
    var snapshots = await relations.get();
    for (var x in snapshots.docs) {
      RelationData r = RelationData.fromJson(x.data());
      if ((r.idQuestion == questionId) && (r.idUser == userId)) {
        relation = r;
        break;
      }
    }

    return relation;
  }

  static Stream<List<EditionsData>> getEditions() {
    return FirebaseFirestore.instance.collection("editions").snapshots().map(
        (snapshot) => snapshot.docs
            .map((doc) => EditionsData.fromJson(doc.data()))
            .toList());
  }

  static Future<bool> updateUser(UserData user, String actualPassword) async {
    UserData oldData =
        await getUser(FirebaseAuth.instance.currentUser!.uid) as UserData;

    //Firestore data is updated
    final document =
        FirebaseFirestore.instance.collection("users").doc(user.id);
    document.update(user.toJson());

    //Authentication data is updated
    try {
      AuthCredential credentials = EmailAuthProvider.credential(
          email: oldData.mail, password: actualPassword);
      await FirebaseAuth.instance.currentUser!
          .reauthenticateWithCredential(credentials);
      if (user.mail != oldData.mail) {
        await FirebaseAuth.instance.currentUser!.updateEmail(user.mail);
      }
      if (user.password.isNotEmpty) {
        await FirebaseAuth.instance.currentUser!.updatePassword(user.password);
      }
    } catch (e) {
      return false;
    }
    return true;
  }

  static Future<bool> deleteUser(String password) async {
    UserData userData =
        await getUser(FirebaseAuth.instance.currentUser!.uid) as UserData;

    try {
      AuthCredential credentials = EmailAuthProvider.credential(
          email: userData.mail, password: password);
      await FirebaseAuth.instance.currentUser!
          .reauthenticateWithCredential(credentials);
    } catch (e) {
      return false;
    }

    //Deletes user relations
    var relations = FirebaseFirestore.instance.collection("relations");
    var snapshots = await relations.get();
    for (var x in snapshots.docs) {
      RelationData q = RelationData.fromJson(x.data());
      if (q.idUser == userData.id) {
        deleteRelation(q);
      }
    }

    //Deletes user from Firestore
    final document =
        FirebaseFirestore.instance.collection("users").doc(userData.id);
    document.delete();

    //Deletes user from Authentication
    try {
      // AuthCredential credentials = EmailAuthProvider.credential(
      //     email: userData.mail, password: password);
      // await FirebaseAuth.instance.currentUser!
      //     .reauthenticateWithCredential(credentials);
      await FirebaseAuth.instance.currentUser!.delete();
      return true;
    } catch (e) {
      return false;
    }
  }

  static void deleteRelation(RelationData relation) {
    final document =
        FirebaseFirestore.instance.collection("relations").doc(relation.id);
    document.delete();
  }
}
