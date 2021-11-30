/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sk.dvdlibraryfinal.dto;

/**
 *
 * @author SHIVALI
 */
public class Dvd {
    // class holds all the DVD info.
    
    private String title;
    private String releaseDate; 
    private String MpaaRating;
    private String directorsName;
    private String studio;
    private String viewerNotes;
    
    public Dvd(String title) {
        this.title = title;
    }// read- only field so no setter code only getter code 

    public String getTitle() {
        return title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMpaaRating() {
        return MpaaRating;
    }

    public void setMpaaRating(String MpaaRating) {
        this.MpaaRating = MpaaRating;
    }

    public String getDirectorsName() {
        return directorsName;
    }

    public void setDirectorsName(String directorsName) {
        this.directorsName = directorsName;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getViewerNotes() {
        return viewerNotes;
    }

    public void setViewerNotes(String viewerNotes) {
        this.viewerNotes = viewerNotes;
    }
    
    
}
