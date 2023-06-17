package com.example.lab12;

public class Country {
    private int id;
    private String name;
    private String description;
    private int image_id;



    public Country(int id, String name, String description, int image_id) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image_id = image_id;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
