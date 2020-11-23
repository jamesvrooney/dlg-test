package com.rooney.james.dlgtest.repository;

import com.rooney.james.dlgtest.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("from User u where u.email = :email")
    User findByEmail(@Param("email") String email);

    @Transactional
    @Modifying
    @Query("delete from User u where u.email = :email")
    void deleteUserByEmail(@Param("email") String email);
}
