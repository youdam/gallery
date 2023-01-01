package com.example.gallery.dto;


import com.example.gallery.domain.Comment;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;

@Data
@NoArgsConstructor
public class CommentDto {

    private Long boardId;         // 게시글 이랑 연동. 이걸로

    private String userId;

    private Long content_no;

    private String content;


    public CommentDto(Comment comment){
        this.boardId = comment.getBoardId();
        this.userId = comment.getUserId();
        this.content_no = comment.getContent_no();
        this.content = comment.getContent();
    }

}
