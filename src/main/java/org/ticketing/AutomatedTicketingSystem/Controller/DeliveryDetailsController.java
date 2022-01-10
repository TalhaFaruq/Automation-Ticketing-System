package org.ticketing.AutomatedTicketingSystem.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.ticketing.AutomatedTicketingSystem.Model.DeliveryDetails;
import org.ticketing.AutomatedTicketingSystem.Service.DeliveryDetailsService;

@RestController
@RequestMapping("/delivery")
public class DeliveryDetailsController {

    private final DeliveryDetailsService detailsService;

    public DeliveryDetailsController(DeliveryDetailsService detailsService) {
        this.detailsService = detailsService;
    }

    @GetMapping("all")
    public ResponseEntity<Object> getAllDeliveries() {
        return detailsService.listDeliveryDetails();
    }

    @PostMapping("/add")
    public ResponseEntity<Object> addDelivery(@RequestBody DeliveryDetails deliveryDetails) {
            return detailsService.saveDeliveryDetails(deliveryDetails);
    }
}
