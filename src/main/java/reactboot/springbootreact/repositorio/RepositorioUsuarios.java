package reactboot.springbootreact.repositorio;

import reactboot.springbootreact.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@repository, junto com o Jparepository,para criar um repositorio e guardar data para realizar funções CRUD basicas, para os fins dessa pequena aplicação, usando a H2 databse, criando um banco de dados temporario enquanto a execução da aplicação.
@Repository
public interface RepositorioUsuarios extends JpaRepository<User,Long> {




}