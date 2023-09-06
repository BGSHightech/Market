package com.bgs.market.persistence.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "province")
public class Province {

    @Id
    @Column(nullable = false)
    private String provinceId;

    @Column(nullable = false)
    private String provinceName;

}
