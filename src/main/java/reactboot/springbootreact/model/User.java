package reactboot.springbootreact.model;


import javax.persistence.*;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //adicionando colunas e demais elementos pra tabela do banco de dados temporario, trabalhando com o H2 database que carreguei nas dependencias do projeto.
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

