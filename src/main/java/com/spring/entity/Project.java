package com.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id",nullable = false)
    private Long projectId;

    // 프로젝트명
    @Column(name = "project_name",nullable = false, updatable = false)
    private String projectName;

    // 프로젝트에서 나의 역할
    @Column(name = "project_my_role", nullable = false, updatable = false)
    private String projectMyRole;

    // 프로젝트 시작 날짜
    @Column(name = "project_begin_date", nullable = false, updatable = false)
    private LocalDateTime projectBeginDate;

    // 프로젝트 끝 날짜, 비어있으면 현재까지도 진행중
    @Column(name = "project_end_date")
    @Builder.Default
    private LocalDateTime projectEndDate = null;
}
