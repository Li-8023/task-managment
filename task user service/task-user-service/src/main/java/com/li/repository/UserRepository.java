package com.li.repository;

import com.li.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: li he
 **/

//user JpaRepository, we can get the CURD method for free
public interface UserRepository extends JpaRepository<User, Long> {

    public User findByEmail(String email);

}
