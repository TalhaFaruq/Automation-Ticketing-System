package org.ticketing.AutomatedTicketingSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.ticketing.AutomatedTicketingSystem.Model.Tickets;

import java.util.List;

@Repository
public interface TicketsRepository extends JpaRepository<Tickets, Integer> {
    List<Tickets> findAllByOrderByPriorityDesc();
}
