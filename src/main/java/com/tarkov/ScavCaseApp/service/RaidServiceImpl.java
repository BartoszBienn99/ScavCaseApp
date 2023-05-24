package com.tarkov.ScavCaseApp.service;

import com.tarkov.ScavCaseApp.dto.AddRaidDto;
import com.tarkov.ScavCaseApp.model.Raid;
import com.tarkov.ScavCaseApp.repository.RaidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RaidServiceImpl implements RaidService {

    @Autowired
    public RaidRepository raidRepository;

    @Override
    public void addRaid(Raid raid) {
        this.raidRepository.save(raid);
    }

    @Override
    public void saveRaid(AddRaidDto addRaidDto) {
        Raid raid = new Raid(
                addRaidDto.getUser(),
                addRaidDto.getCostOfSendingScavs(),
                addRaidDto.getTypeOfGivenItem(),
                0, false);

        addRaid(raid);
    }
}
