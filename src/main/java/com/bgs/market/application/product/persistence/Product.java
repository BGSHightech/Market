package com.bgs.market.application.product.persistence;

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
 * Class for Product.
 */
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
    private Long productId;

    @Column(nullable = false)
    private Long brandId;

    @Column(nullable = false)
    private String nameForSale;

    @Column(nullable = false)
    private String nameForPurchase;

    @Column(nullable = false)
    private Long productType;

    @Column(nullable = false)
    private Long unitType;

    @Column(nullable = false)
    private Long mainProductUnitId;

    @Column(nullable = false)
    private Long secondaryProductUnitId;

    @Column(nullable = false)
    private Float factor;

    @Column(nullable = false)
    private Long igvAffectation;

    @Column(nullable = false)
    private String imageProduct;

    @Column(nullable = false)
    private Integer state = 1;

}
