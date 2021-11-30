/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sk.dvdlibraryfinal.Controller;

import com.sk.dvdlibraryfinal.dao.DvdLibraryDao;
import com.sk.dvdlibraryfinal.dao.DvdLibraryDaoException;
import com.sk.dvdlibraryfinal.dao.DvdLibraryDaoFileImpl;
import com.sk.dvdlibraryfinal.dto.Dvd;
import com.sk.dvdlibraryfinal.ui.DvdLibraryView;
import com.sk.dvdlibraryfinal.ui.UserIO;
import com.sk.dvdlibraryfinal.ui.UserIOConsoleImpl;
import java.util.List;

/**
 *
 * @author SHIVALI
 */
public class DvdLibraryController {

    //This class manage application.It knows what needs to be done when it needs to be done and what componner can do the job   
// removed hard coded references
    // private DvdLibraryView view = new DvdLibraryView();// to add memebr of view class and controller use it for displaying the meny and getting the user's selection
    //private DvdLibraryDao dao = new DvdLibraryDaoFileImpl();
    // private UserIO io = new UserIOConsoleImpl();
    // new declarations  
    private DvdLibraryView view;
    private DvdLibraryDao dao;

    public DvdLibraryController(DvdLibraryDao dao, DvdLibraryView view) {
        this.dao = dao;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {
                // io.print("Main Menu");
                // io.print("1. List All DVDs");
                // io.print("2. Add a DVD");
                // io.print("3. Remove a DVD");
                // io.print("4. Edit a DVDs Information");
                //  io.print("5. Search and View Information by DVD Title");
                // io.print("6. Exit");
                menuSelection = getMenuSelection();
                switch (menuSelection) {
                    case 1:
                        listDvds();
                        break;
                    case 2:
                        addDvd();
                        break;
                    case 3:
                        removeDvd();
                        break;
                    case 4:
                        editDvd();
                        break;
                    case 5:
                        searchAndViewDvd();
                        break;
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }

            }
        } catch (DvdLibraryDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
        exitMessage();
    }
    // io.print("GOOD BYE!");

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void listDvds() throws DvdLibraryDaoException {
        view.displayListAllDvdsBanner();
        List<Dvd> dvdList = dao.getAllDvds();
        view.displayDvdList(dvdList);
    }

    private void addDvd() throws DvdLibraryDaoException {
        view.displayAddDvdBanner();
        Dvd newDvd = view.getNewDvdInfo();
        dao.addDvd(newDvd.getTitle(), newDvd);
        view.displayAddDvdSuccessBanner();
    }

    private void removeDvd() throws DvdLibraryDaoException {
        view.displayRemoveDvdBanner();
        String dvdTitle = view.getDvdTitleChoice();
        Dvd removeDvd = dao.removeDvd(dvdTitle);
        view.displayRemoveResult(removeDvd);
    }

    private void editDvd() throws DvdLibraryDaoException {
        view.displayEditDvdBanner();
        String dvdTitle = view.getDvdTitleChoice();
        Dvd dvd = dao.getDvd(dvdTitle);
        view.getEditDvdInfo(dvd);
        dao.addDvd(dvdTitle, dvd);
        view.displayEditDvdSuccessBanner();
    }

    private void searchAndViewDvd() throws DvdLibraryDaoException {
        view.displaySearchDvdByNameBanner();
        String dvdTitle = view.getDvdTitleChoice();
        Dvd dvd = dao.getDvd(dvdTitle);
        view.displayDvd(dvd);
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

}
