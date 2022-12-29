package com.example.gallery.dto;


//dto : 레이어간 데이터 주고받을떄 편하게 주고받을수 있게 하는거임

import com.example.gallery.domain.Board;
import com.example.gallery.domain.ByteArrayMultipartFile;
import com.example.gallery.domain.Image;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Lob;

@Data
@NoArgsConstructor
public class BoardDto {
    private Long id;
    private String title;
    private String content;
    private String fileData;

    private String fileName;

    public BoardDto(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.fileData = board.getFiledata();
        this.fileName = board.getFilename();
    }
}