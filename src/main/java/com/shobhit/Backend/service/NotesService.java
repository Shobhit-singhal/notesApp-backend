package com.shobhit.Backend.service;

import com.shobhit.Backend.dto.NoteReqDTO;
import com.shobhit.Backend.dto.NoteResponseDTO;
import com.shobhit.Backend.entity.Note;
import com.shobhit.Backend.entity.User;
import com.shobhit.Backend.repository.NotesRepo;
import com.shobhit.Backend.repository.UserRepo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.List;

@Service
public class NotesService {
    @Autowired
    private NotesRepo notesRepo;

    @Autowired
    private UserRepo userRepo;

    public List<NoteResponseDTO> getNotes(String username) {
        User user=userRepo.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("Username not found"));
        List<Note> notes=user.getNotes();
        List<NoteResponseDTO> retNotes=new ArrayList<>();
        for (Note note: notes){
            retNotes.add(NoteResponseDTO.builder()
                    .id(note.getId())
                    .title(note.getTitle())
                    .date(note.getDate())
                    .content(note.getContent())
                    .build());
        }
        return retNotes;
    }

    @Transactional
    public NoteResponseDTO addNote(String name, @Valid NoteReqDTO note) {
        User user=userRepo.findByUsername(name).orElseThrow(()->new UsernameNotFoundException("Username not found"));
        Note note1=Note.builder()
                .title(note.getTitle())
                .content(note.getContent())
                .postedBy(user)
                .build();
        Note saved=notesRepo.save(note1);
        user.getNotes().add(saved);
        userRepo.save(user);
        return NoteResponseDTO.builder()
                .id(saved.getId())
                .content(saved.getContent())
                .title(saved.getTitle())
                .date(saved.getDate())
                .build();
    }

    public List<NoteResponseDTO> findByTitle(String name, String title) {
        User user=userRepo.findByUsername(name)
                .orElseThrow(()->new UsernameNotFoundException("Username not found"));
        List<Note> notes=notesRepo.findByTitleContainingAndPostedBy(title,user)
                .orElseThrow(()->new UsernameNotFoundException("no such user"));
        List<NoteResponseDTO> retNotes=new ArrayList<>();
        for (Note note:notes){
            retNotes.add(NoteResponseDTO.builder()
                    .id(note.getId())
                    .title(note.getTitle())
                    .date(note.getDate())
                    .content(note.getContent())
                    .build());
        }
        return retNotes;
    }

    @Transactional
    public void deleteNote(String name, long id) throws AccessDeniedException {
        User user=userRepo.findByUsername(name)
                .orElseThrow(()->new UsernameNotFoundException("Username not found"));
        Note note=notesRepo.findById(id).orElseThrow(()->new EntityNotFoundException("Post not found"));
        if(note.getPostedBy().getUsername().equals(name)){
            user.getNotes().remove(note);
            notesRepo.delete(note);
        }else {
            throw new AccessDeniedException("You arent authorized to delete it");
        }
    }

    public NoteResponseDTO getById(String name, long id) throws AccessDeniedException {
        Note note=notesRepo.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("No note exist with id: "+id));
        System.out.println("hey");
        if(note.getPostedBy().getUsername().equals(name)){
            System.out.println("Hey 2");
            return NoteResponseDTO.builder()
                    .id(note.getId())
                    .title(note.getTitle())
                    .content(note.getContent())
                    .date(note.getDate())
                    .build();
        }else{
            throw new AccessDeniedException("Access is denied");
        }
    }
}
