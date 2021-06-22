package com.example.relationaldataaccess.tableclass;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter @Setter
@Entity
@Table(name = "TESTTABLE")
public class Testtable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int personId;
    private String firstName;
    private String lastName;

    protected Testtable() {}
}