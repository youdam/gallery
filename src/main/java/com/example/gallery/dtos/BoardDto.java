package com.example.gallery.dtos;


import com.example.gallery.domain.BoardEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BoardDto {

    private Long no;

    private String title;

    private String userid;

    private String content;

    private Long readcount;

    private String groupname;



    public BoardDto(BoardEntity boardEntity) {
        this.no = boardEntity.getNo();
        this.title = boardEntity.getTitle();
        this.userid = boardEntity.getUserid();
        this.content = boardEntity.getContent();
        this.readcount = boardEntity.getReadcount();
        this.groupname = boardEntity.getGroupname();
    }




}

