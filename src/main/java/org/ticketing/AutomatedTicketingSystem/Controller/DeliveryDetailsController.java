package org.ticketing.AutomatedTicketingSystem.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.ticketing.AutomatedTicketingSystem.Model.DeliveryDetails;
import org.ticketing.AutomatedTicketingSystem.Service.DeliveryDetailsService;

/**
 * The type Delivery details controller.
 */
@RestController
@RequestMapping("/delivery")
public class DeliveryDetailsController {

    private final DeliveryDetailsService detailsService;

    /**
     * Instantiates a new Delivery details controller.
     *
     * @param detailsService the details service
     */
    public DeliveryDetailsController(DeliveryDetailsService detailsService) {
        this.detailsService = detailsService;
    }

    /**
     * Gets all deliveries.
     *
     * @return the all deliveries
     */
    @GetMapping("all")
    public ResponseEntity<Object> getAllDeliveries() {
        return detailsService.listDeliveryDetails();
    }

    /**
     * Add delivery response entity.
     *
     * @param deliveryDetails the delivery details
     * @return the response entity
     */
    @PostMapping("/add")
    public ResponseEntity<Object> addDelivery(@RequestBody DeliveryDetails deliveryDetails) {
        return detailsService.saveDeliveryDetails(deliveryDetails);
    }
}
