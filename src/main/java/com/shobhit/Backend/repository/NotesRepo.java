package com.shobhit.Backend.repository;

import com.shobhit.Backend.entity.Note;
import com.shobhit.Backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NotesRepo extends JpaRepository<Note,Long> {
    public Optional<List<Note>> findByTitleContainingAndPostedBy(String title, User postedBy);
}
