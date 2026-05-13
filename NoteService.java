package com.example.notesapi.service;

import com.example.notesapi.model.Note;
import com.example.notesapi.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    private final NoteRepository repository;

    public NoteService(NoteRepository repository) {
        this.repository = repository;
    }

    public List<Note> getAllNotes() {
        return repository.findAll();
    }

    public Note getNoteById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Note not found"));
    }

    public Note createNote(Note note) {
        return repository.save(note);
    }

    public Note updateNote(Long id, Note updatedNote) {
        Note note = getNoteById(id);
        note.setTitle(updatedNote.getTitle());
        note.setContent(updatedNote.getContent());
        return repository.save(note);
    }

    public void deleteNote(Long id) {
        repository.deleteById(id);
    }
}
