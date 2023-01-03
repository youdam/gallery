package com.example.gallery.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "file_tb")
@Data
@NoArgsConstructor
@ToString
public class FileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    @Column(name = "filename", nullable = false)
    private String filename;

    @Column(name = "filedata", nullable = false)
    private String filedata;

    @Column(name = "content_no", nullable = false)
    private Long contentNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "content_no", referencedColumnName = "no", insertable = false, updatable = false)
    private BoardEntity boardEntity;


    public FileEntity(Long no, String filename,
                      String filedata, Long contentNo){
        this.no =no;
        this.filename = filename;
        this.filedata = filedata;
        this.contentNo =contentNo;
    }
}