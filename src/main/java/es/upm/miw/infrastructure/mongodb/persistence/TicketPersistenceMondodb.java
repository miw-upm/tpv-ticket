package es.upm.miw.infrastructure.mongodb.persistence;

import es.upm.miw.domain.exceptions.NotFoundException;
import es.upm.miw.domain.model.Ticket;
import es.upm.miw.domain.persistence.TicketPersistence;
import es.upm.miw.infrastructure.mongodb.entities.TicketEntity;
import es.upm.miw.infrastructure.mongodb.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TicketPersistenceMondodb implements TicketPersistence {
    private final TicketRepository ticketRepository;

    @Autowired
    public TicketPersistenceMondodb(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Ticket create(Ticket ticket) {
        return this.ticketRepository.save(new TicketEntity(ticket))
                .toTicket();
    }

    @Override
    public Ticket readByUrlToken(String urlToken) {
        return this.ticketRepository.findByUrlToken(urlToken)
                .orElseThrow(() -> new NotFoundException("The urlToken don't exist: " + urlToken))
                .toTicket();
    }
}
