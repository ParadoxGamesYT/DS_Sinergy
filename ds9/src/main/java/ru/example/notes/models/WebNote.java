package ru.example.notes.models;

//Модель WebNote
public class WebNote {
    private int id;
    private String note;

    public WebNote(int id, String note) {
        this.id = id;
        this.note = note;
    }

    public WebNote() {
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }
}
