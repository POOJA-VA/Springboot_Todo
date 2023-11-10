package com.pooja.springboot_Todo.service;

import com.pooja.springboot_Todo.model.AppUser;
import com.pooja.springboot_Todo.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private AppUserRepository appUserRepository;
    public AppUser login(AppUser appUser) {
        AppUser loggedInUser = appUserRepository
                .findUserByUserNameAndPassword(appUser.getUsername(), appUser.getPassword());
        return loggedInUser;
    }
    public AppUser register(AppUser appUser) {
        appUserRepository.save(appUser);
        return appUser;
    }
}