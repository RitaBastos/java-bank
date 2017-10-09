package org.academiadecodigo.javabank.View;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.menu.MenuInputScanner;
import org.academiadecodigo.javabank.Controller.LoginController;
import org.academiadecodigo.javabank.Controller.MenuController;
import org.academiadecodigo.javabank.Utils.Messages;

public class MenuView implements View{

    private Prompt prompt;

    private MenuController firstmenu;

    @Override

    public void show(){
        MenuInputScanner mainMenu = new MenuInputScanner(UserOptions.getMessages());
        mainMenu.setError(Messages.ERROR_INVALID_OPTION);
        mainMenu.setMessage(Messages.MENU_WELCOME);




    }



}
