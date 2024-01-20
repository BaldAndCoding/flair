package dev.flavorful404.flair.domain;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface DeckRepository extends CrudRepository<Deck, Long> {
    List<Deck> findAllByOrderByName();
}
