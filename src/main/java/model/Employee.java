package model;


import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Data
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int EmployeeId;

    @Embedded
    Person person;

    private String Address;

    @CreationTimestamp
    private OffsetDateTime dateOfRegister;


}
