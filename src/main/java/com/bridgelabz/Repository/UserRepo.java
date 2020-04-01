package com.bridgelabz.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.Model.User;


public interface UserRepo extends JpaRepository<User, Long> {

}
