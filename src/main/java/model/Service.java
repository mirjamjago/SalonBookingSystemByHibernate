package model;


import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ServiceId;

    private String Name;

    private BigDecimal Price;

    private int Duration;

    private String Description;


}
