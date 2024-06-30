package com.spring.api.techstack.dto.request;

import com.spring.entity.TechStack;
import lombok.*;

@Data
@NoArgsConstructor
public class TechStackAddRequestDTO {
    private String techName;
    private String techInfo;

    // DTO를 Entity화 하기
    public TechStack toEntity(TechStackAddRequestDTO dto) {
        TechStack techStack = new TechStack();

        techStack.setTechName(dto.techName);
        techStack.setTechInfo(techInfo);

        return techStack;
    }
}
