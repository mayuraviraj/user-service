package com.mayura.online.banking.userservice.domain;


import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @OneToOne(mappedBy = "address")
    private User user;

    @Column(name = "address_line_1", nullable = false)
    private String addressLineOne;

    @Column(name = "address_line_2")
    private String addressLineTwo;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "country", nullable = false)
    private String country;
}
