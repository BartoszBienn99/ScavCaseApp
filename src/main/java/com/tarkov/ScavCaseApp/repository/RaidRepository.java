package com.tarkov.ScavCaseApp.repository;

import com.tarkov.ScavCaseApp.model.Raid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RaidRepository extends JpaRepository<Raid, Integer> {

    List<Raid> findByUserId(int id);
}
