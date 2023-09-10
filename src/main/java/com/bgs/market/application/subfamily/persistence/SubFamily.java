package com.bgs.market.application.subfamily.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Class for SubFamily.
 */
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

    @Column(nullable = false)
    private Long familyId;
}
