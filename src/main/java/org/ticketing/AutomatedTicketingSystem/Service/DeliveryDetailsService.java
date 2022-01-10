package org.ticketing.AutomatedTicketingSystem.Service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.ticketing.AutomatedTicketingSystem.Model.DeliveryDetails;
import org.ticketing.AutomatedTicketingSystem.Repository.DeliveryDetailsRepository;

import java.util.List;

@Service
public class DeliveryDetailsService {

    private DeliveryDetailsRepository deliveryDetailsRepository;

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
            return null;

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
