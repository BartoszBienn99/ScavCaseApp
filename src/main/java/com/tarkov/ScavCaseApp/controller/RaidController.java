package com.tarkov.ScavCaseApp.controller;

import com.tarkov.ScavCaseApp.dto.AddItemDto;
import com.tarkov.ScavCaseApp.dto.AddRaidDto;
import com.tarkov.ScavCaseApp.model.Item;
import com.tarkov.ScavCaseApp.model.Raid;
import com.tarkov.ScavCaseApp.model.RaidItems;
import com.tarkov.ScavCaseApp.service.ItemService;
import com.tarkov.ScavCaseApp.service.RaidItemsService;
import com.tarkov.ScavCaseApp.service.RaidService;
import com.tarkov.ScavCaseApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/raids")
public class RaidController {

    @Autowired
    private RaidService raidService;

    @Autowired
    private UserService userService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private RaidItemsService raidItemsService;

    @GetMapping
    public String getRaidView(Model model) {
        List<Raid> loggedUserRaids = raidService.getRaidsByUserId(userService.getLoggedUserId());
        model.addAttribute("userRaidsList", loggedUserRaids);
        return "raids";
    }

    @GetMapping("/addRaid")
    public String showAddRaidForm(Model model) {
        AddRaidDto addRaidDto = new AddRaidDto();
        model.addAttribute("addRaidDto", addRaidDto);
        return "add_raid";
    }

    @PostMapping("/addRaid")
    public String saveRaid(@ModelAttribute("addRaidDto") AddRaidDto addRaidDto) {
        int loggedUserId = userService.getLoggedUserId();
        addRaidDto.setUser(userService.getUserById(loggedUserId));
        raidService.saveRaid(addRaidDto);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String showSelectedRaid(@PathVariable(value = "id")int raidId, Model model) {
        Raid raid = raidService.getRaidById(raidId);
        List<RaidItems> raidItems = raid.getRaidItems();
        List<Item> items = itemService.getAllItems();
        AddItemDto addItemDto = new AddItemDto();
        addItemDto.setRaidId(raidId);
        model.addAttribute("items", items);
        model.addAttribute("raidItems", raidItems);
        model.addAttribute("raid", raid);
        model.addAttribute("addItemDto" ,addItemDto);
        return "update_raid";
    }

    @PostMapping("/updateRaid")
    public String updateRaid(@ModelAttribute("raid") Raid raid) {
        raid.setUser(userService.getUserById(userService.getLoggedUserId()));
        raidService.addRaid(raid);
        return "redirect:/";
    }

    @PostMapping("/addItemToRaid")
    public String addItemToRaid(@ModelAttribute("addItemDto") AddItemDto addItemDto){
        Raid raid = raidService.getRaidById(addItemDto.getRaidId());
        Item item = itemService.getItemById(addItemDto.getItemId());
        RaidItems raidItems = new RaidItems(raid, item, addItemDto.getItemValue());
        raidItemsService.addRaidItems(raidItems);
        return "redirect:/raids/" + addItemDto.getRaidId();
    }
}
