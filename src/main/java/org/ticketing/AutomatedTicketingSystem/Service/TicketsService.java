package org.ticketing.AutomatedTicketingSystem.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.ticketing.AutomatedTicketingSystem.Model.Tickets;
import org.ticketing.AutomatedTicketingSystem.Repository.TicketsRepository;

import java.util.List;

/**
 * The type Tickets service.
 */
@Service
public class TicketsService {
    private final TicketsRepository ticketsRepository;

    /**
     * Instantiates a new Tickets service.
     *
     * @param ticketsRepository the tickets repository
     */
    public TicketsService(TicketsRepository ticketsRepository) {
        this.ticketsRepository = ticketsRepository;
    }

    /**
     * List all response entity.
     *
     * @return the response entity
     */
    public ResponseEntity<Object> listAll() {
        try {
            List<Tickets> tickets = ticketsRepository.findAllByOrderByPriorityDesc();
            if (!tickets.isEmpty()) {
                return ResponseEntity.ok().body(tickets);
            } else return ResponseEntity.ok().body("There is no ticket in the database.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }
}
