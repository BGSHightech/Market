package com.bgs.market.persistence.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    @Column(nullable = false)
    private String nameForSale;

    @Column(nullable = false)
    private String nameForPurchase;

    @Column(nullable = false)
    private Float Factor;

    @Column(nullable = false)
    private String imageProduct;

    @Column(nullable = false)
    private Integer state = 1;

}
