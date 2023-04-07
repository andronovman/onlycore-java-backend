package ru.shortee.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.shortee.entity.UserEntity;

import java.util.List;

@Repository
public interface UserRepo extends CrudRepository<UserEntity, Long> {
    List<UserEntity> findAll();
}
