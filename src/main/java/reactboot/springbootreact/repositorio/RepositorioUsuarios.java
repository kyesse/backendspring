package reactboot.springbootreact.repositorio;

import reactboot.springbootreact.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioUsuarios extends JpaRepository<User,Long> {




}