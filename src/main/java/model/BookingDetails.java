package model;


import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@Entity
public class BookingDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int BookingDetailsID;

    private Timestamp ServiceStart;

    private Timestamp ServiceEnd;

    private BigDecimal Amount;

    @ManyToOne
    @JoinColumn(name = "bookingId")
    private Booking booking;

    @ManyToOne
    @JoinColumn(name = "ServiceProviderId")
    private ServiceProvider serviceProvider;

}
