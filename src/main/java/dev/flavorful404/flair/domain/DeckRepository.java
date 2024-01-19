package dev.flavorful404.flair.domain;

import dev.flavorful404.flair.domain.Deck;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface DeckRepository extends Repository<Deck, Long> {
    List<Deck> findAllByOrderByName();
}
