package com.graphql.java.persondetails.type;

import lombok.*;

import javax.persistence.*;

@Builder
@Data
@Entity(name = "person")
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String gender;
}
