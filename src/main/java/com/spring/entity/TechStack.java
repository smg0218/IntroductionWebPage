package com.spring.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
public class TechStack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tech_id")
    private Long techId;

    // 기술 이름
    @Column(name = "tech_name",nullable = false, updatable = false)
    private String techName;

    // 기술 설명, 필요할 경우에 넣기
    @Column(name = "tech_info", columnDefinition = "TEXT")
    private String techInfo;
}
