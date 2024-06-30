package com.spring.api.techstack.dto.request;

import com.spring.entity.TechStack;
import lombok.*;

import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TechStackAddRequestDTO {
    @Size(min = 1, max = 255, message = "테크명은 1자 이상, 255자 이하로 입력해야 합니다.")
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
