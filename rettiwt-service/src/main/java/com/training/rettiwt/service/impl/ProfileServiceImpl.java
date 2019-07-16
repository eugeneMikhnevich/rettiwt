package com.training.rettiwt.service.impl;

import com.training.rettiwt.dao.api.AccountDao;
import com.training.rettiwt.dao.api.ProfileDao;
import com.training.rettiwt.model.Account;
import com.training.rettiwt.model.Profile;
import com.training.rettiwt.service.api.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static java.time.LocalDateTime.now;
import static org.springframework.util.StringUtils.isEmpty;

@Service
public class ProfileServiceImpl implements ProfileService {

    private ProfileDao profileDao;
    private AccountDao accountDao;

    @Autowired
    public ProfileServiceImpl(final ProfileDao profileDao, final AccountDao accountDao) {
        this.profileDao = profileDao;
        this.accountDao = accountDao;
    }

    @Override
    public void save(final Profile profile) {
        LocalDateTime creationDateTime = now();
        profile.setCreatedAt(creationDateTime);
        profile.setUpdatedAt(creationDateTime);
        if (isEmpty(profile.getNickname())) {
            profile.setNickname(generateDefaultNickname(profile));
        }
        Account account = profile.getAccount();
        account.setCreatedAt(creationDateTime);
        account.setUpdatedAt(creationDateTime);
        profileDao.save(profile);
    }

    @Override
    public Profile findById(final Long id) {
        return profileDao.findById(id);
    }

    @Override
    public List<Profile> findAll() {
        return profileDao.findAll();
    }

    @Override
    public void update(final Long id, final Profile profile) {
        profile.setId(id);
        profile.setUpdatedAt(now());
        profileDao.update(profile);
    }

    @Override
    public void delete(final Long id) {
        profileDao.delete(id);
    }

    // todo
    private String generateDefaultNickname(Profile profile) {
        return String.format("@%s_%s", profile.getFirstName().toLowerCase(), profile.getLastName().toLowerCase());
    }
}
