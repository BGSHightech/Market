package com.bgs.market.application.province.persistence;

import com.bgs.market.application.district.persistence.District;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Class for Province.
 */
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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "provinceId", referencedColumnName = "provinceId")
    private List<District> districts;
}
