package com.cars24.noteapp.controller;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.cars24.noteapp.entities.NoteEntity;
import com.cars24.noteapp.service.NoteService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {NoteController.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class NoteControllerDiffblueTest {
    @Autowired
    private NoteController noteController;

    @MockBean
    private NoteService noteService;

    /**
     * Test {@link NoteController#getAllNotes()}.
     * <p>
     * Method under test: {@link NoteController#getAllNotes()}
     */
    @Test
    @DisplayName("Test getAllNotes()")
    @Tag("MaintainedByDiffblue")
    void testGetAllNotes() throws Exception {
        // Arrange
        when(noteService.getAllNotes()).thenReturn(null);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/notes");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(noteController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Test {@link NoteController#getNoteById(String)}.
     * <p>
     * Method under test: {@link NoteController#getNoteById(String)}
     */
    @Test
    @DisplayName("Test getNoteById(String)")
    @Tag("MaintainedByDiffblue")
    void testGetNoteById() throws Exception {
        // Arrange
        NoteEntity noteEntity = new NoteEntity();
        noteEntity.setDescription("The characteristics of someone or something");
        noteEntity.setDob(LocalDate.of(1970, 1, 1));
        noteEntity.setId("42");
        noteEntity.setName("Name");
        noteEntity.setTitle("Dr");
        Optional<NoteEntity> ofResult = Optional.of(noteEntity);
        when(noteService.getNoteById(Mockito.<String>any())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/notes/{id}", "42");

        // Act and Assert
        MockMvcBuilders.standaloneSetup(noteController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":\"42\",\"name\":\"Name\",\"dob\":[1970,1,1],\"title\":\"Dr\",\"description\":\"The characteristics of someone"
                                        + " or something\"}"));
    }

    /**
     * Test {@link NoteController#createNote(NoteEntity)}.
     * <ul>
     *   <li>Then status {@link StatusResultMatchers#isOk()}.</li>
     * </ul>
     * <p>
     * Method under test: {@link NoteController#createNote(NoteEntity)}
     */
    @Test
    @DisplayName("Test createNote(NoteEntity); then status isOk()")
    @Tag("MaintainedByDiffblue")
    void testCreateNote_thenStatusIsOk() throws Exception {
        // Arrange
        NoteEntity noteEntity = new NoteEntity();
        noteEntity.setDescription("The characteristics of someone or something");
        noteEntity.setDob(LocalDate.of(1970, 1, 1));
        noteEntity.setId("42");
        noteEntity.setName("Name");
        noteEntity.setTitle("Dr");
        when(noteService.createNote(Mockito.<NoteEntity>any())).thenReturn(noteEntity);

        NoteEntity noteEntity2 = new NoteEntity();
        noteEntity2.setDescription("The characteristics of someone or something");
        noteEntity2.setDob(null);
        noteEntity2.setId("42");
        noteEntity2.setName("Name");
        noteEntity2.setTitle("Dr");
        String content = (new ObjectMapper()).writeValueAsString(noteEntity2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/notes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(noteController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":\"42\",\"name\":\"Name\",\"dob\":[1970,1,1],\"title\":\"Dr\",\"description\":\"The characteristics of someone"
                                        + " or something\"}"));
    }

    /**
     * Test {@link NoteController#updateNote(String, NoteEntity)}.
     * <ul>
     *   <li>Then status {@link StatusResultMatchers#isOk()}.</li>
     * </ul>
     * <p>
     * Method under test: {@link NoteController#updateNote(String, NoteEntity)}
     */
    @Test
    @DisplayName("Test updateNote(String, NoteEntity); then status isOk()")
    @Tag("MaintainedByDiffblue")
    void testUpdateNote_thenStatusIsOk() throws Exception {
        // Arrange
        NoteEntity noteEntity = new NoteEntity();
        noteEntity.setDescription("The characteristics of someone or something");
        noteEntity.setDob(LocalDate.of(1970, 1, 1));
        noteEntity.setId("42");
        noteEntity.setName("Name");
        noteEntity.setTitle("Dr");
        when(noteService.updateNote(Mockito.<String>any(), Mockito.<NoteEntity>any())).thenReturn(noteEntity);

        NoteEntity noteEntity2 = new NoteEntity();
        noteEntity2.setDescription("The characteristics of someone or something");
        noteEntity2.setDob(null);
        noteEntity2.setId("42");
        noteEntity2.setName("Name");
        noteEntity2.setTitle("Dr");
        String content = (new ObjectMapper()).writeValueAsString(noteEntity2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/notes/{id}", "42")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);

        // Act and Assert
        MockMvcBuilders.standaloneSetup(noteController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":\"42\",\"name\":\"Name\",\"dob\":[1970,1,1],\"title\":\"Dr\",\"description\":\"The characteristics of someone"
                                        + " or something\"}"));
    }

    /**
     * Test {@link NoteController#deleteNoteById(String)}.
     * <p>
     * Method under test: {@link NoteController#deleteNoteById(String)}
     */
    @Test
    @DisplayName("Test deleteNoteById(String)")
    @Tag("MaintainedByDiffblue")
    void testDeleteNoteById() throws Exception {
        // Arrange
        doNothing().when(noteService).deleteNoteById(Mockito.<String>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/notes/{id}", "42");

        // Act
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(noteController).build().perform(requestBuilder);

        // Assert
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
    }
}
