package com.example.gallery.dto;


import com.example.gallery.domain.Image;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Lob;

@Data
@NoArgsConstructor
public class ImageDto {

    private Long id;
    private String filename;

    @Lob
    private byte[] filedata;

    public ImageDto(Image image) {
        this.id = image.getId();
        this.filename = image.getFilename();
        this.filedata = image.getFiledata();
    }

}
