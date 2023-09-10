package com.bgs.market.application.client.persistence;

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

/**
 * Class for Client.
 */
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
    private Long clientTypeId;

    @Column(nullable = false)
    private String clientName;

    @Column(nullable = false)
    private Long documentType;

    @Column(nullable = false)
    private String documentNumber;

    @Column()
    private String clientDirection;

    @Column()
    private String ubigeo;

    @Column()
    private String phoneNumber;

    @Column()
    private String clientEmail;

    @Column(nullable = false)
    private Integer state = 1;

}
