package com.example.gallery.services;

import com.example.gallery.domain.FileEntity;
import com.example.gallery.repositories.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FileService {

    private final FileRepository fileRepository;

    @Transactional
    public void create(FileEntity file) {
        fileRepository.save(file);


    }

    @Transactional
    public void createFile(FileEntity file) {
        fileRepository.save(file);
    }
}
