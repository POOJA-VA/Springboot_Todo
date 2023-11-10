package com.pooja.springboot_Todo.repository;

import com.pooja.springboot_Todo.model.AppUser;
import org.hibernate.validator.constraints.ParameterScriptAssert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Integer > {
    @Query("from AppUser u WHERE u.username=:username AND u.password=:password")
    AppUser findUserByUserNameAndPassword(@Param("username") String username, @Param("password") String password);
}