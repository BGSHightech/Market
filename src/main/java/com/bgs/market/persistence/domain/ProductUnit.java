package com.bgs.market.persistence.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "productUnit")
public class ProductUnit {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productUnitId;

    @Column(nullable = false)
    private String productUnitName;

    @Column(nullable = false)
    private Integer state = 1;
}
