package com.example.gallery.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data // @Getter @Setter 한번에 해줌
@Table(name = "board")
@NoArgsConstructor(access = AccessLevel.PROTECTED)  //빈생성자
@ToString(of = {"id"})
public class Board {
    @Id @GeneratedValue
    private Long id;

    private String title;
    private String content;

    @Lob
    private String filedata;

    private String filename;



    public Board(Long id, String title, String content, String filedata, String filename) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.filedata = filedata;
        this.filename = filename;
    }
}