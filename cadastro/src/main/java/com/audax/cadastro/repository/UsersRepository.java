package com.audax.cadastro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.audax.cadastro.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

	Object findByUsername(String username);

	Users findByUuid(String uuid);

	void deleteByUuid(String uuid);


}
