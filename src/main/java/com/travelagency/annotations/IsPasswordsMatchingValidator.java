package com.travelagency.annotations;


import com.travelagency.models.bindingModels.UserDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsPasswordsMatchingValidator implements ConstraintValidator<IsPasswordsMatching, Object> {
    @Override
    public void initialize(IsPasswordsMatching isPasswordsMatching) {

    }

    @Override
    public boolean isValid(Object userClass, ConstraintValidatorContext constraintValidatorContext) {
        if(userClass instanceof UserDto){
            return ((UserDto) userClass).getPassword().equals(((UserDto) userClass).getConfirmPassword());
        }

        return false;
    }
}
