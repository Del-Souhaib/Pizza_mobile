package com.example.pizza.beans;

public class Pizza {

    private  int id;
    private String nom;
    private String time;
    private int photo;
    private String desc;

    private static int comp;

    public Pizza() {
    }

    public Pizza(String nom, String time, int photo, String desc) {
        this.id = ++comp;
        this.nom = nom;
        this.time = time;
        this.photo = photo;
        this.desc = desc;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String gettime() {
        return time;
    }

    public void settime(String time) {
        this.time = time;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
