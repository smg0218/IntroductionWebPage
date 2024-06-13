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
public class License {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "license_id",nullable = false)
    private Long licenseId;

    @Column(name = "license_name",nullable = false, updatable = false)
    private String licenseName;

    @Column(name = "license_number", nullable = false, updatable = false)
    private String licenseNumber;

    @Column(name = "license_issuer")
    private String licenseIssuer;

    @Column(name = "license_get_date", nullable = false, updatable = false)
    private LocalDateTime licenseGetDate;
}
