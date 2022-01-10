package org.ticketing.AutomatedTicketingSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.ticketing.AutomatedTicketingSystem.Model.DeliveryDetails;

@Repository
public interface DeliveryDetailsRepository extends JpaRepository<DeliveryDetails, Integer> {
}
