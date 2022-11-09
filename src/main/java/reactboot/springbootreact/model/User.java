package reactboot.springbootreact.model;


import javax.persistence.*;

@Entity
@Table(name="users")
public class User {
    /* so um comentario  */


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //especificando o atributo da bean para nao reverter para o default
    @Column(name="nome")
    private String nome;
    @Column(name="sobrenome")
    private String sobrenome;

    private String email;

    public User(){

    }

    public User(String nome, String sobrenome, String email){

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

    public void setNome(){
          this.nome=nome;
    }


    public String getSobrenome(){
      return sobrenome;

    }


    public void setSobrenome(){
         this.sobrenome=sobrenome;

    }

    public String getEmail(){
        return email;


    }

    public void setEmail(){

        this.email=email;
    }

}

