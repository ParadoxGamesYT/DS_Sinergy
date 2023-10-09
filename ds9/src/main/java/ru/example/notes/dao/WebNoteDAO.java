package ru.example.notes.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ru.example.notes.models.WebNote;
@Component
public class WebNoteDAO {
    private static int NOTES_COUNT;
    private List<WebNote> notes;

    public WebNoteDAO() {
        notes = new ArrayList<WebNote>();
    }

    public List<WebNote> index() {
        return notes;
    }

    public WebNote show(int id) {
        return notes.stream().filter(n -> n.getId() == id).findAny().orElse(null);
    }

    public void save(WebNote webNote) {
        webNote.setId(++NOTES_COUNT);
        notes.add(webNote);
    }

    public void update(int id, WebNote updatedNote) {
        WebNote toUpdateNote = show(id);
        toUpdateNote.setNote(updatedNote.getNote());
    }

    public void delete(int id) {
        notes.removeIf(n -> n.getId() == id);
    }

}
