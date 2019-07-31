package com.training.rettiwt.web.converter;

import com.training.rettiwt.model.Profile;
import com.training.rettiwt.web.dto.AccountDto;
import com.training.rettiwt.web.dto.ProfileDto;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.LazyInitializationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ProfileDtoConverter {

    private AccountDtoConverter accountDtoConverter;

    @Autowired
    public ProfileDtoConverter(final AccountDtoConverter accountDtoConverter) {
        this.accountDtoConverter = accountDtoConverter;
    }

    public ProfileDto convertToDto(Profile profile) {
        ProfileDto profileDto = new ProfileDto();
        profileDto.setId(profile.getId());
        profileDto.setCreatedAt(profile.getCreatedAt());
        profileDto.setUpdatedAt(profile.getUpdatedAt());
        profileDto.setFirstName(profile.getFirstName());
        profileDto.setLastName(profile.getLastName());
        profileDto.setNickname(profile.getNickname());
        profileDto.setDescription(profile.getDescription());
        profileDto.setLocation(profile.getLocation());
        try {
            AccountDto accountDto = accountDtoConverter.convertToDto(profile.getAccount());
            profileDto.setAccount(accountDto);
        } catch (LazyInitializationException e) {
            log.info("ignore converting account");
        }
        return profileDto;
    }

    public Profile convertFromDto(ProfileDto profileDto) {
        Profile profile = new Profile();
        profile.setId(profileDto.getId());
        profile.setCreatedAt(profileDto.getCreatedAt());
        profile.setUpdatedAt(profileDto.getUpdatedAt());
        profile.setFirstName(profileDto.getFirstName());
        profile.setLastName(profileDto.getLastName());
        profile.setNickname(profileDto.getNickname());
        profile.setDescription(profileDto.getDescription());
        profile.setLocation(profileDto.getLocation());
        AccountDto accountDto = profileDto.getAccount();
        if (accountDto != null) {
            profile.setAccount(accountDtoConverter.convertFromDto(accountDto));
        }
        return profile;
    }
}
