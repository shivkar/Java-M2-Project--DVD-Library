/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sk.dvdlibraryfinal.ui;

import java.util.Scanner;

/**
 *
 * @author SHIVALI
 */

    // console specific implementation of the UserIO interface

public class UserIOConsoleImpl implements UserIO {

    Scanner myScanner = new Scanner(System.in);
    
    public void print(String msg){
        System.out.println(msg);   
    }    
    
    public double readDouble(String prompt){
        System.out.println(prompt);
        Double a = myScanner.nextDouble();
        return a;
    }
    
    public double readDouble(String prompt, double min, double max){
        Double a;
       
        do{
            System.out.println(prompt);

             a= Double.parseDouble(myScanner.nextLine());

            if (a > max || a< min){
                System.out.println("Your entry was not within the specified bounds."); 
            }

        }while(a > max || a< min);
         
        return a;
    }
    
    public float readFloat(String prompt){
        System.out.println(prompt);
        float a = myScanner.nextFloat();
        return a;
    }

    public float readFloat(String prompt, float min, float max){
        float a;

        do{
            System.out.println(prompt);

             a= myScanner.nextFloat();

            if (a > max || a< min){
                System.out.println("Your entry was not within the specified bounds."); 
            }

        }while(a > max || a< min);

         return a;
    }
    
    public int readInt(String prompt){
        System.out.println(prompt);
        int a = Integer.parseInt(myScanner.nextLine());
        return a;
    }

    public int readInt(String prompt, int min, int max){
        int a;

        do{
            System.out.println(prompt);

             a= Integer.parseInt(myScanner.nextLine());

            if (a > max || a< min){
                System.out.println("Your entry was not within the specified bounds."); 
            }

        }while(a > max || a< min);

         return a;
    }
    
    public long readLong(String prompt){
        System.out.println(prompt);
        long a = myScanner.nextLong();
        return a;
    }

    public long readLong(String prompt, long min, long max){
        long a;

        do{
            System.out.println(prompt);

             a= myScanner.nextLong();

            if (a > max || a< min){
                System.out.println("Your entry was not within the specified bounds."); 
            }

        }while(a > max || a< min);

         return a;
    }
    
    public String readString(String prompt){
        System.out.println(prompt);
        
        String a = myScanner.nextLine();
        return a;
    }
    
    
}
