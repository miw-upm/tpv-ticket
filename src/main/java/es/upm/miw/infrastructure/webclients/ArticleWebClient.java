package es.upm.miw.infrastructure.webclients;

import es.upm.miw.domain.model.ArticleDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = ArticleWebClient.TPV_ARTICLE)
public interface ArticleWebClient {

    String TICKETS_ID_ID = "/tickets/{id}";
    String TPV_ARTICLE = "tpv-article";

    @GetMapping(TICKETS_ID_ID)
    ArticleDto readArticleById(@PathVariable UUID id);
}
