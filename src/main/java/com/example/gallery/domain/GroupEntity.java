package com.example.gallery.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table( name = "group_tb")
@ToString
@NoArgsConstructor
public class GroupEntity {


    @Id
    private String groupname;

    @Column(name = "groupleader", nullable = false)
    private String groupleader;

    @Column(name = "descript", nullable = false)
    private String descript;

    @Column(name = "time", nullable = false)
    private LocalDateTime time;




    public GroupEntity(String groupname, String groupleader,
                       String descript, LocalDateTime time){
        this.groupname = groupname;
        this.groupleader = groupleader;
        this.descript = descript;
        this.time = time;
    }

}
