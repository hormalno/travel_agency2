package com.travelagency.services;

import com.travelagency.models.bindingModels.UserDto;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    void create(UserDto userDto);

    @PreAuthorize("hasRole('ADMIN')")
    void delete();

}
