package com.example.gallery.services;

import com.example.gallery.domain.CommentEntity;
import com.example.gallery.repositories.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;


    @Transactional
    public void create(CommentEntity comment) {
        commentRepository.save(comment);
    }

    @Transactional
    public void update(Long contentNo, String content) {
        CommentEntity findComment = commentRepository.findById(contentNo).orElseThrow(NullPointerException::new);
        findComment.setContent(content);
    }

    public CommentEntity findOne(Long contentNo) {
        return commentRepository.findById(contentNo).orElseThrow(NullPointerException::new);

    }

    @Transactional
    public void delete(CommentEntity comment) {
        commentRepository.delete(comment);
    }

    public List<CommentEntity> findByBoardId(Long no) {
        return commentRepository.findByContentNo(no);
    }
}
