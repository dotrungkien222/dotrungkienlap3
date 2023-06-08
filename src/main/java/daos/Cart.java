package com.example.demo.daos;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
public class Cart {
    private List<Item> cartItems = new ArrayList<>();
    public void addItems(Item item) {
        boolean isExist = cartItems.stream().filter(i -> Objects.equals(i.getID(), item.getID()))
                .findFirst().map(i -> { i.setQuantity(i.getQuantity() + item.getQuantity());
                    return true;
                }).orElse(false);
        if (!isExist) {
            cartItems.add(item);
        }
    }
    public void removeItems(Long ID) {
        cartItems.removeIf(item -> Objects.equals(item.getID(), ID));
    }
    public void updateItems(Long ID, int quantity) {
        cartItems.stream().filter(item -> Objects.equals(item.getID(), ID))
                .forEach(item -> item.setQuantity(quantity));
    }
}
