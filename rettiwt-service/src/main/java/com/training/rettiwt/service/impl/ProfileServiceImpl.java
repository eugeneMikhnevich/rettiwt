package com.training.rettiwt.service.impl;

import com.training.rettiwt.dao.api.ProfileDao;
import com.training.rettiwt.model.Profile;
import com.training.rettiwt.service.api.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService {

    private ProfileDao profileDao;

    @Autowired
    public ProfileServiceImpl(final ProfileDao profileDao) {
        this.profileDao = profileDao;
    }

    @Override
    public void save(final Profile profile) {
        profileDao.save(profile);
    }

    @Override
    public Profile get(final Long id) {
        return profileDao.get(id);
    }

    @Override
    public void update(final Profile profile) {
        profileDao.update(profile);
    }

    @Override
    public void delete(final Long id) {
        profileDao.delete(id);
    }
}
