package pl.lenistwo.expire.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.lenistwo.expire.entities.Item;
import pl.lenistwo.expire.repositories.ItemRepository;
import java.time.LocalDate;
import java.util.List;

@Controller
public class ItemController {

    private ItemRepository repo;

    @Autowired
    public ItemController(ItemRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/")
    public String allItemsView(Model model) {
        Iterable<Item> items = repo.findAll();
        model.addAttribute("item", items);
        return "all-items";
    }

    @GetMapping("/expired-items")
    public String expiredItemsView(Model model) {
        List<Item> items = repo.findAllByExpireDateIsLessThan(LocalDate.now());
        model.addAttribute("item", items);
        return "expired-items";
    }

    @GetMapping("/add-item")
    public String addNewItemForm() {
        return "add-item";
    }

    @PostMapping("/add-item")
    public String addNewItemToDb(Item item) {
        repo.save(item);
        return "redirect:/";
    }

}
