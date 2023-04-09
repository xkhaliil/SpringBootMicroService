package com.khalil.demo345.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGame;
    private String nomGame;
    private Double prixGame;
    private Date dateCreation;
    public Game() {
        super();
    }

    public Game(String nomGame, Double prixGame, Date dateCreation) {
        super();
        this.nomGame = nomGame;
        this.prixGame = prixGame;
        this.dateCreation = dateCreation;
    }

    public Long getIdGame() {
        return idGame;
    }
    public void setIdGame(Long idGame) {
        this.idGame = idGame;
    }

    public String getNomGame() {
        return nomGame;
    }
    public void setNomGame(String nomGame) {
        this.nomGame = nomGame;
    }

    public Double getPrixGame() {
        return prixGame;
    }
    public void setPrixGame(Double prixGame) {
        this.prixGame = prixGame;
    }

    public Date getDateCreation() {
        return dateCreation;
    }
    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    @Override
    public String toString() {
        return "Game [idGame=" + idGame + ", nomGame=" + nomGame + ", prixGame=" + prixGame
                + ", dateCreation=" + dateCreation + "]";
    }

}
