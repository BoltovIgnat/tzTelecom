package com.example.easynotes.repository;

import com.example.easynotes.model.Tenants;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TenantsRepository extends JpaRepository<Tenants, Long> {

}
