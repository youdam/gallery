package com.example.gallery.repositories;

import com.example.gallery.domain.GroupManageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupManageRepository extends JpaRepository<GroupManageEntity, Long> {
}
