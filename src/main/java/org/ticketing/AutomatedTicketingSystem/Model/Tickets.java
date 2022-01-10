package org.ticketing.AutomatedTicketingSystem.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Tickets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    //High Priority = 3, Normal Priority = 2, Low Priority = 1
    @JsonIgnoreProperties
    private int priority;

    @OneToOne(cascade = CascadeType.MERGE)
    DeliveryDetails deliveryDetails = new DeliveryDetails();

}
