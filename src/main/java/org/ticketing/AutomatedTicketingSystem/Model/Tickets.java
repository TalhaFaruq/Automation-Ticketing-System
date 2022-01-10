package org.ticketing.AutomatedTicketingSystem.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Tickets {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    //High Priority = 3, Normal Priority = 2, Low Priority = 1
    @JsonIgnoreProperties
    private int priority;

    @OneToOne
    DeliveryDetails deliveryDetails = new DeliveryDetails();

}
