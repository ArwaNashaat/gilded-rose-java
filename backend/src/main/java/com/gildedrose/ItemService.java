package com.gildedrose;

import com.gildedrose.strategy.Context;
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

    public void updateQuality() {
        List<Item> items = itemRepository.getAllItems();
        Context context = new Context();

        context.updateQuality(items);
        items = context.getItems();
        for(int i=0; i<items.size(); i++)
            itemRepository.updateQuality(items.get(i).id, items.get(i).sellIn, items.get(i).quality);

    }
}
