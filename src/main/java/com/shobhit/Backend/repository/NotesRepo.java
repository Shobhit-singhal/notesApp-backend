package com.shobhit.Backend.repository;

import com.shobhit.Backend.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotesRepo extends JpaRepository<Note,Long> {
}
