package reactboot.springbootreact.repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import reactboot.springbootreact.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@repository, junto com o Jparepository,para criar um repositorio e guardar data para realizar funções CRUD basicas, para os fins dessa pequena aplicação, usando a H2 databse, criando um banco de dados temporario enquanto a execução da aplicação.
@Repository
public interface RepositorioUsuarios extends JpaRepository<User,Long> {


//@Query(value="select * from users e where nome like %:keyword% ", nativeQuery = true)
@Query(value="SELECT * FROM USERS WHERE NOME =:keyword", nativeQuery = true)
List<User> findByKeyword(@Param("keyword") String keyword);



}