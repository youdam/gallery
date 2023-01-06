package com.example.gallery.services;

import com.example.gallery.domain.GroupEntity;
import com.example.gallery.repositories.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GroupService {

    private final GroupRepository groupRepository;


    @Transactional
    public void create(GroupEntity group) {
        groupRepository.save(group);
    }

    @Transactional
    public void update(String groupname, String descript, String oldGroupName) {
        GroupEntity findGroup = groupRepository.findById(oldGroupName).orElseThrow(NullPointerException::new);
        findGroup.setGroupname(groupname);
        findGroup.setDescript(descript);
    }

    public GroupEntity findOne(String groupname) {
        return groupRepository.findById(groupname).orElseThrow(NullPointerException::new);
    }

    @Transactional
    public void delete(GroupEntity group) {
        groupRepository.delete(group);
    }
}
