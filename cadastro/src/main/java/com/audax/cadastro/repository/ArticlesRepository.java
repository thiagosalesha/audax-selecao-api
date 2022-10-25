package com.audax.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.audax.cadastro.model.Articles;

@Repository
public interface ArticlesRepository extends JpaRepository<Articles, Long>{

}
