package com.nobroker.controller;

import com.nobroker.entity.OwnerPlan;
import com.nobroker.service.OwnerPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/owner-plans")
public class OwnerPlanController {
    //http://localhost:3306/api/owner-plans/subscribe/{userId}/{duration}
    @Autowired
    private OwnerPlanService ownerPlanService;
    @PostMapping("/subscribe/{userId}/{duration}")
            public OwnerPlan subscribeOwnerPlan(@PathVariable long userId, @PathVariable int duration){
        ownerPlanService.subscribeOwnerPlan(userId,duration);
        return null;
    }
    @GetMapping("/{ownerPlanId}")
    public OwnerPlan getOwnerPlan(@PathVariable long ownerPlanId){
        return  ownerPlanService.getOwnerPlan(ownerPlanId);
    }
}
