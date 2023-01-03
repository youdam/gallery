package com.example.gallery.dtos;

import com.example.gallery.domain.CommentEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
public class CommentDto {

    private Long no;

    private String userid;

    private Long contentNo;

    private String content;



    public CommentDto(CommentEntity commentEntity){
        this.no = commentEntity.getNo();
        this.userid = commentEntity.getUserid();
        this.contentNo = commentEntity.getContentNo();
        this.content = commentEntity.getContent();
    }

}
