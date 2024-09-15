package com.repaso.proyecto.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.repaso.proyecto.models.UserModel;
import java.util.*;


@Repository
public interface UserRepository extends CrudRepository<UserModel,Long> {
    public abstract ArrayList<UserModel> findByPrioridad(Integer prioridad);

}
