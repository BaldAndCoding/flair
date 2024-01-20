package dev.flavorful404.flair.controllers;

import dev.flavorful404.flair.domain.Deck;
import dev.flavorful404.flair.domain.DeckFormDto;
import dev.flavorful404.flair.domain.DeckRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "/decks")
public class DeckController {
    // TODO: Error handling on all methods
    private final DeckRepository repo;
    public DeckController(DeckRepository repo) {
        this.repo = repo;
    }
    @GetMapping()
    public String index(Model model) {
        model.addAttribute("decks", repo.findAllByOrderByName());
        return "decks/index";
    }

    @GetMapping("{did}")
    public String show(@PathVariable Long did, Model model) {
        Optional<Deck> o = repo.findById(did);
        model.addAttribute("deck", o.get());
        return "decks/show";
    }

    @GetMapping("new")
    public String newForm(Model model) {
        model.addAttribute("deck", new DeckFormDto());
        return "decks/new";
    }

    @PostMapping("create")
    public String create(@ModelAttribute DeckFormDto deckFormDto, Model model) {
        Deck d = new Deck();
        d.setName(deckFormDto.getName());
        d = repo.save(d);

        return "redirect:/decks/" + d.getDid();
    }

    @GetMapping("{did}/edit")
    public String edit(@PathVariable Long did, Model model) {
        Optional<Deck> o = repo.findById(did);
        model.addAttribute("deck", o.get());
        return "decks/edit";
    }

    @PostMapping("update")
    public String update(@ModelAttribute Deck deck, Model model) {
        Deck updated = repo.save(deck);
        model.addAttribute("deck", updated);

        return "redirect:/decks/" + updated.getDid();
    }

    @PostMapping("{did}/retire")
    public String retire(@PathVariable Long did) {
        Optional<Deck> o = repo.findById(did);
        if(o.isPresent()) repo.delete(o.get());
        return "redirect:/decks";
    }

}
