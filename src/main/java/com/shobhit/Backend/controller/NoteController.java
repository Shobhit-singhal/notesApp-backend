package com.shobhit.Backend.controller;

import com.shobhit.Backend.dto.NoteReqDTO;
import com.shobhit.Backend.dto.NoteResponseDTO;
import com.shobhit.Backend.service.NotesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {
    @Autowired
    private NotesService notesService;

    @GetMapping
    public List<NoteResponseDTO> getNotes(Authentication authentication){
        return notesService.getNotes(authentication.getName());
    }
    @PostMapping
    public NoteResponseDTO addNote(Authentication authentication, @Valid @RequestBody NoteReqDTO note){
        return notesService.addNote(authentication.getName(),note);
    }
}
