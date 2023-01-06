package com.example.gallery.repositories;

import com.example.gallery.domain.BoardEntity;
import com.example.gallery.domain.FileEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FileRepository extends JpaRepository<FileEntity,Long> {

    @Query("SELECT f FROM FileEntity f WHERE f.boardEntity = :boardEntity")
    List<FileEntity> findByBoardEntity(@Param("boardEntity") BoardEntity boardEntity);

}
