package com.ims.demo.Service;

import com.ims.demo.Models.Item;
import com.ims.demo.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    // Get all items
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    // Get an item by ID
    public Item getItemById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    // Create a new item
    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    // Update an existing item
    public Item updateItem(Long id, Item item) {
        item.setId(id); // Ensure the ID is set
        return itemRepository.save(item);
    }

    // Delete an item
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
}
