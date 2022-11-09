package reactboot.springbootreact.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import reactboot.springbootreact.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactboot.springbootreact.repositorio.RepositorioUsuarios;

import java.util.List;

//importante, bean cross origin vai injetar as dependencias necessarias pra compartilhar recursos e metodos especificados para o browser, como o get request,permitindo o react puxar os usuarios pra renderizar no DOM
//localhost apenas fins de teste, será trocado por um host publico.
@CrossOrigin (origins ="http://localhost:3000")
@RestController
@RequestMapping("api/")
public class ControllerUsuario {


   //Validação de objeto
@Autowired
private RepositorioUsuarios RepositorioUsuarios;


//getmapping, hhtp GET request pra puxar data, trazendo como resultado todos com a tag users, atraves do metodo findall
@GetMapping("users")
public List<User> getUsers(){
   return this.RepositorioUsuarios.findAll();

}


}



