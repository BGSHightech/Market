package com.bgs.market.persistence.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "client")
public class Client {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;

    @Column(nullable = false)
    private String clientName;

    @Column(nullable = false)
    private String documentNumber;

    @Column()
    private String clientDirection;

    @Column()
    private String phoneNumber;

    @Column()
    private String clientEmail;

    @Column(nullable = false)
    private Integer state = 1;

}
