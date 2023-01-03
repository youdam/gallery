package com.example.gallery.repositories;

import com.example.gallery.domain.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<GroupEntity, String> {
}
