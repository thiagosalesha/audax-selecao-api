package com.audax.cadastro.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.audax.cadastro.model.Articles;
import com.audax.cadastro.model.Users;

@Repository
public interface ArticlesRepository extends JpaRepository<Articles, Long>{

	Optional<Articles> findByUuid(String uuid);

	Optional<Articles> findByUser(Users users);

	Optional<Articles> findByTitle(String title);

}
