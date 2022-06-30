package com.example.scraping.dto;

public class EditionDataDto {
    public String name;
    public String year;

    public EditionDataDto(String name, String year) {
        this.name = name;
        this.year = year;
    }

    public EditionDataDto(String name) {
        this.name = name;
    }

    public EditionDataDto() {

    }
}
