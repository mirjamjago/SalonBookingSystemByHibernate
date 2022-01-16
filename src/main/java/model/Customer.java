package model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int CustomerId;

    @Embedded
    private Person person;

}
