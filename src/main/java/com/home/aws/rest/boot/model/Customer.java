package com.home.aws.rest.boot.model;

import java.util.Date;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;


@Entity(name="app_customer")
public class Customer{

    public Customer(){}

    public Customer(String firstName, String lastName, Date dateOfBirth, CustomerImage customerImage, Address address) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.customerImage = customerImage;
        this.address = address;
    }

    @Id
    @Getter
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="app_customer_id_seq")
    @SequenceGenerator(name="app_customer_id_seq", sequenceName="app_customer_id_seq", allocationSize =1)
    private long id;

    @Setter
    @Getter
    @Column(nullable = false, length = 30)
    private String firstName;

    @Setter
    @Getter
    @Column(nullable = false, length = 30)
    private String lastName;

    @Setter
    @Getter
    @Column(nullable = false)
    private Date dateOfBirth;

    @Setter
    @Getter
    @OneToOne(cascade = {CascadeType.ALL})
    private CustomerImage customerImage;

    @Setter
    @Getter
    @OneToOne(cascade = {CascadeType.ALL})
    private Address address;
}