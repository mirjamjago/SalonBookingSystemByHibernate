package model;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Person {

    private String FirstName;

    private String LastName;

    private String PhoneNumber;

    private String email;
}
