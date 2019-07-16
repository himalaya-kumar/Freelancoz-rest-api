package com.freelancoz.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Data
@Entity
@NoArgsConstructor
public class ContactInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "address_id_gen")
    @SequenceGenerator(name = "address_id_gen",initialValue = 3000,allocationSize =1)
    private Long id;

    @Version
    private Integer version;

    private String city;

    private String state;

    private String postalCode;

    @Pattern(regexp = "(^|[0-9]{10})")
    private String phoneNumber;

    private String email;

    //Profile Related Links To Add

    /**
     * TODO :: Educational Bidirectional One to One
     */
//    //bidirectional by contactInformation
//    @OneToOne(mappedBy = "contactInformation")
//    private Lancer lancer;
//
//    //bidirectional by adddress
//    @OneToOne(mappedBy = "contactInformation")
//    private Client client;
//

    public ContactInformation(String city, String state, String postalCode, @Pattern(regexp = "(^|[0-9]{10})") String phoneNumber, String email) {
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public ContactInformation(String city, String state, String postalCode) {
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
    }
}