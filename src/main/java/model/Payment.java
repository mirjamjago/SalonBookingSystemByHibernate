package model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int PaymentID;

    private BigDecimal TotalAMount;

    private Timestamp PaymentTime;

    private String PaidBy;

    @ManyToOne
    @JoinColumn(name = "BookingId")
    private Booking booking;

}
