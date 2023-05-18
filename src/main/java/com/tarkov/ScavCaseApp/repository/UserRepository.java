package com.tarkov.ScavCaseApp.repository;

import com.tarkov.ScavCaseApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
