package com.spring.repository;

import com.spring.entity.TechStack;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechStackRepository extends JpaRepository<TechStack, Long> {
}
