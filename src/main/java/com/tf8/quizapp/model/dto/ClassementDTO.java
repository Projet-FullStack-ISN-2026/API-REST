package com.tf8.quizapp.model.dto;

import java.util.List;

public class ClassementDTO {

    private Long quizId;
    private List<ClassementEntryDTO> entries;

    public Long getQuizId() {
        return quizId;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }

    public List<ClassementEntryDTO> getEntries() {
        return entries;
    }

    public void setEntries(List<ClassementEntryDTO> entries) {
        this.entries = entries;
    }
}