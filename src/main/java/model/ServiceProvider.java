package model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ServiceProvider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ServiceProviderID;

    @ManyToOne
    @JoinColumn(name = "ServiceId")
    private Service service;

    @ManyToOne
    @JoinColumn(name = "EmployeeId")
    private Employee employee;


}
