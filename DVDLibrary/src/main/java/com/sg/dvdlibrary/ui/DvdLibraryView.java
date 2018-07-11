/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.ui;

import com.sg.dvdlibrary.dto.Dvd;
import java.util.List;

/**
 *
 * @author capta
 */
public class DvdLibraryView {

    private UserIO io;

    public DvdLibraryView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List DVDs");
        io.print("2. View a DVD");
        io.print("3. Search for a DVD by title");
        io.print("4. Add a DVD");
        io.print("5. Edit a DVD");
        io.print("6. Remove a DVD");
        io.print("7. Exit");
        io.print("");

        return io.readInt("Please select from the above "
                + "choices.", 1, 7);

    }

    public Dvd getNewDvdInfo() {
        String dvdTitle = io.readString("Please enter DVD title");
        while (dvdTitle.equals("")) {
            dvdTitle = io.readString("Please enter a DVD title.");
        }
        String releaseDate = io.readString("Please enter the DVD release date");
        String mpaaRating = io.readString("Please enter the MPAA rating");
        String directorsName = io.readString("Please enter the DVD director's name");
        String studio = io.readString("Please enter the DVD studio");
        String note = io.readString("Please enter the user rating or any additional information");
        Dvd currentDvd = new Dvd(dvdTitle);
        currentDvd.setTitle(dvdTitle);
        if (releaseDate.equals("")) {
            releaseDate = "Release date not provided";
        }
        currentDvd.setReleaseDate(releaseDate);
        if (mpaaRating.equals("")) {
            mpaaRating = "MPAA rating not provided";
        }
        currentDvd.setMpaaRating(mpaaRating);
        if (directorsName.equals("")) {
            directorsName = "Director's name not provided";
        }
        currentDvd.setDirectorsName(directorsName);
        if (studio.equals("")) {
            studio = "Studio not provided";
        }
        currentDvd.setStudio(studio);
        if (note.equals("")) {
            note = "Additional info not provided";
        }
        currentDvd.setNote(note);
        return currentDvd;
    }

    public void displayCreateDvdBanner() {
        io.print("===== Create DVD =====");
    }

    public void displayCreateSuccessBanner() {
        io.print("");
        io.readString("DVD successfully created. Please hit enter to continue.");
    }

    public void displayDvdList(List<Dvd> dvdsList) {

        if (!dvdsList.isEmpty()) {
            for (Dvd currentDvd : dvdsList) {
                io.print("Title: " + currentDvd.getTitle());
                io.print("Release Date: " + currentDvd.getReleaseDate());
                io.print("MPAA Rating: " + currentDvd.getMpaaRating());
                io.print("Director's Name: " + currentDvd.getDirectorsName());
                io.print("Studio: " + currentDvd.getStudio());
                io.print("Note/Additional Information: " + currentDvd.getNote());
                io.print("");
            }
        } else {
            io.print("No DVDs in library.");
            io.print("");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayDvdObj(Dvd dvd) {
        io.print("Title: " + dvd.getTitle());
        io.print("Release Date: " + dvd.getReleaseDate());
        io.print("MPAA Rating: " + dvd.getMpaaRating());
        io.print("Director's Name: " + dvd.getDirectorsName());
        io.print("Studio: " + dvd.getStudio());
        io.print("Note/Additional Information: " + dvd.getNote());
        io.print("");
    }

    public void displayDisplayAllBanner() {
        io.print("");
        io.print("===== Display All DVDs =====");
    }

    public void displayDisplayDvdBanner() {
        io.print("");
        io.print("===== Display DVD =====");
    }

    public String getDvdTitleChoice() {
        return io.readString("Please enter the DVD title.");
    }

    public void displayDvd(Dvd dvd) {
        if (dvd != null) {
            io.print("Title: " + dvd.getTitle());
            io.print("Release Date: " + dvd.getReleaseDate());
            io.print("MPAA Rating: " + dvd.getMpaaRating());
            io.print("Director's Name: " + dvd.getDirectorsName());
            io.print("Studio: " + dvd.getStudio());
            io.print("Note/Additional Information: " + dvd.getNote());
            io.print("");
        } else {
            io.print("");
            io.print("No such DVD exists in library.");
            io.print("");
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayRemoveDvdBanner() {
        io.print("");
        io.print("===== Remove DVD =====");
    }

    public void displayRemoveSuccessBanner() {
        io.readString("DVD successfully removed. Please hit enter to continue.");
    }

    public void displayRemoveSuccessFailure() {
        io.readString("No such DVD exists. Please hit enter to continue.");
    }

    public String getDvdTitleSearch() {
        return io.readString("Please enter the DVD title to search for.");
    }

    public void displaySearchDvdBanner() {
        io.print("");
        io.print("===== Search Results =====");
    }
    
    public String displayDvdSearchSuccess() {
        return io.readString("Please hit enter to continue.");
    }

    public String displayDvdSearchNoResults() {
        return io.readString("No such DVD exists in the DVD Library. Please hit enter to continue.");
    }

    public void displayEditDvdBanner() {
        io.print("");
        io.print("===== Edit DVD =====");
    }

    public String displayEditDvd(Dvd dvd) {
        if (dvd != null) {
            io.print("Title: " + dvd.getTitle());
            io.print("Release Date: " + dvd.getReleaseDate());
            io.print("MPAA Rating: " + dvd.getMpaaRating());
            io.print("Director's Name: " + dvd.getDirectorsName());
            io.print("Studio: " + dvd.getStudio());
            io.print("Note/Additional Information: " + dvd.getNote());
            io.print("");
        } else {
            io.print("No such DVD");
            io.print("");
        }
        return io.readString("Please hit enter to continue.");
    }

    public Dvd editDvdInfo(Dvd dvd) {
        String dvdTitle = io.readString("Please enter DVD title");
        while (dvdTitle.equals("")) {
            dvdTitle = io.readString("Please enter a DVD title.");
        }
        String releaseDate = io.readString("Please enter the DVD release date");
        String mpaaRating = io.readString("Please enter the MPAA rating");
        String directorsName = io.readString("Please enter the DVD director's name");
        String studio = io.readString("Please enter the DVD studio");
        String note = io.readString("Please enter the user rating or any additional information");
        Dvd currentDvd = new Dvd(dvdTitle);
        currentDvd.setTitle(dvdTitle);
        if (releaseDate.equals("")) {
            releaseDate = "Release date not provided";
        }
        currentDvd.setReleaseDate(releaseDate);
        if (mpaaRating.equals("")) {
            mpaaRating = "MPAA rating not provided";
        }
        currentDvd.setMpaaRating(mpaaRating);
        if (directorsName.equals("")) {
            directorsName = "Director's name not provided";
        }
        currentDvd.setDirectorsName(directorsName);
        if (studio.equals("")) {
            studio = "Studio not provided";
        }
        currentDvd.setStudio(studio);
        if (note.equals("")) {
            note = "Additional info not provided";
        }
        currentDvd.setNote(note);
        return currentDvd;
    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("===== Error =====");
        io.print(errorMsg);
    }

}
