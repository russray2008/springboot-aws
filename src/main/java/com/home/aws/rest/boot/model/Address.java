package com.home.aws.rest.boot.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;


@Entity(name="app_address")
public class Address{

    public Address(){}

    public Address(String street, String town, String county, String postCode) {
        this.street = street;
        this.town = town;
        this.county = county;
        this.postcode = postCode;
    }

    @Id
    @Getter
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="app_address_id_seq")
    @SequenceGenerator(name="app_address_id_seq", sequenceName="app_address_id_seq", allocationSize=1)
    private long id;

    @Setter
    @Getter
    @Column(name = "street", nullable = false, length=40)
    private String street;

    @Setter
    @Getter
    @Column(name = "town", nullable = false, length=40)
    private String town;

    @Setter
    @Getter
    @Column(name = "county", nullable = false, length=40)
    private String county;

    @Setter
    @Getter
    @Column(name = "postcode", nullable = false, length=40)
    private String postcode;
}
