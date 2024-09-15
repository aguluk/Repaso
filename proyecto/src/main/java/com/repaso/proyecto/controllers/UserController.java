package com.repaso.proyecto.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.repaso.proyecto.models.UserModel;
import com.repaso.proyecto.services.UserService;

@RestController
@RequestMapping("/usuario")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping()
    public ArrayList<UserModel> obtenerUsuarios() {
        return userService.obtenerUsuarios(); }



    @PostMapping()
    public UserModel guardarUsuario(@RequestBody UserModel usuario){
        return this.userService.guardarUsuario(usuario);    }

    
    
    @GetMapping(path = "/{id}")
    public Optional<UserModel> obtenerUsuariosPorId(@PathVariable ("id")Long id) {
       return this.userService.obtenerPorid(id); }

      
    @GetMapping(path = "/query?")
    public ArrayList<UserModel> obtenerUsuariosPorPrioridad(@RequestParam ("prioridad")Integer prioridad) {
     return this.userService.obtenerPorPrioridad(prioridad); }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id")Long id){
       boolean ok = this.userService.eleminarUsuario(id);
       if(ok){
            return "se elimino el usuario con id " + id;

       }else{

            return "No puedo eliminar el usuario con id"+ id;
       }






    }



}
