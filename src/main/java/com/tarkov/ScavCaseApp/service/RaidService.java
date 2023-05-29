package com.tarkov.ScavCaseApp.service;

import com.tarkov.ScavCaseApp.dto.AddRaidDto;
import com.tarkov.ScavCaseApp.model.Raid;
import com.tarkov.ScavCaseApp.model.User;

import java.util.List;


public interface RaidService {

    void addRaid(Raid raid);
    void saveRaid(AddRaidDto addRaidDto);

    List<Raid> getRaidsByUserId(int id);

    Raid getRaidById(int id);

}
