/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller4;
/**
 *
 * @author Julian Gómez
 */
import edu.princeton.cs.algs4.StdOut;
import java.io.*;
import java.util.Scanner;

public class Taller4 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws Exception
    {
        boolean cont = false; //Continuidad del ciclo
        Scanner scn = new Scanner(System.in);
        
        do{
        StdOut.println("Ingrese la ruta del archivo: " );
        String res = scn.nextLine();
        
        File doc = new File(res);

            BufferedReader obj = new BufferedReader(new FileReader(doc));
            String strng;
            while ((strng = obj.readLine()) != null)
              System.out.println("\n" + strng);
            
        }while(cont);
        
        
        
    }
    
}
