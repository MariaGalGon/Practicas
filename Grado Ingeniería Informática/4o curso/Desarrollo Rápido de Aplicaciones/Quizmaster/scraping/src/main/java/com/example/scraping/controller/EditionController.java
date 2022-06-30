package com.example.scraping.controller;

import java.util.List;
import com.example.scraping.dto.EditionDataDto;
import com.example.scraping.services.EditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/editions")
public class EditionController {
    @Autowired
    private EditionService editionService;

    @GetMapping("data")
    public ResponseEntity<List<EditionDataDto>> getCovidData() {
        return new ResponseEntity<List<EditionDataDto>>(editionService.retrieveEditions(),
                HttpStatus.OK);
    }
}
