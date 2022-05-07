package com.example.crimeintent2;

import java.io.Serializable;

public class Crime implements Serializable {
    Long id;
    String title;
    boolean solved;
    String bigtitle;
    String date;

    public Crime(String title, boolean solved, String bigtitle, String date) {
        this.title = title;
        this.solved = solved;
        this.bigtitle = bigtitle;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isSolved() {
        return solved;
    }

    public void setSolved(boolean solved) {
        this.solved = solved;
    }

    public String getBigtitle() {
        return bigtitle;
    }

    public void setBigtitle(String bigtitle) {
        this.bigtitle = bigtitle;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
