/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sk.dvdlibraryfinal.dao;

/**
 *
 * @author SHIVALI
 */

    //This is the error class for our application.It extends Exception
    
   public class DvdLibraryDaoException  extends Exception {

    public DvdLibraryDaoException(String message) {
        super(message);
    }

    public DvdLibraryDaoException(String message, Throwable cause) {
        super(message, cause);
    }
    
   }


