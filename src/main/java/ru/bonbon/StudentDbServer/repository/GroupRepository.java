package ru.bonbon.StudentDbServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.bonbon.StudentDbServer.entity.Group;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
