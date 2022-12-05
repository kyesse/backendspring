package reactboot.springbootreact.controller;


import org.springframework.data.domain.Sort;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactboot.springbootreact.Exception.UserNotFoundException;
import reactboot.springbootreact.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import reactboot.springbootreact.repositorio.RepositorioUsuarios;


import javax.validation.Valid;
import java.util.List;

//importante, bean cross origin vai injetar as dependencias necessarias pra compartilhar recursos e metodos especificados para o browser, como o get request,permitindo o react puxar os usuarios pra renderizar no DOM
//localhost apenas fins de teste, será trocado por um host publico.
@CrossOrigin (origins ="http://localhost:3000")
@RestController
@RequestMapping("api/")
@Validated
public class ControllerUsuario {


   //Validação de objeto
@Autowired

private RepositorioUsuarios RepositorioUsuarios;

int search=0;
String flagSearch;
//getmapping, hhtp GET request pra puxar data, trazendo como resultado todos com a tag users, atraves do metodo findall

    @GetMapping("users")
public List<User> getUsers(){

    //..pra remover o sorting, so tirar esse objeto sort dos argumentos do findall
    Sort sort= Sort.by("id").descending();


    if (search==0) {

        return this.RepositorioUsuarios.findAll();
    } else
        search=0;
        return this.RepositorioUsuarios.findByKeyword(flagSearch);

}

//Criar usuario no banco de dados

    @PostMapping("users")
    public User criarusuario(  @RequestBody @Valid User user){

    return this.RepositorioUsuarios.save(user);


    }

    //Editar usuario ja existente naught to alter on this fskeu

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


    @GetMapping("search/{keyword}")
    public List<User> procurarUsuario(@PathVariable String keyword){

       // return this.RepositorioUsuarios.findById(id)
            //    .orElseThrow(()->new UserNotFoundException(id));
        search=1;
        flagSearch=keyword;
       return this.RepositorioUsuarios.findByKeyword(keyword);


       // return this.RepositorioUsuarios.findByKeyword(keyword);
       // return this.RepositorioUsuarios.findAll(sort);
        // return this.RepositorioUsuarios.findAll();

    }




}



