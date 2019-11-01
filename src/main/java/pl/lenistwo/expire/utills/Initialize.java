package pl.lenistwo.expire.utills;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.lenistwo.expire.entities.Item;
import pl.lenistwo.expire.repositories.ItemRepository;

import java.time.LocalDate;

@Component
public class Initialize implements CommandLineRunner {

    private ItemRepository repo;

    @Autowired
    public Initialize(ItemRepository repo) {
        this.repo = repo;
    }

    @Override
    public void run(String... args) {
        repo.save(new Item("Eggs", 3, LocalDate.of(2018,3,24)));
        repo.save(new Item("Bacon", 3, LocalDate.of(2018,5,24)));
        repo.save(new Item("Milk", 3, LocalDate.of(2018,6,24)));
        repo.save(new Item("Cheese", 3, LocalDate.of(2018,7,24)));
        repo.save(new Item("Bread", 3, LocalDate.of(2019,12,30)));
        repo.save(new Item("Honey", 3, LocalDate.of(2019,11,1)));
        repo.save(new Item("Ketchup", 3, LocalDate.of(2019,11,2)));
    }
}
