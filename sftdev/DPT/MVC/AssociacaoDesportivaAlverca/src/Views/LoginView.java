package Views;

import Controllers.LoginController;

public class LoginView {
    LoginController loginController;

    public LoginView(){
        this.loginController = new LoginController();
    }
    public void entrar(){
        //opcoes menu
    }

    private void validarLogin( String userName, String password){
        //valida com o controller se o userName e password são válidos e pertencem à treinador ou admin.
    }
}
