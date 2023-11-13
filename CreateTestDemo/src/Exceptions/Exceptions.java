/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exceptions;

import Process.HomeCommandLine;
import java.io.IOException;


/**
 *
 * @author ahmedshuman
 */
public class Exceptions {
   
     public static void handleException(IOException ex) {
           java.util.logging.Logger.getLogger(HomeCommandLine.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
  
   
}
