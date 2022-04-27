/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller4;
/**
 *
 * @author Julian Gómez Jojo y el gey
 */
import edu.princeton.cs.algs4.StdOut;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.text.DateFormat;

public class Taller4 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws Exception
    {
        ArrayList <Repositorio> repositorios = new ArrayList<>();
        boolean cont = false; //Continuidad del ciclo
        Scanner scn = new Scanner(System.in);
        //Se lee el archivo y se llena el array list
        do{
            StdOut.println("Ingrese la ruta del archivo: " );
            String res = scn.nextLine();
            //
            String objeto[] = new String[10];
            File doc = new File(res);
            SimpleDateFormat formato1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            BufferedReader obj = new BufferedReader(new FileReader(doc));
            String strng;
            String[] last = new String[1];
            Date fecha; 
            while ((strng = obj.readLine()) != null){
                objeto = strng.split(",");
                last = objeto[10].split(" ");
                objeto[10] = last[0];
                fecha = formato1.parse(objeto[6]);
                Repositorio x = new Repositorio(Integer.parseInt(objeto[0]),objeto[1],objeto[2],objeto[3]
                        ,objeto[4],objeto[5],fecha,Integer.parseInt(objeto[7])
                        ,Integer.parseInt(objeto[8]),Integer.parseInt(objeto[9]),Integer.parseInt(objeto[10]));
                
                
                repositorios.add(x);

        }
        }while(cont);
        
        System.out.println(repositorios.get(0));
        
    }
    
        
}
