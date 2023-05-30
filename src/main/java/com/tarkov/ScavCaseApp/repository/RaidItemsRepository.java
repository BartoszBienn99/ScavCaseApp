package com.tarkov.ScavCaseApp.repository;

import com.tarkov.ScavCaseApp.model.RaidItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaidItemsRepository extends JpaRepository<RaidItems, Integer> {


}
