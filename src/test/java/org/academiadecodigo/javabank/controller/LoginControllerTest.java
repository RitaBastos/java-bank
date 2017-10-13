package org.academiadecodigo.javabank.controller;


import org.academiadecodigo.javabank.services.AuthServiceImpl;
import org.academiadecodigo.javabank.view.View;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.when;


public class LoginControllerTest {

    private LoginController loginController;
    private View view;
    private AuthServiceImpl authService = Mockito.mock(AuthServiceImpl.class);
    private Controller controller = Mockito.mock(Controller.class);


    @Before
    public void setUp(){
        loginController = new LoginController();
        view = Mockito.mock(View.class);
        loginController.setView(view);
        loginController.setAuthService(authService);
        loginController.setNextController(controller);
    }

    @Test
    public void initTest(){
        loginController.init();
        Mockito.verify(view).show();

    }

    @Test

    public void onLoginTest(){

        int fackeId = 1;

        when(authService.authenticate(fackeId)).thenReturn(true);
        loginController.onLogin(fackeId);
        Mockito.verify(controller).init();

    }

    @Test

    public void offLoginTest(){

        when(authService.authenticate(1)).thenReturn(false);
        loginController.onLogin(1);
        Mockito.verify(controller, never()).init();


    }



}
