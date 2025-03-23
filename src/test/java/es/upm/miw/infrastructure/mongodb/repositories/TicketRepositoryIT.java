package es.upm.miw.infrastructure.mongodb.repositories;

import es.upm.miw.infrastructure.mongodb.entities.TicketEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@ActiveProfiles("test")
class TicketRepositoryIT {

    @Autowired
    private TicketRepository ticketRepository;

    @Test
    void testFindByUrlToken() {
        Optional<TicketEntity> ticket = this.ticketRepository.findByUrlToken("HuABW1VRQy-LsEi5D-pBVA");
        assertThat(ticket).isPresent();
        assertThat(ticket.get().getId()).isEqualTo(UUID.fromString("0ba2b4f2-b270-435c-b18c-61203800640e"));
    }

}
