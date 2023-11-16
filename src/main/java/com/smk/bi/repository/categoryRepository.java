package com.smk.bi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smk.bi.model.Category;

public interface categoryRepository extends JpaRepository<Category, Long> {
    
}
