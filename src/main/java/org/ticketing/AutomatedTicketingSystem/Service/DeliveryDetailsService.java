package org.ticketing.AutomatedTicketingSystem.Service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.ticketing.AutomatedTicketingSystem.Model.DeliveryDetails;
import org.ticketing.AutomatedTicketingSystem.Model.Tickets;
import org.ticketing.AutomatedTicketingSystem.Repository.DeliveryDetailsRepository;

import java.time.LocalTime;
import java.util.List;

/**
 * The type Delivery details service.
 */
@Service
public class DeliveryDetailsService {

    private final DeliveryDetailsRepository deliveryDetailsRepository;
    private final TicketsService ticketsService;

    /**
     * Instantiates a new Delivery details service.
     *
     * @param deliveryDetailsRepository the delivery details repository
     */
    public DeliveryDetailsService(DeliveryDetailsRepository deliveryDetailsRepository, TicketsService ticketsService) {
        this.deliveryDetailsRepository = deliveryDetailsRepository;
        this.ticketsService = ticketsService;
    }

    /**
     * List delivery details response entity.
     *
     * @return the response entity
     */
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

    /**
     * Save delivery details response entity.
     *
     * @param deliveryDetails the delivery details
     * @return the response entity
     */
    public ResponseEntity<Object> saveDeliveryDetails(DeliveryDetails deliveryDetails) {
        try {
            LocalTime t1 = LocalTime.of(deliveryDetails.getExpected_delivery_time().getHour(), deliveryDetails.getExpected_delivery_time().getMinute());
            LocalTime t2 = LocalTime.of(deliveryDetails.getTime_to_reach_destination().getHour(), deliveryDetails.getTime_to_reach_destination().getMinute());
            LocalTime total = t1.plusHours(t2.getHour()).plusMinutes(t2.getMinute());


            Tickets tickets = new Tickets();
            if (deliveryDetails.getCustomer_type().equals("VIP")) {
                tickets.setPriority(3); //High priority over other customers = 3
                tickets.setDeliveryDetails(deliveryDetails);
                ticketsService.save(tickets);
                return ResponseEntity.accepted().body(tickets);
            } else if (deliveryDetails.getExpected_delivery_time().isAfter(LocalTime.now())) {
                tickets.setPriority(2); //Priority higher than others = 2
                tickets.setDeliveryDetails(deliveryDetails);
                ticketsService.save(tickets);
                return ResponseEntity.accepted().body(tickets);
            } else if (deliveryDetails.getTime_to_reach_destination().isAfter(deliveryDetails.getExpected_delivery_time())) {
                tickets.setPriority(1); //Normal Priority = 1
                tickets.setDeliveryDetails(deliveryDetails);
                ticketsService.save(tickets);
                return ResponseEntity.accepted().body(tickets);
            }
            return ResponseEntity.badRequest().body(deliveryDetails);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
