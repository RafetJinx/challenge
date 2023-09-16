package com.enoca.challenge.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "company")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    // define fields

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column (name = "name")
    private String name;

    @Column (name = "address")
    private String address;

    @Column (name = "phone_number")
    private String phoneNumber;
}
