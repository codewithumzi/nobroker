package com.nobroker.scheduler;

import com.nobroker.entity.OwnerPlan;
import com.nobroker.repository.OwnerPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component

public class ExpirationScheduler {
    @Autowired
    private OwnerPlanRepository ownerPlanRepository;
    @Scheduled(cron = "000***")
    public void checkExpiration(){
        List<OwnerPlan> activePlans =ownerPlanRepository
                .findBySubscriptionActiveTrueAndSubscriptionExpirationDateBefore(LocalDate.now());
        for(OwnerPlan plan:activePlans){
            ownerPlanRepository.save(plan);

        }

    }
}
