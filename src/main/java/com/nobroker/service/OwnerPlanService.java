package com.nobroker.service;

import com.nobroker.payload.OwnerPlanDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface OwnerPlanService {
   public OwnerPlanDto createOwnerPlans(OwnerPlanDto ownerPlanDto);
    List<OwnerPlanDto> getAllOwnerPlans();
}
