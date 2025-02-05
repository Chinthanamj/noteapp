package com.cars24.noteapp.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
@Document(collection = "notes")
public class NoteEntity {

    @Id
    private String id;
    private String name;
    private LocalDate dob;
    private String title;
    private String description;

    // Constructors
    public NoteEntity() {}

    public NoteEntity(String name, LocalDate dob, String title, String description) {
        this.name = name;
        this.dob = dob;
        this.title = title;
        this.description = description;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public LocalDate getDob() { return dob; }
    public void setDob(LocalDate dob) { this.dob = dob; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
