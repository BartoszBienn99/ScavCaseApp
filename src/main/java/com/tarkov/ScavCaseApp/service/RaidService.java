package com.tarkov.ScavCaseApp.service;

import com.tarkov.ScavCaseApp.dto.AddRaidDto;
import com.tarkov.ScavCaseApp.model.Raid;


public interface RaidService {

    void addRaid(Raid raid);
    void saveRaid(AddRaidDto addRaidDto);
}
