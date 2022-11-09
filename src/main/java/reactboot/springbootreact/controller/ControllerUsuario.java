package reactboot.springbootreact.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import reactboot.springbootreact.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactboot.springbootreact.repositorio.RepositorioUsuarios;

import java.util.List;


@CrossOrigin (origins ="http://localhost:3000")
@RestController
@RequestMapping("api/")
public class ControllerUsuario {

@Autowired
private RepositorioUsuarios RepositorioUsuarios;

@GetMapping("users")
public List<User> getUsers(){
   return this.RepositorioUsuarios.findAll();

}


}



