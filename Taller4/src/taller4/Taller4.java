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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Taller4 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws Exception
    {
        ArrayList <Repositorio> repositorios = new ArrayList<>();
        boolean cont = false; //Continuidad del ciclo
        Scanner scn = new Scanner(System.in);
        
        do{
            StdOut.println("Ingrese la ruta del archivo: " );
            String res = scn.nextLine();
            String objeto[] = new String[10];
            File doc = new File(res);
            SimpleDateFormat formato1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            BufferedReader obj = new BufferedReader(new FileReader(doc));
            String strng;
            while ((strng = obj.readLine()) != null)
                objeto = strng.split(",");
                int id = Integer.parseInt(objeto[0]);
                int forks = Integer.parseInt(objeto[7]);
                int stars = Integer.parseInt(objeto[8]);
                int open_issues = Integer.parseInt(objeto[9]);
                int suscribers = Integer.parseInt(objeto[10]);

                Repositorio x = new Repositorio(id,objeto[1],objeto[2],objeto[3],objeto[4],objeto[5],formato1.parse(objeto[6]),forks,stars,open_issues,suscribers);
                
                
                repositorios.add(x);

        }while(cont);
        
        System.out.println(repositorios.get(0));
        
    }
    
}
