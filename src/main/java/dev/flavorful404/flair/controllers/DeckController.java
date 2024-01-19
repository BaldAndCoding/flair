package dev.flavorful404.flair.controllers;

import dev.flavorful404.flair.domain.Deck;
import dev.flavorful404.flair.domain.DeckRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/decks")
public class DeckController {
    private DeckRepository repo;
    public DeckController(DeckRepository repo) {
        this.repo = repo;
    }
    @GetMapping(value = "/index", produces = "application/json")
    public List<Deck> index() {
        return repo.findAllByOrderByName();
    }

}
