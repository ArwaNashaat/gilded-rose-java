package com.gildedrose;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void add(Item item){
        itemRepository.save(item);
    }

    public Item getItemBy(int id){
        return itemRepository.getById(id);
    }

    public List<Item> getAllItems(){
        return itemRepository.getAllItems();
    }

    public List<Item> getAgedBrieItems() {
        return itemRepository.getAgedBrieItems();
    }
}
