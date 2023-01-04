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
    @Column (name = "no", nullable = false)
    private Long no;

    @Column(name = "filedata", nullable = false)
    private String filedata;

    @Column(name = "content_no", nullable = false)
    private Long contentNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "content_no", referencedColumnName = "no", insertable = false, updatable = false)
    private BoardEntity boardEntity;


    public FileEntity(Long no,
                      String filedata, Long contentNo){
        this.no =no;
        this.filedata = filedata;
        this.contentNo =contentNo;
    }
}