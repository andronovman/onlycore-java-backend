package ru.shortee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import ru.shortee.dto.UserDTO;
import ru.shortee.entity.UserEntity;
import ru.shortee.repository.RoleRepo;
import ru.shortee.repository.UserRepo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    public List<UserEntity> getAll() {
        return userRepo.findAll();
    }

    public UserEntity registration(UserDTO.Request.Registration request) {
        UserEntity user = new UserEntity();
        user.setName(request.getEmail().substring(0, request.getEmail().lastIndexOf("@")));
        user.setEmail(request.getEmail());
        user.setActive(false);
        user.setRoles(new ArrayList<>(){{
            add(roleRepo.findByName("ROLE_USER"));
        }});
        user.setRegistrationDate(new Date(System.currentTimeMillis()));
        user.setPassword(DigestUtils.md5DigestAsHex(request.getPassword().getBytes()).toUpperCase());
        user.setAccessToken(DigestUtils.md5DigestAsHex((request.getPassword() + String.valueOf(System.currentTimeMillis())).getBytes()).toUpperCase());
        return userRepo.save(user);
    }
}
