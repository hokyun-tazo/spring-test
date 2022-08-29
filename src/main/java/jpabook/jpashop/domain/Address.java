package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Address {
    private String city;
    private String street;
    private String zipode;
    protected Address()
    {

    }
    public Address(String city, String street, String zipode) {
        this.city = city;
        this.street = street;
        this.zipode = zipode;
    }
}
