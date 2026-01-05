package com.tf8.quizapp.model.dto;

//Classe Classement pour la réponse ajouté par Loan

public class ClassementEntryDTO {

    private int rank;
    private UserResponseDTO user;
    private int score;

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public UserResponseDTO getUser() {
        return user;
    }

    public void setUser(UserResponseDTO user) {
        this.user = user;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}