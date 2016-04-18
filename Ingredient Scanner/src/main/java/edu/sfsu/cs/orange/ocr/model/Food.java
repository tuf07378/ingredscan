package edu.sfsu.cs.orange.ocr.model;

/**
 * Created by Rob on 4/12/2016.
 */
public class Food {
    private int _id;
    private String name;
    private String description;
    private String tags;

    public Food(int id, String name, String description, String tags) {
        this._id = id;
        this.tags = tags;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        this._id = id;
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

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
