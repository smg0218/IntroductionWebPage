package com.spring.api.techstack.service;

import com.spring.api.techstack.dto.request.TechStackAddRequestDTO;
import com.spring.api.techstack.dto.response.TechStackListResponseDTO;
import com.spring.api.techstack.repository.TechStackRepository;
import com.spring.entity.TechStack;
import com.spring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TechStackService {
    private final TechStackRepository techStackRepository;

    // 기술 추가
    public void addTechStack(TechStackAddRequestDTO dto) {
        TechStack techStack = dto.toEntity(dto);
        techStackRepository.save(techStack);
    }

    public TechStackListResponseDTO retrieveTechStack() {
        List<TechStack> techStackList = techStackRepository.findAll();

        TechStackListResponseDTO techStackListRespDTO = new TechStackListResponseDTO();
        techStackListRespDTO.setTechStacks(techStackList);

        return techStackListRespDTO;
    }
}
