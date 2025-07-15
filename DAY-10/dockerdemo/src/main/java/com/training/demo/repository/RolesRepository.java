package com.training.demo.repository;
import com.training.demo.models.RegisterDetails;
import com.training.demo.models.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolesRepository extends JpaRepository<Roles,Integer> {
    Optional<Roles> findByRoleName(String roleName);



}