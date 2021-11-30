/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sk.dvdlibraryfinal.dao;

import com.sk.dvdlibraryfinal.dto.Dvd;
import java.util.List;

/**
 *
 * @author SHIVALI
 */
public interface DvdLibraryDao {

    List<Dvd> getAllDvds() throws DvdLibraryDaoException;

    Dvd addDvd(String dvdTitle, Dvd dvd) throws DvdLibraryDaoException;// add given DVD to the list and associate it with the given title 

    Dvd removeDvd(String dvdTitle) throws DvdLibraryDaoException;

    Dvd getDvd(String dvdTitle) throws DvdLibraryDaoException;

}
