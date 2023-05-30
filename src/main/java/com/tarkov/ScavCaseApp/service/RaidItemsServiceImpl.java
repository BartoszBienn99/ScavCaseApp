package com.tarkov.ScavCaseApp.service;

import com.tarkov.ScavCaseApp.model.RaidItems;
import com.tarkov.ScavCaseApp.repository.RaidItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RaidItemsServiceImpl implements RaidItemsService {

    @Autowired
    RaidItemsRepository raidItemsRepository;



    @Override
    public void addRaidItems(RaidItems raidItems) {
        this.raidItemsRepository.save(raidItems);
    }
}
