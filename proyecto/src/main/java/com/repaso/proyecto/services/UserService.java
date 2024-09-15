package com.repaso.proyecto.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.repaso.proyecto.repositories.UserRepository;
import com.repaso.proyecto.models.UserModel;

@Service
public class UserService {
    
  
  @Autowired
  UserRepository userRepository;

  public ArrayList<UserModel> obtenerUsuarios(){
     return (ArrayList <UserModel>) userRepository.findAll();
  }


  public UserModel guardarUsuario(UserModel usuario){
    return userRepository.save(usuario);
  }


  public Optional <UserModel> obtenerPorid(long id){
    return userRepository.findById(id);
  }

  

  public ArrayList<UserModel> obtenerPorPrioridad(Integer prioridad){
    return userRepository.findByPrioridad(prioridad);
  }

     public boolean  eleminarUsuario(Long id){

        try {
            userRepository.deleteById(id);
            return true;

        }catch(Exception err){
          return false;


        }


     }





}
