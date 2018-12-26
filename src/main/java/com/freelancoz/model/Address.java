package com.freelancoz.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "address_id_gen")
    @SequenceGenerator(name = "address_id_gen",initialValue = 3000,allocationSize =1)
    private Long id;

    @Version
    private Integer version;

    private String city;

    private String state;

    private String postalCode;

    /**
     * TODO :: Educational Bidirectional One to One
     */
//    //bidirectional by address
//    @OneToOne(mappedBy = "address")
//    private Lancer lancer;
//
//    //bidirectional by adddress
//    @OneToOne(mappedBy = "address")
//    private Client client;
//

    public Address(String city, String state, String postalCode) {
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
    }
}