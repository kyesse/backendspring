package reactboot.springbootreact;

import reactboot.springbootreact.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"reactboot/springbootreact/model", "reactboot/springbootreact/controller", "reactboot/springbootreact/repositorio"})

public class SpringbootreactApplication{

	public static void main(String[] args) {
		SpringApplication.run(SpringbootreactApplication.class, args);
	}


        //Criando elementos estáticos para a database H2, apenas para fins de testes dos metodos do springboot (getmapping), e java (findall)etc,  e do axios no frontend.
        @Autowired
		
		private reactboot.springbootreact.repositorio.RepositorioUsuarios RepositorioUsuarios;
		public void run(String... args) throws Exception {
		RepositorioUsuarios.save(new User("Roger","Waters","rgrwaterspf@gmail.com"));
		RepositorioUsuarios.save(new User("Peter","Gabriel","sledgehammer@gmail.com"));
		RepositorioUsuarios.save(new User("Rick","Wakeman","srick.wake77@gmail.com"));
		RepositorioUsuarios.save(new User("Chuck","Berry","MrChuck10@gmail.com"));
		RepositorioUsuarios.save(new User("Charles","Mingus","chrmngus@yahoo.com"));
		RepositorioUsuarios.save(new User("Miles","Davis","mldvis@yahoo.com"));

	}

}
