package com.bgs.market.application.department.persistence;

import com.bgs.market.application.province.persistence.Province;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Class for Department.
 */
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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "departmentId", referencedColumnName = "departmentId")
    private List<Province> provinces;

}
