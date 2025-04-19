package com.shobhit.Backend.controller;

import com.shobhit.Backend.dto.NoteReqDTO;
import com.shobhit.Backend.dto.NoteResponseDTO;
import com.shobhit.Backend.service.NotesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;
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
    @GetMapping("/{title}")
    public List<NoteResponseDTO> findByTitle(Authentication authentication,@PathVariable String title){
        return notesService.findByTitle(authentication.getName(),title);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(Authentication authentication, @PathVariable long id) throws AccessDeniedException {
        notesService.deleteNote(authentication.getName(),id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/id/{id}")
    public NoteResponseDTO getById(Authentication authentication,@PathVariable long id) throws AccessDeniedException {
        return notesService.getById(authentication.getName(),id);
    }
}
