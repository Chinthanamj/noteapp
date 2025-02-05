package com.cars24.noteapp.service;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.cars24.noteapp.entities.NoteEntity;
import com.cars24.noteapp.repository.NoteRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {NoteService.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class NoteServiceDiffblueTest {
    @MockBean
    private NoteRepository noteRepository;

    @Autowired
    private NoteService noteService;

    /**
     * Test {@link NoteService#getAllNotes()}.
     * <p>
     * Method under test: {@link NoteService#getAllNotes()}
     */
    @Test
    @DisplayName("Test getAllNotes()")
    @Tag("MaintainedByDiffblue")
    void testGetAllNotes() {
        // Arrange
        when(noteRepository.findAll()).thenReturn(null);

        // Act
        List<NoteEntity> actualAllNotes = noteService.getAllNotes();

        // Assert
        verify(noteRepository).findAll();
        assertNull(actualAllNotes);
    }

    /**
     * Test {@link NoteService#getNoteById(String)}.
     * <p>
     * Method under test: {@link NoteService#getNoteById(String)}
     */
    @Test
    @DisplayName("Test getNoteById(String)")
    @Tag("MaintainedByDiffblue")
    void testGetNoteById() {
        // Arrange
        NoteEntity noteEntity = new NoteEntity();
        noteEntity.setDescription("The characteristics of someone or something");
        noteEntity.setDob(LocalDate.of(1970, 1, 1));
        noteEntity.setId("42");
        noteEntity.setName("Name");
        noteEntity.setTitle("Dr");
        Optional<NoteEntity> ofResult = Optional.of(noteEntity);
        when(noteRepository.findById(Mockito.<String>any())).thenReturn(ofResult);

        // Act
        Optional<NoteEntity> actualNoteById = noteService.getNoteById("42");

        // Assert
        verify(noteRepository).findById(eq("42"));
        assertSame(ofResult, actualNoteById);
    }

    /**
     * Test {@link NoteService#createNote(NoteEntity)}.
     * <p>
     * Method under test: {@link NoteService#createNote(NoteEntity)}
     */
    @Test
    @DisplayName("Test createNote(NoteEntity)")
    @Tag("MaintainedByDiffblue")
    void testCreateNote() {
        // Arrange
        NoteEntity noteEntity = new NoteEntity();
        noteEntity.setDescription("The characteristics of someone or something");
        noteEntity.setDob(LocalDate.of(1970, 1, 1));
        noteEntity.setId("42");
        noteEntity.setName("Name");
        noteEntity.setTitle("Dr");
        when(noteRepository.save(Mockito.<NoteEntity>any())).thenReturn(noteEntity);

        NoteEntity note = new NoteEntity();
        note.setDescription("The characteristics of someone or something");
        note.setDob(LocalDate.of(1970, 1, 1));
        note.setId("42");
        note.setName("Name");
        note.setTitle("Dr");

        // Act
        NoteEntity actualCreateNoteResult = noteService.createNote(note);

        // Assert
        verify(noteRepository).save(isA(NoteEntity.class));
        assertSame(noteEntity, actualCreateNoteResult);
    }

    /**
     * Test {@link NoteService#updateNote(String, NoteEntity)}.
     * <ul>
     *   <li>Given {@link NoteRepository} {@link CrudRepository#findById(Object)}
     * return empty.</li>
     *   <li>Then throw {@link RuntimeException}.</li>
     * </ul>
     * <p>
     * Method under test: {@link NoteService#updateNote(String, NoteEntity)}
     */
    @Test
    @DisplayName("Test updateNote(String, NoteEntity); given NoteRepository findById(Object) return empty; then throw RuntimeException")
    @Tag("MaintainedByDiffblue")
    void testUpdateNote_givenNoteRepositoryFindByIdReturnEmpty_thenThrowRuntimeException() {
        // Arrange
        Optional<NoteEntity> emptyResult = Optional.empty();
        when(noteRepository.findById(Mockito.<String>any())).thenReturn(emptyResult);

        NoteEntity updatedNote = new NoteEntity();
        updatedNote.setDescription("The characteristics of someone or something");
        updatedNote.setDob(LocalDate.of(1970, 1, 1));
        updatedNote.setId("42");
        updatedNote.setName("Name");
        updatedNote.setTitle("Dr");

        // Act and Assert
        assertThrows(RuntimeException.class, () -> noteService.updateNote("42", updatedNote));
        verify(noteRepository).findById(eq("42"));
    }

    /**
     * Test {@link NoteService#updateNote(String, NoteEntity)}.
     * <ul>
     *   <li>Then return {@link NoteEntity#NoteEntity()}.</li>
     * </ul>
     * <p>
     * Method under test: {@link NoteService#updateNote(String, NoteEntity)}
     */
    @Test
    @DisplayName("Test updateNote(String, NoteEntity); then return NoteEntity()")
    @Tag("MaintainedByDiffblue")
    void testUpdateNote_thenReturnNoteEntity() {
        // Arrange
        NoteEntity noteEntity = new NoteEntity();
        noteEntity.setDescription("The characteristics of someone or something");
        noteEntity.setDob(LocalDate.of(1970, 1, 1));
        noteEntity.setId("42");
        noteEntity.setName("Name");
        noteEntity.setTitle("Dr");
        Optional<NoteEntity> ofResult = Optional.of(noteEntity);

        NoteEntity noteEntity2 = new NoteEntity();
        noteEntity2.setDescription("The characteristics of someone or something");
        noteEntity2.setDob(LocalDate.of(1970, 1, 1));
        noteEntity2.setId("42");
        noteEntity2.setName("Name");
        noteEntity2.setTitle("Dr");
        when(noteRepository.save(Mockito.<NoteEntity>any())).thenReturn(noteEntity2);
        when(noteRepository.findById(Mockito.<String>any())).thenReturn(ofResult);

        NoteEntity updatedNote = new NoteEntity();
        updatedNote.setDescription("The characteristics of someone or something");
        updatedNote.setDob(LocalDate.of(1970, 1, 1));
        updatedNote.setId("42");
        updatedNote.setName("Name");
        updatedNote.setTitle("Dr");

        // Act
        NoteEntity actualUpdateNoteResult = noteService.updateNote("42", updatedNote);

        // Assert
        verify(noteRepository).findById(eq("42"));
        verify(noteRepository).save(isA(NoteEntity.class));
        assertSame(noteEntity2, actualUpdateNoteResult);
    }

    /**
     * Test {@link NoteService#deleteNoteById(String)}.
     * <p>
     * Method under test: {@link NoteService#deleteNoteById(String)}
     */
    @Test
    @DisplayName("Test deleteNoteById(String)")
    @Tag("MaintainedByDiffblue")
    void testDeleteNoteById() {
        // Arrange
        doNothing().when(noteRepository).deleteById(Mockito.<String>any());

        // Act
        noteService.deleteNoteById("42");

        // Assert
        verify(noteRepository).deleteById(eq("42"));
    }
}
