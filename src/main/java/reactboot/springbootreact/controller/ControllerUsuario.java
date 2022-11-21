package reactboot.springbootreact.controller;


import org.springframework.web.bind.annotation.*;
import reactboot.springbootreact.Exception.UserNotFoundException;
import reactboot.springbootreact.model.User;
import org.springframework.beans.factory.annotation.Autowired;
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

//Criar usuario no banco de dados

    @PostMapping("users")
    public User criarusuario(@RequestBody User user){
    return this.RepositorioUsuarios.save(user);

    }

    //Editar usuario ja existente

    @GetMapping("users/{id}")
    User getUserById(@PathVariable Long id){

    return this.RepositorioUsuarios.findById(id)
            .orElseThrow(()->new UserNotFoundException(id));

    }


    @PutMapping("users/{id}")
    User updateUsuario(@RequestBody User userEditado,@PathVariable Long id){
      return this.RepositorioUsuarios.findById(id)
              .map(User->{

                  User.setNome(userEditado.getNome());
                  User.setSobrenome(userEditado.getSobrenome());
                  User.setEmail(userEditado.getEmail());
                  return this.RepositorioUsuarios.save(User);
                      } ).orElseThrow(()->new UserNotFoundException(id));


    }

    @DeleteMapping("users/{id}")
    String deletarUsuario(@PathVariable Long id){
    if(!RepositorioUsuarios.existsById(id)){
        throw new UserNotFoundException(id);
            }
    RepositorioUsuarios.deleteById(id);
    return "usuario com o id"+id+"deletado com sucesso";



    }




}



