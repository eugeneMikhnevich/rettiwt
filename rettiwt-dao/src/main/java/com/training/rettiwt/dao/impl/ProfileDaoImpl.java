package com.training.rettiwt.dao.impl;

import com.training.rettiwt.dao.api.ProfileDao;
import com.training.rettiwt.model.Profile;
import org.springframework.stereotype.Repository;

@Repository
public class ProfileDaoImpl extends BaseDaoImpl<Profile, Long> implements ProfileDao {

    public ProfileDaoImpl() {
        super(Profile.class);
    }
}
