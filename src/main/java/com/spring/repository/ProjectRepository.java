package com.spring.repository;

import com.spring.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
