package com.bgs.market.persistence.domain;


import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "department")
public class Department {

    @Id
    @Column(nullable = false)
    private String departmentId;

    @Column(nullable = false)
    private String departmentName;
}
