/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sk.dvdlibraryfinal.dao;

import com.sk.dvdlibraryfinal.dto.Dvd;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SHIVALI
 */
public class DvdLibraryDaoFileImpl implements DvdLibraryDao {

    public static final String DVDLIBRARY_FILE = "DVDlibrary.txt";
    public static final String DELIMITER = "::";

    private Map<String, Dvd> dvds = new HashMap<>();

    @Override
    public List<Dvd> getAllDvds() throws DvdLibraryDaoException {
        loadLibrary();
        return new ArrayList<Dvd>(dvds.values()); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Dvd addDvd(String dvdTitle, Dvd dvd) throws DvdLibraryDaoException {

        loadLibrary();
        Dvd newDvd = dvds.put(dvdTitle, dvd);
        writeLibrary();

        return newDvd;
//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Dvd removeDvd(String dvdTitle) throws DvdLibraryDaoException {
        loadLibrary();
        Dvd removedDvd = dvds.remove(dvdTitle);
        writeLibrary();
        
        return removedDvd;//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Dvd getDvd(String dvdTitle) throws DvdLibraryDaoException {
        loadLibrary();

        return dvds.get(dvdTitle); //To change body of generated methods, choose Tools | Templates.
    }
    //This is text file specific implementation of the DvdLibraryDao interface

    private void loadLibrary() throws DvdLibraryDaoException {
        Scanner scanner;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(new BufferedReader(new FileReader(DVDLIBRARY_FILE)));
        } catch (FileNotFoundException e) {
            throw new DvdLibraryDaoException("!!! Could not load library data into memory !!!", e);
        }

        // currentLine holds the most recent line read from the file
        String currentLine;

        String[] currentTokens;

        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // break up the line into tokens
            currentTokens = currentLine.split(DELIMITER);

            Dvd currentDvd = new Dvd(currentTokens[0]);

            currentDvd.setReleaseDate(currentTokens[1]);
            currentDvd.setMpaaRating(currentTokens[2]);
            currentDvd.setStudio(currentTokens[3]);
            currentDvd.setDirectorsName((currentTokens[4]));
            currentDvd.setViewerNotes(currentTokens[5]);

            dvds.put(currentDvd.getTitle(), currentDvd);
        }
        // close scanner
        scanner.close();
    }

    private void writeLibrary() throws DvdLibraryDaoException {

        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(DVDLIBRARY_FILE));
        } catch (IOException e) {
            throw new DvdLibraryDaoException("Could not save dvd data.", e);
        }

        List<Dvd> dvdList = this.getAllDvds();
        for (Dvd currentDvd : dvdList) {

            out.println(currentDvd.getTitle() + DELIMITER
                    + currentDvd.getReleaseDate() + DELIMITER
                    + currentDvd.getMpaaRating() + DELIMITER
                    + currentDvd.getStudio() + DELIMITER
                    + currentDvd.getDirectorsName() + DELIMITER
                    + currentDvd.getViewerNotes());
            // force PrintWriter to write line to the file
            out.flush();
        }
        // Clean up
        out.close();
    }
}
