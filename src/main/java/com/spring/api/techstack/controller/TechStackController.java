package com.spring.api.techstack.controller;

import com.spring.api.techstack.dto.request.TechStackAddRequestDTO;
import com.spring.api.techstack.dto.response.TechStackListResponseDTO;
import com.spring.api.techstack.service.TechStackService;
import com.spring.exception.DTOIllegalArgumentException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/tech")
public class TechStackController {
    private final TechStackService techStackService;

    @GetMapping("list")
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

    @PostMapping("add")
    public ResponseEntity<?> addTechStack(@Validated @RequestBody TechStackAddRequestDTO dto,
                                          BindingResult result) {
        // 입력값 검증, 검증에 걸렸을 경우 400번 코드와 함께 메세지를 클라이언트에 전송
        if(result.hasErrors()) {
            log.error(result.toString());

            // 모든 오류 메시지를 추출하여 리스트로 변환
            List<String> errorMessages = result.getAllErrors().stream()
                    .map(ObjectError::getDefaultMessage)
                    .collect(Collectors.toList());

            return ResponseEntity
                    .badRequest()
                    .body(errorMessages)
                    ;
        }

        log.info("/api/v1/tech/add : POST!");
        log.info("reqDTO: {}", dto);

        try {
            techStackService.addTechStack(dto);

            return ResponseEntity.ok().body("성공적으로 추가되었습니다!");
        } catch (DTOIllegalArgumentException e) {
            log.error(e.getMessage());
            log.error(Arrays.toString(e.getStackTrace()));

            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage());
            log.error(Arrays.toString(e.getStackTrace()));

            return ResponseEntity.internalServerError().body("예상치 못한 오류가 발생했습니다!\n관리자에게 문의해주세요.");
        }
    }
}
