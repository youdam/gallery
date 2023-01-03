package com.example.gallery.dtos;


import com.example.gallery.domain.MemberEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
//create랑 update기능 안쓸거니까 걍 안쓸거는 뺌
@Data
@NoArgsConstructor
public class MemberDto {

    private String userid;

    private String usernickname;

    private String useremail;

    private String profiledata;

    public MemberDto(MemberEntity memberEntity){
        this.userid = memberEntity.getUserid();
        this.usernickname = memberEntity.getUsernickname();
        this.useremail = memberEntity.getUseremail();
        this.profiledata = memberEntity.getProfiledata();
    }
}
