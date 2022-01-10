package org.ticketing.AutomatedTicketingSystem.Model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Time;

@Data
@Entity
public class DeliveryDetails {
    @Id
    private int delivery_id;
    private String customer_type;
    private String delivery_status;
    private Time expected_delivery_time;
    private int current_distance_from_destination_in_meters;
    private Time time_to_reach_destination;

}
