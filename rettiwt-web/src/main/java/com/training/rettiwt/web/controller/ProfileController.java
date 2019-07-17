package com.training.rettiwt.web.controller;

import com.training.rettiwt.model.Profile;
import com.training.rettiwt.service.api.ProfileService;
import com.training.rettiwt.web.converter.ProfileDtoConverter;
import com.training.rettiwt.web.dto.ProfileDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("profiles")
public class ProfileController {

    private ProfileService profileService;
    private ProfileDtoConverter profileDtoConverter;

    @Autowired
    public ProfileController(final ProfileService profileService,
                             final ProfileDtoConverter profileDtoConverter) {
        this.profileService = profileService;
        this.profileDtoConverter = profileDtoConverter;
    }

    @GetMapping("{id}")
    public ProfileDto findById(@PathVariable(name = "id") Long id) {
        Profile profile = profileService.findById(id);
        return profileDtoConverter.convertToDto(profile);
    }

    @GetMapping
    public List<ProfileDto> findAll() {
        return profileService.findAll().stream()
                .map(profileDtoConverter::convertToDto)
                .collect(toList());
    }

    @PostMapping
    public void save(@RequestBody ProfileDto profileDto) {
        Profile profile = profileDtoConverter.convertFromDto(profileDto);
        profileService.save(profile);
    }

    @PutMapping("{id}")
    public void update(@PathVariable(name = "id") Long id,
                       @RequestBody ProfileDto profileDto) {
        Profile profile = profileDtoConverter.convertFromDto(profileDto);
        profileService.update(id, profile);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        profileService.delete(id);
    }
}
