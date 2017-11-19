package com.cs.repository;

import org.springframework.data.repository.CrudRepository;

import com.cs.model.CsUser;

public interface UserRepository extends CrudRepository<CsUser,Long> {

}
