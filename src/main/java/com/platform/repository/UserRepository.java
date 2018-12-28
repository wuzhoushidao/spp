package com.platform.repository;

import com.platform.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: zwl
 * @Date: 2018/12/24 17:45
 */
public interface UserRepository extends JpaRepository<User,Integer> {

    User findByUsername(String username);

}
