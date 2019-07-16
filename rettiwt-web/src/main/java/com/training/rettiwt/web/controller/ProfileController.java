package com.training.rettiwt.web.controller;

import com.training.rettiwt.model.Profile;
import com.training.rettiwt.service.api.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("profiles")
public class ProfileController {

    private ProfileService profileService;

    @Autowired
    public ProfileController(final ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("{id}")
    public Profile findById(@PathVariable(name = "id") Long id) {
        return profileService.findById(id);
    }

    @GetMapping
    public List<Profile> findAll() {
        return profileService.findAll();
    }

    @PostMapping
    public void save(@RequestBody Profile profile) {
        profileService.save(profile);
    }

    @PutMapping("{id}")
    public void update(@PathVariable(name = "id") Long id,
                       @RequestBody Profile profile) {
        profileService.update(id, profile);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        profileService.delete(id);
    }
}
