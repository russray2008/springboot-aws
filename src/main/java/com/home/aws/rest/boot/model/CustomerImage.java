package com.home.aws.rest.boot.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;



@Entity(name="app_customer_image")
public class CustomerImage {

    public CustomerImage(){}

    public CustomerImage(String key, String url) {
        this.key = key;
        this.url =url;
    }

    @Id
    @Getter
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="app_customer_image_id_seq")
    @SequenceGenerator(name="app_customer_image_id_seq", sequenceName="app_customer_image_id_seq", allocationSize =1)
    private long id;

    @Setter
    @Getter
    @Column(name = "s3_key", nullable = false, length=200)
    private String key;

    @Setter
    @Getter
    @Column(name = "url", nullable = false, length=1000)
    private String url;

}
