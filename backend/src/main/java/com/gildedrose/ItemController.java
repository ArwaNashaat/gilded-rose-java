package com.gildedrose;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping(value = "/Item/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public void add(@RequestBody Item item) {
        itemService.add(item);
    }

    @GetMapping(value = "/Item/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getItemBy(@PathVariable("id") int id) {
        return formJsonResponse(itemService.getItemBy(id));
    }

    @GetMapping(value = "/Item/getAllItems", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    private String formJsonResponse(Item item) {
        return "{"+item.toString()+"}";
    }
}
