package model;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
public class BookingsByCustomerAndPayment {
    private String FirstName;
    private String LastName;
    private BigDecimal TotalAmount;

    public BookingsByCustomerAndPayment() {
    }


    public BookingsByCustomerAndPayment( String firstName, String lastName, BigDecimal totalAmount) {
        this.FirstName = firstName;
        this.LastName = lastName;
        this.TotalAmount = totalAmount;
    }
}
