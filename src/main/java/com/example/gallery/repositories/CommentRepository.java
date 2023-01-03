package com.example.gallery.repositories;

import com.example.gallery.domain.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

    List<Comment> findByBoardId(Long contentNo);
}
