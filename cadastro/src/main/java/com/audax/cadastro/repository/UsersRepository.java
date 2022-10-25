package com.audax.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.audax.cadastro.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {


}
