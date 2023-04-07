package ru.shortee.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class UserEntity extends BaseEntity {

    @Column(name = "username")
    private String name;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private Boolean active;

    @Column(name = "activate_date")
    private Date activateDate;

    @Column(name = "registration_date")
    private Date registrationDate;

    @Column(name = "last_login_date")
    private Date lastLoginDate;

    @Column(name = "access_token")
    private String accessToken;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = {@JoinColumn(name="user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name="role_id", referencedColumnName = "id")}
    )
    private List<RoleEntity> roles;
}
