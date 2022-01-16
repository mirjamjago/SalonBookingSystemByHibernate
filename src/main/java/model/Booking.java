package model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.List;

@Data
@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;

    private String status;

    private BigDecimal TotalAMount;

    @ManyToOne
    @JoinColumn(name = "CustomerId")
    private Customer customer;


}
