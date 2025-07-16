package com.training.demo.repository;

import com.training.demo.models.RegisterDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegisterDetailsRepository extends JpaRepository<RegisterDetails,Integer> {
    RegisterDetails findByEmail(String email);

    Optional<RegisterDetails> findByUserName(String userName);

    @Query("SELECT r FROM RegisterDetails r JOIN r.roles role WHERE role.roleName = :roleName")
    Optional<RegisterDetails> findByRole(@Param("roleName") String roleName);
}