package com.demo.jpa.dao.mongoDao;

/**
 * Created by anyayudkovsky on 1/4/16.
 */
import java.util.List;


import com.demo.jpa.models.mongo.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IAccountDao extends MongoRepository<Account, String>{
    public Account findByName(String name);

}

