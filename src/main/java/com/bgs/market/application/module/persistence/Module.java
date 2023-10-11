package com.bgs.market.application.module.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Class for Module.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "module")
public class Module {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long moduleId;

    @Column(nullable = false)
    private String moduleName;

    @Column(nullable = false)
    private Integer state = 1;

}
