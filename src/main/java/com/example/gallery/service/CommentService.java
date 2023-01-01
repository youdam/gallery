package com.example.gallery.service;

import com.example.gallery.domain.Comment;
import com.example.gallery.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CommentService {

        private final CommentRepository commentRepository;


        public Comment findOne(Long boardId) {
                return commentRepository.findById(boardId).orElseThrow(NullPointerException::new);
        }

        public List<Comment> findByBoardId(Long boardId) {
                return commentRepository.findByBoardId(boardId);

        }

        @Transactional
        public void create(Comment comment) {
                commentRepository.save(comment);
        }

        @Transactional
        public void update(Long content_no, String content) {
                Comment findComment = commentRepository.findById(content_no).orElseThrow(NullPointerException::new);
                findComment.setContent(content);
        }

        @Transactional
        public void delete(Comment comment) {
                commentRepository.delete(comment);
        }
}
