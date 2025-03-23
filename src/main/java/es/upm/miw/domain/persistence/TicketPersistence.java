package es.upm.miw.domain.persistence;

import es.upm.miw.domain.model.Ticket;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketPersistence {
    Ticket create(Ticket ticket);

    Ticket readByUrlToken(String urlToken);
}
