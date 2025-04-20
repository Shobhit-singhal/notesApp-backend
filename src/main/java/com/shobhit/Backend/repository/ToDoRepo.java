package com.shobhit.Backend.repository;

import com.shobhit.Backend.entity.ToDo;
import com.shobhit.Backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ToDoRepo extends JpaRepository<ToDo,Long> {
    Optional<ToDo> findByIdAndUser(long id, User user);
}
