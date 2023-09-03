package com.bgs.market.persistence.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clientType")
public class ClientType {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientTypeId;

    @Column(nullable = false)
    private String clientTypeName;

    @Column(nullable = false)
    private Integer state = 1;

}
