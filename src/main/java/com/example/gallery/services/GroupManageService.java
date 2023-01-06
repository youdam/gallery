/*
package com.example.gallery.services;

import com.example.gallery.domain.GroupManageEntity;
import com.example.gallery.repositories.GroupManageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional( readOnly = true )
public class GroupManageService {

    private final GroupManageRepository groupManageRepository;
    public List<GroupManageEntity> findByUserId(String userid) {

        return groupManageRepository.findByUserId(userid);

    }
}
*/