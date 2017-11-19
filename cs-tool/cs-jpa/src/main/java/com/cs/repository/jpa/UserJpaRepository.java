package com.cs.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cs.model.CsUser;

@Repository
public interface UserJpaRepository extends JpaRepository<CsUser, String> {

	
	@Query(value = "select id from cs_user ", nativeQuery = true)
	List<String> allUserId();

	@Modifying
	@Query(value = "update  cs_user  set status=:num  where id=:id ", nativeQuery = true)
	int updateStatus(@Param("id") Long uiId, @Param("num") int num);
}
