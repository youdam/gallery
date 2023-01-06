package com.example.gallery.domain;

import com.example.gallery.dtos.GroupDto;
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
    @Column (name = "groupname", nullable = false)
    private String groupname;

    @Column(name = "groupleader", nullable = false)
    private String groupleader;

    @Column(name = "descript", nullable = false)
    private String descript;

    @Column(name = "time", nullable = false)
    private LocalDateTime time;




    public GroupEntity(GroupDto groupDto){
        this.groupname = groupDto.getGroupname();
        this.descript = groupDto.getDescript();
        this.time = LocalDateTime.now();
    }



}
