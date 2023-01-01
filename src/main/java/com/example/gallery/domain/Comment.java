package com.example.gallery.domain;


import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "comment")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString( of = {"boardId", "content_no"})
public class Comment {


    private Long boardId;         // 게시글 이랑 연동. 이걸로. 하나의 게시글에 여러 댓글이 달릴 수 있으므로 이거는 PRIMARYKEY가 될 수 없음

    private String userId;

    @Id
    @GeneratedValue
    private Long content_no;

    private String content;


    public Comment(Long boardId, String userId, Long content_no, String content){
        this.boardId = boardId;
        this.userId = userId;
        this.content_no = content_no;
        this.content = content;
    }
}
