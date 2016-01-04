package com.demo.jpa.dao.jpaDao;

/**
 * Created by anyayudkovsky on 12/30/15.
 */


import java.util.List;

import com.demo.jpa.models.jpa.Users;
import org.springframework.data.repository.CrudRepository;

public interface IUserDao extends CrudRepository<Users, Long> {
    List<Users> findByFirstName(String firstName);
    List<Users> findByLastName(String lastName);
}