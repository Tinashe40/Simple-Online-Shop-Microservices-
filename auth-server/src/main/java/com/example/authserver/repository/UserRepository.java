package com.example.authserver.repository;

import com.example.authserver.model.User;

public class UserRepository extends JpaRepository<User, Long>{
  User findByUsername(String username);
}
