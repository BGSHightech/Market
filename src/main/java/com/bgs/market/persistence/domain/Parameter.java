package com.bgs.market.persistence.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
