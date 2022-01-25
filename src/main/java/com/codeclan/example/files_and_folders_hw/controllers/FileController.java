package com.codeclan.example.files_and_folders_hw.controllers;

import com.codeclan.example.files_and_folders_hw.models.File;
import com.codeclan.example.files_and_folders_hw.repositories.FileRepository;
import com.codeclan.example.files_and_folders_hw.repositories.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FileController {
    @Autowired
    FileRepository fileRepository;

    @Autowired
    FolderRepository folderRepository;

    @GetMapping(value = "/files")
    public ResponseEntity<List<File>> getFiles() {
        return new ResponseEntity<>(fileRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/files/{id}")
    public ResponseEntity<Optional<File>> getFile(@PathVariable Long id) {
        return new ResponseEntity<>(fileRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/files")
    public ResponseEntity<File> createFile(@RequestBody File file) {
        fileRepository.save(file);
        return new ResponseEntity<>(file, HttpStatus.CREATED);
    }

}
