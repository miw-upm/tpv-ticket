package es.upm.miw.infrastructure.webclients;

import es.upm.miw.configurations.FeignConfig;
import es.upm.miw.domain.model.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = UserWebClient.TPV_USER, configuration = FeignConfig.class)
public interface UserWebClient {

    String USERS_ID_ID = "/users/{id}";
    String TPV_USER = "tpv-user";

    @GetMapping(USERS_ID_ID)
    UserDto readUserById(@PathVariable UUID id);
}
