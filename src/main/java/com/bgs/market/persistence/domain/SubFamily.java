package com.bgs.market.persistence.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "subFamily")
public class SubFamily {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subFamilyId;

    @Column(nullable = false)
    private String subFamilyName;

    @Column(nullable = false)
    private Integer state = 1;
}
