package com.nobroker.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "owner_plans")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OwnerPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "owner_plan_id")
    private long ownerPlanId;// Assuming this is your primary key

    @Column(name = "user_id", unique = true)
    private long userId;

    @Column(name = "subscription_active")
    private boolean subscriptionActive;

    @Column(name = "subscription_active_date")
    private LocalDate subscriptionActiveDate;

    @Column(name = "subscription_expiration_date")
    private LocalDate subscriptionExpirationDate;

    @Column(name = "number_of_days")
    private int numberOfDays;//Integer

}
