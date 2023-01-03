package com.example.gallery.dtos;

import com.example.gallery.domain.GroupManageEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@NoArgsConstructor
public class GroupManageDto {

    private Long no;

    private String userid;

    private String groupname;

    private Long grade;

    public GroupManageDto (GroupManageEntity groupManageEntity){
        this.no = groupManageEntity.getNo();
        this.userid = groupManageEntity.getUserid();
        this.groupname = groupManageEntity.getGroupname();
        this.grade = groupManageEntity.getGrade();
    }
}
