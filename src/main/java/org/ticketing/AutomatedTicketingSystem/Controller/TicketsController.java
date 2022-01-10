package org.ticketing.AutomatedTicketingSystem.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ticketing.AutomatedTicketingSystem.Service.TicketsService;

/**
 * The type Tickets controller.
 */
@RequestMapping("/tickets")
@RestController
public class TicketsController {
    private final TicketsService ticketsService;

    /**
     * Instantiates a new Tickets controller.
     *
     * @param ticketsService the tickets service
     */
    public TicketsController(TicketsService ticketsService) {
        this.ticketsService = ticketsService;
    }

    /**
     * Get all response entity.
     *
     * @return the response entity
     */
    @GetMapping("all")
    public ResponseEntity<Object> getAll() {
        return ResponseEntity.ok().body(ticketsService.listAll());
    }
}
