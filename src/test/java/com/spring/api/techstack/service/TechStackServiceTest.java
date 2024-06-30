package com.spring.api.techstack.service;

import com.spring.api.techstack.dto.request.TechStackAddRequestDTO;
import com.spring.api.techstack.dto.response.TechStackListResponseDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TechStackServiceTest {

    @Autowired
    TechStackService techStackService;

    @Test
    @DisplayName("새로운 테크스택을 하나 생성해서 디비에 저장한다")
     void saveTest() {
        //given
        TechStackAddRequestDTO dto = new TechStackAddRequestDTO();
        dto.setTechName("테스트");
//        dto.setTechInfo(null);
        dto.setTechInfo("test");

        TechStackListResponseDTO beforeDTO = techStackService.retrieveTechStack();
        int listLength = beforeDTO.getTechStacks().size();

        //when
        techStackService.addTechStack(dto);

        //then
        TechStackListResponseDTO afterDTO = techStackService.retrieveTechStack();

        assertEquals(listLength+1, afterDTO.getTechStacks().size());
    }
}