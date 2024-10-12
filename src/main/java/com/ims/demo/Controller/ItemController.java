package com.ims.demo.Controller;

import com.ims.demo.Models.Item;
import com.ims.demo.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/items")
public class ItemController {
    
    @Autowired
    private ItemService itemService;

    @GetMapping
    public String getAllItems(Model model) {
        List<Item> items = itemService.getAllItems();
        model.addAttribute("items", items);
        return "itemList"; 
    }

    @GetMapping("/new")
    public String showAddItemForm(Model model) {
        model.addAttribute("item", new Item());
        return "addItem"; 
    }

    @PostMapping
    public String createItem(@ModelAttribute Item item) {
        itemService.createItem(item);
        return "redirect:/api/items"; 
    }

    @GetMapping("/edit/{id}")
    public String getItemById(@PathVariable Long id, Model model) {
        Item item = itemService.getItemById(id);
        if (item != null) {
            model.addAttribute("item", item);
            return "edit";
        } else {
            return "redirect:/error";
        }
    }


    @PostMapping("/edit/{id}")
    public String updateItem(@PathVariable Long id, @ModelAttribute Item item) {
        itemService.updateItem(id, item);
        return "redirect:/api/items";
    }

    @PostMapping("delete/{id}")
    public String deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        return "redirect:/api/items";
    }
}
