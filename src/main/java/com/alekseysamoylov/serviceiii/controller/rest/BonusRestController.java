package com.alekseysamoylov.serviceiii.controller.rest;

import com.alekseysamoylov.serviceiii.service.BonusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Контроллер для работы с бонусными баллами {@link com.alekseysamoylov.serviceiii.entity.bonus.Bonus}
 */
@RestController
@RequestMapping(value = "/rest")
public class BonusRestController {

    private final BonusService bonusService;

    @Autowired
    public BonusRestController(BonusService bonusService) {
        this.bonusService = bonusService;
    }

    @CrossOrigin
    @RequestMapping(value = "/bonus/{id}", method = RequestMethod.GET)
    public Integer getUserBonusSum(@PathVariable Long id) {
        return bonusService.getBonusSumForUser(id);
    }
}
