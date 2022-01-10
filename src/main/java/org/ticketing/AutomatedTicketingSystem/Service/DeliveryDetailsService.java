package org.ticketing.AutomatedTicketingSystem.Service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.ticketing.AutomatedTicketingSystem.Model.DeliveryDetails;
import org.ticketing.AutomatedTicketingSystem.Model.Tickets;
import org.ticketing.AutomatedTicketingSystem.Repository.DeliveryDetailsRepository;

import java.util.Calendar;
import java.util.List;

@Service
public class DeliveryDetailsService {

    private final DeliveryDetailsRepository deliveryDetailsRepository;

    public DeliveryDetailsService(DeliveryDetailsRepository deliveryDetailsRepository) {
        this.deliveryDetailsRepository = deliveryDetailsRepository;
    }

    public ResponseEntity<Object> listDeliveryDetails() {
        try {
            List<DeliveryDetails> deliveryDetails = deliveryDetailsRepository.findAll();
            if (!deliveryDetails.isEmpty()) {
                return ResponseEntity.ok().body(deliveryDetails);
            } else return new ResponseEntity<>("Empty List", HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Object> saveDeliveryDetails(DeliveryDetails deliveryDetails) {
        try {
            Tickets tickets = new Tickets();
            Calendar date = Calendar.getInstance();
            if (deliveryDetails.getCustomer_type().equals("VIP")) {
                tickets.setPriority(3); //High priority over other customers = 3
                tickets.setDeliveryDetails(deliveryDetails);
                return ResponseEntity.accepted().body(tickets);
            } else if (deliveryDetails.getExpected_delivery_time().after(date.getTime())) {
                tickets.setPriority(2); //Priority higher than others = 2
                tickets.setDeliveryDetails(deliveryDetails);
                return ResponseEntity.accepted().body(tickets);
            } else if (deliveryDetails.getTime_to_reach_destination().after(deliveryDetails.getExpected_delivery_time())) {
                tickets.setPriority(1); //Normal Priority = 1
                tickets.setDeliveryDetails(deliveryDetails);
                return ResponseEntity.accepted().body(tickets);
            }
            return ResponseEntity.badRequest().body(deliveryDetails);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
