package ru.shortee.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.shortee.entity.RoleEntity;

@Repository
public interface RoleRepo extends CrudRepository<RoleEntity, Long> {
    public RoleEntity findByName(String name);
}
