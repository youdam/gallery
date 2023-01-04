package com.example.gallery.dtos;

import com.example.gallery.domain.FileEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FileDto {

    private Long no;

    private String filedata;

    private Long contentNo;

    public FileDto (FileEntity fileEntity){
        this.no = fileEntity.getNo();
        this.filedata = fileEntity.getFiledata();
        this.contentNo = fileEntity.getContentNo();
    }
}
