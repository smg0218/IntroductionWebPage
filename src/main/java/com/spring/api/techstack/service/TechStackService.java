package com.spring.api.techstack.service;

import com.spring.api.techstack.dto.request.TechStackAddRequestDTO;
import com.spring.api.techstack.repository.TechStackRepository;
import com.spring.entity.TechStack;
import com.spring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class TechStackService {
    private final TechStackRepository techStackRepository;
    private final UserRepository userRepository;

    // 기술 추가
    public void addTechStack(TechStackAddRequestDTO dto) {
        TechStack techStack = dto.toEntity(dto);
        techStackRepository.save(techStack);
    }
}
