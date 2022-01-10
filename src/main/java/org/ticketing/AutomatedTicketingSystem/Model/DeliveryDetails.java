package org.ticketing.AutomatedTicketingSystem.Model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalTime;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class DeliveryDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int delivery_id;
    private String customer_type;
    private String delivery_status;
    private LocalTime expected_delivery_time;
    private int current_distance_from_destination_in_meters;
    private LocalTime time_to_reach_destination;

}
