package ru.shortee.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Value;
import ru.shortee.entity.RoleEntity;
import ru.shortee.entity.UserEntity;

import java.util.Date;
import java.util.List;

public enum UserDTO {
    ;
    private interface Id { @Positive Long getId(); }
    private interface Name { @NotBlank(message = "Username must not be empty") String getName(); }
    private interface Email { @NotBlank(message = "Email must be a valid email address") String getEmail(); }
    private interface Password { @NotBlank(message = "Password must not be empty") String getPassword(); }
    private interface Active { @NotBlank(message = "Active flag must specified") Boolean isActive(); }
    private interface Roles { @NotBlank List<RoleEntity> getRoles(); }
    private interface ActivateDate { Date getActivateDate(); }
    private interface RegistrationDate { Date getRegistrationDate(); }
    private interface LastLoginDate { Date getLastLoginDate(); }
    private interface AccessToken { String getAccessToken(); }

    public enum Request {
        ;
        @Value
        public static class Registration implements Email, Password {
            String  email;
            String  password;
        }

    }

    public enum Response {
        ;
        @Value
        public static class Registration implements Id, Name, Email, Roles, RegistrationDate {
            Long     id;
            String   name;
            String   email;
            List<RoleEntity> roles;
            Date     registrationDate;

            public Registration(UserEntity user) {
                id = user.getId();
                name = user.getName();
                email = user.getEmail();
                roles = user.getRoles();
                registrationDate = user.getRegistrationDate();
            }
        }

    }
}
