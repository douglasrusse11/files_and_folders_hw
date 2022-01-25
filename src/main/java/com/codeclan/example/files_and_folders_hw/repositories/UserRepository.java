package com.codeclan.example.files_and_folders_hw.repositories;

import com.codeclan.example.files_and_folders_hw.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
