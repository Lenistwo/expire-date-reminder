package pl.lenistwo.expire.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String itemName;

    @Column
    private int amount;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate expireDate;

    public Item() {
    }

    public Item(String itemName, int amount, LocalDate expireDate) {
        this.itemName = itemName;
        this.amount = amount;
        this.expireDate = expireDate;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(LocalDate expireDate) {
        this.expireDate = expireDate;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + itemName + '\'' +
                ", amount=" + amount +
                ", expireDate=" + expireDate +
                '}';
    }
}
