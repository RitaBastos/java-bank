package org.academiadecodigo.javabank.controller;

import org.academiadecodigo.javabank.services.AuthServiceImpl;
import org.academiadecodigo.javabank.view.View;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;



public class MainControllerTest {

    private MainController mainController =  Mockito.mock(MainController.class);
    private View view;
    private MainController UserOptions;

    private AuthServiceImpl authService = Mockito.mock(AuthServiceImpl.class);

    @Before
    public void setUp(){
        mainController = new MainController();
        view = Mockito.mock(View.class);


    }

    @Test
    public void initTest(){
        mainController.init();
        Mockito.verify(view).show();

    }

    @Test
    public void onMenuSelectionQuitTest(){


    }
}
