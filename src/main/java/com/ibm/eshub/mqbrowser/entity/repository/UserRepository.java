package com.ibm.eshub.mqbrowser.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.eshub.mqbrowser.entity.data.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
