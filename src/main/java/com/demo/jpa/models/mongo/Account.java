package com.demo.jpa.models.mongo;

/**
 * Created by anyayudkovsky on 1/4/16.
 */
import org.springframework.data.annotation.Id;

import java.util.Date;


public class Account {

    @Id
    private String id;

    private String name;
    private String createdByUserID;
    private String lastModifiedByUserID;
    private Date createdDate;
    private Date lastModifiedDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatedByUserID() {
        return createdByUserID;
    }

    public void setCreatedByUserID(String createdByUserID) {
        this.createdByUserID = createdByUserID;
    }

    public String getLastModifiedByUserID() {
        return lastModifiedByUserID;
    }

    public void setLastModifiedByUserID(String lastModifiedByUserID) {
        this.lastModifiedByUserID = lastModifiedByUserID;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Account() {}

    public Account(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format(
                "Account[id=%s, name='%s']",
                id, name);
    }

}