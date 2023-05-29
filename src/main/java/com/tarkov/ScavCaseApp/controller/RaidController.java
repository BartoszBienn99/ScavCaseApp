package com.tarkov.ScavCaseApp.controller;

import com.tarkov.ScavCaseApp.dto.AddRaidDto;
import com.tarkov.ScavCaseApp.model.Raid;
import com.tarkov.ScavCaseApp.service.RaidService;
import com.tarkov.ScavCaseApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/raids")
public class RaidController {

    @Autowired
    private RaidService raidService;

    @Autowired
    private UserService userService;

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
        model.addAttribute("raid", raid);
        return "update_raid";
    }

    @PostMapping("/updateRaid")
    public String updateRaid(@ModelAttribute("raid") Raid raid) {
        raid.setUser(userService.getUserById(userService.getLoggedUserId()));
        raidService.addRaid(raid);
        return "redirect:/";
    }
}
