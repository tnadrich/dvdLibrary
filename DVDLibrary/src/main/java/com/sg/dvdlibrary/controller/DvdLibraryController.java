/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.controller;

import com.sg.dvdlibrary.dao.DvdLibraryDao;
import com.sg.dvdlibrary.dao.DvdLibraryDaoException;
import com.sg.dvdlibrary.dto.Dvd;
import com.sg.dvdlibrary.ui.DvdLibraryView;
import java.util.List;

/**
 *
 * @author capta
 */
public class DvdLibraryController {

    private DvdLibraryView view;
    private DvdLibraryDao dao;

    public DvdLibraryController(DvdLibraryDao dao,
            DvdLibraryView view) {
        this.dao = dao;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {

                menuSelection = getMenuSelection();
                switch (menuSelection) {
                    case 1:
                        listDvds();
                        break;
                    case 2:
                        viewDvd();
                        break;
                    case 3:
                        searchDvd();
                        break;
                    case 4:
                        createDvd();
                        break;
                    case 5:
                        editDvd();
                        break;
                    case 6:
                        removeDvd();
                        break;
                    case 7:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }

            }
            exitMessage();
        } catch (DvdLibraryDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void createDvd() throws DvdLibraryDaoException {
        view.displayCreateDvdBanner();
        Dvd newDvd = view.getNewDvdInfo();
        dao.addDvd(newDvd.getTitle(), newDvd);
        view.displayCreateSuccessBanner();
    }

    private void listDvds() throws DvdLibraryDaoException {
        view.displayDisplayAllBanner();
        List<Dvd> dvdList = dao.getAllDvds();
        view.displayDvdList(dvdList);
    }

    private void viewDvd() throws DvdLibraryDaoException {
        view.displayDisplayDvdBanner();
        String dvdTitle = view.getDvdTitleChoice();
        Dvd dvd = dao.getDvd(dvdTitle);
        view.displayDvd(dvd);
    }

    private void removeDvd() throws DvdLibraryDaoException {
        view.displayRemoveDvdBanner();
        String dvdTitle = view.getDvdTitleChoice();
        Dvd dvd = dao.getDvd(dvdTitle);
        if (!dvdTitle.equals("") && dvd != null) {
            dao.removeDvd(dvdTitle);
            view.displayRemoveSuccessBanner();
        } else {
            view.displayRemoveSuccessFailure();
        }
    }

    private void searchDvd() throws DvdLibraryDaoException {

        String dvdTitleSearchTitle = view.getDvdTitleSearch();
        view.displaySearchDvdBanner();
        boolean noResults = true;
        if (dvdTitleSearchTitle != null && !dvdTitleSearchTitle.equals("")) {
            List<Dvd> dvdSearchList = dao.getAllDvds();
            for (Dvd searchData : dvdSearchList) {
                if (searchData.getTitle().contains(dvdTitleSearchTitle)) {
                    view.displayDvdObj(searchData);
                } else {
                    noResults = false;
                }
            }
            if (!noResults) {
                view.displayDvdSearchNoResults();
            } else {
                view.displayDvdSearchSuccess();
            }
        } else {
            view.displayDvdSearchNoResults();
        }
    }

    private void editDvd() throws DvdLibraryDaoException {
        String editDvdTitle = view.getDvdTitleChoice();
        view.displayEditDvdBanner();
        Dvd editDvd = dao.getDvd(editDvdTitle);
        view.displayEditDvd(editDvd);
        if (editDvd != null) {
            Dvd editedDvd = view.editDvdInfo(editDvd);
            dao.removeDvd(editDvdTitle);
            dao.addDvd(editedDvd.getTitle(), editedDvd);

        }

    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

}
