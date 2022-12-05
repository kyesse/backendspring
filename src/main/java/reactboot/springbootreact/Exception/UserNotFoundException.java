package reactboot.springbootreact.Exception;

import reactboot.springbootreact.model.User;

public class UserNotFoundException extends  RuntimeException{



    public UserNotFoundException(Long id){
        super("Nenhum resultado para esse ID" + id );

    }




}
