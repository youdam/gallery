package com.example.gallery.domain;


import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@Table(name = "image")
@NoArgsConstructor
@ToString(of = {"id", "filedata"})
public class Image {

    @Id
    @GeneratedValue
    private Long id;

    private String filename;

    @Lob
    private byte[] filedata;


    public Image(Long id, String filename, byte[] filedata){
        this.id = id;
        this.filename = filename;
        this.filedata = filedata;
    }

}
