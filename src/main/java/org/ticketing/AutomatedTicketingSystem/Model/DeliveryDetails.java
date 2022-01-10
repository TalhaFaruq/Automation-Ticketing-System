package org.ticketing.AutomatedTicketingSystem.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Time;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class DeliveryDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int delivery_id;
    private String customer_type;
    private String delivery_status;
    private Time expected_delivery_time;
    private int current_distance_from_destination_in_meters;
    private Time time_to_reach_destination;

}
