package reactboot.springbootreact.model;


import org.springframework.validation.annotation.Validated;
import reactboot.springbootreact.controller.ControllerUsuario;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.validation.Validator;




@Validated
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //adicionando colunas e demais elementos pra tabela do banco de dados temporario, trabalhando com o H2 database que carreguei nas dependencias do projeto.



    @Column(name="nome")

     @NotNull(message="campo nulo")
    @NotBlank(message="campo nome VAZIO")
    private String nome;

    @NotNull(message="campo nulo")
    @NotBlank(message="campo sobrenome VAZIO")
    @Column(name="sobrenome")
    private String sobrenome;

    @NotNull(message="campo nulo")
    @NotBlank(message="campo email VAZIO")
    private String email;

    public User(){

    }


    public User( String nome, String sobrenome, String email){

        super();
        this.nome=nome;
        this.sobrenome=sobrenome;
        this.email=email;

    }

    public long getid(){
        return id;

    }

    public void setid(){
           this.id=id;

    }



    public String getNome(){

        return nome;


    }

    public void setNome(String nome){

        this.nome=nome;
    }


    public String getSobrenome(){
      return sobrenome;

    }


    public void setSobrenome(String sobrenome){
         this.sobrenome=sobrenome;

    }

    public String getEmail(){
        return email;


    }

    public void setEmail(String email){

        this.email=email;
    }

}

