package com.alekseysamoylov.serviceiii.service;

import com.alekseysamoylov.serviceiii.entity.bonus.Bonus;
import com.alekseysamoylov.serviceiii.repository.BonusRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * Реализация {@link BonusService}
 */
@Service
public class BonusServiceImpl implements BonusService {

    private final BonusRepository bonusRepository;

    public BonusServiceImpl(BonusRepository bonusRepository) {
        this.bonusRepository = bonusRepository;
    }

    @Override
    public Integer getBonusSumForUser(Long userId) {
        List<Bonus> userBonuses = bonusRepository.findByUserId(userId);
        BigDecimal bonusValue = BigDecimal.ZERO;
        for (Bonus bonus : userBonuses) {
            bonusValue = bonusValue.add(bonus.getValue());
        }
        return bonusValue.setScale(0, RoundingMode.UP).intValue();
    }
}
