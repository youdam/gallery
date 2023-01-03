package com.example.gallery.dtos;

import com.example.gallery.domain.GroupEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.text.html.parser.Entity;

@Data
@NoArgsConstructor
public class GroupDto {

    private String groupname;

    private String groupleader;

    private String descript;

    public GroupDto(GroupEntity groupEntity){
        this.groupname = groupEntity.getGroupname();
        this.groupleader = groupEntity.getGroupleader();
        this.descript = groupEntity.getDescript();
    }
}
