package com.bgs.market.persistence.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "parameter")
public class Parameter {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long parameterId;

    @Column(nullable = false)
    private String parameterType;

    @Column(nullable = false)
    private String value;

    @Column(nullable = false)
    private Integer state = 1;

    @Column()
    private String valueString1;

    @Column()
    private String valueString2;

    @Column()
    private String valueString3;

    @Column()
    private Integer valueInt1;

    @Column()
    private Integer valueInt2;

    @Column()
    private Integer valueInt3;

    @Column()
    private Double valueDouble1;

    @Column()
    private Double valueDouble2;

    @Column()
    private Double valueDouble3;

}
