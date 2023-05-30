package com.tarkov.ScavCaseApp.service;

import com.tarkov.ScavCaseApp.model.Item;
import com.tarkov.ScavCaseApp.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    public ItemRepository itemRepository;

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item getItemById(int id) {
        return itemRepository.getById(id);
    }
}
