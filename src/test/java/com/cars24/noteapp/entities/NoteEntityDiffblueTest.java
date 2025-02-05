package com.cars24.noteapp.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class NoteEntityDiffblueTest {
    /**
     * Test getters and setters.
     * <p>
     * Methods under test:
     * <ul>
     *   <li>{@link NoteEntity#NoteEntity()}
     *   <li>{@link NoteEntity#setDescription(String)}
     *   <li>{@link NoteEntity#setDob(LocalDate)}
     *   <li>{@link NoteEntity#setId(String)}
     *   <li>{@link NoteEntity#setName(String)}
     *   <li>{@link NoteEntity#setTitle(String)}
     *   <li>{@link NoteEntity#getDescription()}
     *   <li>{@link NoteEntity#getDob()}
     *   <li>{@link NoteEntity#getId()}
     *   <li>{@link NoteEntity#getName()}
     *   <li>{@link NoteEntity#getTitle()}
     * </ul>
     */
    @Test
    @DisplayName("Test getters and setters")
    @Tag("MaintainedByDiffblue")
    void testGettersAndSetters() {
        // Arrange and Act
        NoteEntity actualNoteEntity = new NoteEntity();
        actualNoteEntity.setDescription("The characteristics of someone or something");
        LocalDate dob = LocalDate.of(1970, 1, 1);
        actualNoteEntity.setDob(dob);
        actualNoteEntity.setId("42");
        actualNoteEntity.setName("Name");
        actualNoteEntity.setTitle("Dr");
        String actualDescription = actualNoteEntity.getDescription();
        LocalDate actualDob = actualNoteEntity.getDob();
        String actualId = actualNoteEntity.getId();
        String actualName = actualNoteEntity.getName();
        String actualTitle = actualNoteEntity.getTitle();

        // Assert
        assertEquals("1970-01-01", actualDob.toString());
        assertEquals("42", actualId);
        assertEquals("Dr", actualTitle);
        assertEquals("Name", actualName);
        assertEquals("The characteristics of someone or something", actualDescription);
        assertSame(dob, actualDob);
    }

    /**
     * Test getters and setters.
     * <ul>
     *   <li>When {@code Name}.</li>
     * </ul>
     * <p>
     * Methods under test:
     * <ul>
     *   <li>{@link NoteEntity#NoteEntity(String, LocalDate, String, String)}
     *   <li>{@link NoteEntity#setDescription(String)}
     *   <li>{@link NoteEntity#setDob(LocalDate)}
     *   <li>{@link NoteEntity#setId(String)}
     *   <li>{@link NoteEntity#setName(String)}
     *   <li>{@link NoteEntity#setTitle(String)}
     *   <li>{@link NoteEntity#getDescription()}
     *   <li>{@link NoteEntity#getDob()}
     *   <li>{@link NoteEntity#getId()}
     *   <li>{@link NoteEntity#getName()}
     *   <li>{@link NoteEntity#getTitle()}
     * </ul>
     */
    @Test
    @DisplayName("Test getters and setters; when 'Name'")
    @Tag("MaintainedByDiffblue")
    void testGettersAndSetters_whenName() {
        // Arrange and Act
        NoteEntity actualNoteEntity = new NoteEntity("Name", LocalDate.of(1970, 1, 1), "Dr",
                "The characteristics of someone or something");
        actualNoteEntity.setDescription("The characteristics of someone or something");
        LocalDate dob = LocalDate.of(1970, 1, 1);
        actualNoteEntity.setDob(dob);
        actualNoteEntity.setId("42");
        actualNoteEntity.setName("Name");
        actualNoteEntity.setTitle("Dr");
        String actualDescription = actualNoteEntity.getDescription();
        LocalDate actualDob = actualNoteEntity.getDob();
        String actualId = actualNoteEntity.getId();
        String actualName = actualNoteEntity.getName();
        String actualTitle = actualNoteEntity.getTitle();

        // Assert
        assertEquals("1970-01-01", actualDob.toString());
        assertEquals("42", actualId);
        assertEquals("Dr", actualTitle);
        assertEquals("Name", actualName);
        assertEquals("The characteristics of someone or something", actualDescription);
        assertSame(dob, actualDob);
    }
}
