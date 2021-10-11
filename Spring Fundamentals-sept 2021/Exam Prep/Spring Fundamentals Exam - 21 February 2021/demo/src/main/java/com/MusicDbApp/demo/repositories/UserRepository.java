package com.MusicDbApp.demo.repositories;

import com.MusicDbApp.demo.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
   // Optional<User> findByUserNameAndPassword(String username, String password);

  Optional< User> findByUserNameAndPassword(String name, String password);
}
