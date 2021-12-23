package com.nepalaya.up.builder;

import com.nepalaya.up.model.Role;
import com.nepalaya.up.model.User;
import com.nepalaya.up.model.enums.GenderType;
import com.nepalaya.up.request.CreateUserRequest;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class UserBuilder {

    private final PasswordGenerator passwordGenerator;

    public UserBuilder(PasswordGenerator passwordGenerator) {
        this.passwordGenerator = passwordGenerator;
    }

    public User buildForCreate(CreateUserRequest request) {
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setMiddleName(request.getMiddleName());
        user.setLastName(request.getLastName());
        if (request.getIsPasswordGenerated()) {
            CharacterRule digits = new CharacterRule(EnglishCharacterData.Digit);
            CharacterRule alphanumeric = new CharacterRule(EnglishCharacterData.Alphabetical);
            CharacterRule special = new CharacterRule(EnglishCharacterData.Special);
            List<CharacterRule> rules = Arrays.asList(digits,alphanumeric,special);
            String password = passwordGenerator.generatePassword(12, rules);
            user.setPassword(password);
        } else {
            user.setPassword(request.getPassword());
        }
        user.setAddress(request.getAddress());
        user.setEmailAddress(request.getEmailAddress());
        user.setContactNo(request.getContactNo());
        user.setGenderType(GenderType.valueOf(request.getGenderType()));
        user.setRole(new Role(request.getRoleId()));
        return user;
    }
}
