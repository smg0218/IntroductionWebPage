package com.spring.api.techstack.controller;

import com.spring.api.techstack.dto.response.TechStackListResponseDTO;
import com.spring.api.techstack.service.TechStackService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/tech")
public class TechStackController {
    private final TechStackService techStackService;

    @GetMapping()
    public ResponseEntity<?> techStackList() {
        log.info("/api/v1/tech/list : GET!");

        try {
            TechStackListResponseDTO techStackList = techStackService.retrieveTechStack();

            log.info("techStackList : {}", techStackList);

            if(techStackList.getTechStacks().isEmpty()) {
                techStackList.setError("아직 테크스택이 없습니다!");
            }

            return ResponseEntity.ok().body(techStackList);
        } catch (Exception e) {
            log.error("에러 메세지 : {}", e.getMessage());
            log.error(Arrays.toString(e.getStackTrace()));

            return ResponseEntity.internalServerError().body(
                    TechStackListResponseDTO.builder().error("알 수 없는 오류 발생!").build()
            );
        }
    }
}
