package com.tarkov.ScavCaseApp.service;

import com.tarkov.ScavCaseApp.model.Item;

import java.util.List;

public interface ItemService {

    List<Item> getAllItems();

    Item getItemById(int id);
}
