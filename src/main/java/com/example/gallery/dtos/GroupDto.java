package com.example.gallery.dtos;

import com.example.gallery.domain.GroupEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.parameters.P;

import javax.swing.text.html.parser.Entity;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class GroupDto {

    private String groupname;

    private String groupleader;

    private String descript;

    private LocalDateTime time;

    public GroupDto(GroupEntity groupEntity){
        this.groupname = groupEntity.getGroupname();
        this.groupleader = groupEntity.getGroupleader();
        this.descript = groupEntity.getDescript();
        this.time = groupEntity.getTime();
    }
}
