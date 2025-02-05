package com.cars24.noteapp.service;

import com.cars24.noteapp.entities.NoteEntity;
import com.cars24.noteapp.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public List<NoteEntity> getAllNotes() {
        return noteRepository.findAll();
    }

    public Optional<NoteEntity> getNoteById(String id) {
        return noteRepository.findById(id);
    }

    public NoteEntity createNote(NoteEntity note) {
        return noteRepository.save(note);
    }

    public NoteEntity updateNote(String id, NoteEntity updatedNote) {
        return noteRepository.findById(id)
                .map(existingNote -> {
                    existingNote.setName(updatedNote.getName());
                    existingNote.setDob(updatedNote.getDob());
                    existingNote.setTitle(updatedNote.getTitle());
                    existingNote.setDescription(updatedNote.getDescription());
                    return noteRepository.save(existingNote);
                })
                .orElseThrow(() -> new RuntimeException("Note not found"));
    }

    public void deleteNoteById(String id) {
        noteRepository.deleteById(id);
    }
}
