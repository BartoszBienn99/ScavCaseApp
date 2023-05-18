package com.tarkov.ScavCaseApp.repository;

import com.tarkov.ScavCaseApp.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
}
