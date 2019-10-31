package pl.lenistwo.expire.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.lenistwo.expire.entities.Item;
import java.time.LocalDate;
import java.util.List;

public interface ItemRepository extends CrudRepository<Item, Long> {

    List<Item> findAllByExpireDateIsLessThan(LocalDate date);

    List<Item> findAllByExpireDateIsBetween(LocalDate before, LocalDate after);
}
