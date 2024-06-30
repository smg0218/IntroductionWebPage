package com.spring.api.techstack.dto.response;

import com.spring.entity.TechStack;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TechStackListResponseDTO {
    private String error; // 에러 발생 시 에러로그를 전달하는 곳
    private List<TechStack> techStacks; // techStack 리스트
}
