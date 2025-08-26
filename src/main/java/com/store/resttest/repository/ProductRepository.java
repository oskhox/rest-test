package com.store.resttest.repository;

import com.store.resttest.model.Root;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Root, Integer> {
}
