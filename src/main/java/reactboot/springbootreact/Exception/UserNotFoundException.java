package reactboot.springbootreact.Exception;

public class UserNotFoundException extends  RuntimeException{

    public UserNotFoundException(Long id){
        super("Nenhum resultado para esse ID" + id );

    }



}
