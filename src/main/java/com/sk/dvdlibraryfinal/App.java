/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sk.dvdlibraryfinal;

import com.sk.dvdlibraryfinal.Controller.DvdLibraryController;
import com.sk.dvdlibraryfinal.dao.DvdLibraryDao;
import com.sk.dvdlibraryfinal.dao.DvdLibraryDaoFileImpl;
import com.sk.dvdlibraryfinal.ui.DvdLibraryView;
import com.sk.dvdlibraryfinal.ui.UserIO;
import com.sk.dvdlibraryfinal.ui.UserIOConsoleImpl;

/**
 *
 * @author SHIVALI
 */
public class App {

    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();// declare UserIO variable and intialize it with a UserIOConsoleImpl reference
        DvdLibraryView myView = new DvdLibraryView(myIo);
        DvdLibraryDao myDao = new DvdLibraryDaoFileImpl();
        DvdLibraryController controller = new DvdLibraryController(myDao, myView);
        controller.run();
    }
}
