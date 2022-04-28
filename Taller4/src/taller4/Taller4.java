/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller4;
/**
 *
 * @author Julian Gómez Jojo y el gey
 */
import edu.princeton.cs.algs4.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.text.DateFormat;
import java.text.ParseException;

public class Taller4 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws Exception
    {
        boolean cont = false; //Continuidad del ciclo
        Scanner scn = new Scanner(System.in); //Lectura de teclado
        ST<String, Bag<Repositorio>> st =  new ST<String, Bag<Repositorio>>(); //Tabla de simbolos
        ST<String, Bag<Repositorio>> st_lenguaje =  new ST<String, Bag<Repositorio>>(); //Tabla de simbolos
        BST<String, MinPQ<Repositorio>> bst = new BST<String, MinPQ<Repositorio>>();

        Bag<Repositorio> bag = new Bag<Repositorio>(); //Bolsa de repositorios
        
        //Llenado del arraylist de repositorios
        StdOut.println("Ingrese la ruta del archivo: " );
        String res = scn.nextLine();
        ArrayList<Repositorio> repos = LeerDataset(res);
        
        // crear una tabla de simbolos con key = user name y value = bag con los repositorios de cada usuario
        for(Repositorio re: repos){
        Bag<Repositorio> aux = new Bag<Repositorio>(); //bolsa auxiliar, se crea vacía
         if(st.contains(re.user_name)){
                st.get(re.user_name).add(re); //si el usuario ya existe en la tabla, solo añade re a la bolsa
                //st.put(re.user_name, st.get(re.user_name);
            }else{
            aux.add(re);
            st.put(re.user_name,aux); //crea una fila en la tabla con re 
            }
                  // C:\\Users\\JaegerJK\\Documents\\GitHub\\Taller4-EA\\github-dataset-fixed.txt
        }
        
        for(Repositorio re: repos){
        Bag<Repositorio> auxiliar = new Bag<Repositorio>(); //bolsa auxiliar, se crea vacía
         if(st_lenguaje.contains(re.language)){
                st_lenguaje.get(re.language).add(re); //si el usuario ya existe en la tabla, solo añade re a la bolsa
                //st.put(re.user_name, st.get(re.user_name);
            }else{
            auxiliar.add(re);
            st_lenguaje.put(re.language,auxiliar); //crea una fila en la tabla con re 
            }
                  // C:\\Users\\JaegerJK\\Documents\\GitHub\\Taller4-EA\\github-dataset-fixed.txt
        }
        
        
        consultaPorUsuario(st);
        
        bst = rankingsPorLenguaje(st_lenguaje);
        //String usuarioAnterior, nuevoUsuario;
        //Llenado de la bolsa de los usuarios
        //usuarioAnterior = repos.get(0).user_name;
        /*
        for(int i = 0; i<repos.size(); i++){
            if(!repos.get(i).user_name.equals(usuarioAnterior)){
                nuevoUsuario = repos.get(i).user_name;
                for(int j=0; j<repos.size(); j++){
                    if(repos.get(j).user_name.equals(res)){
                    bag.add(repos.get(i));
                    }
                }
            }
        }
        */
        //StdOut.println("Ingrese el nombre del usuario: " );
        //res = scn.nextLine();
           
    }
    static void consultaPorUsuario(ST<String, Bag<Repositorio>> st){
        int nro_rep;
        int nro_estrellas;
        int nro_suscripciones; 
        int open_issues;
        ST<String, Integer> aux = new ST<String, Integer>();
        for (String user_name : st.keys()){
            nro_rep = 0;
            nro_estrellas = 0;
            nro_suscripciones = 0; 
            open_issues = 0; 
            for (Repositorio rep : st.get(user_name)){
                nro_rep++;
                nro_estrellas =+ rep.stars;
                nro_suscripciones =+ rep.suscribers;
                open_issues =+ rep.open_issues;
            }
            StdOut.println("El usuario " + user_name + " tiene: ");
            StdOut.println("Repositorios: " + nro_rep);
            StdOut.println("Un total de estrellas de: " + nro_estrellas);
            StdOut.println("Un total de suscriptores: " + nro_suscripciones);
            StdOut.println("Un promedio de " + (open_issues/nro_rep) + " de open issues");
            StdOut.println("");
        }
    
    }
    
    public static ArrayList<Repositorio> LeerDataset(String ruta) throws ParseException, IOException{
        
        ArrayList <Repositorio> repositorios = new ArrayList<>(); //Luego hay que ponerlo en funcion
        
        //Se lee el archivo y se llena el array list
        
        String Datos[] = new String[10]; //Datos del archivo
        File doc = new File(ruta); //Archivo a leer
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //Formato de la fecha
        BufferedReader obj = new BufferedReader(new FileReader(doc)); //Se carga el archivo
        String linea; //Linea a leer del archivo
        String[] last = new String[1]; //Arreglo del ultimo caracter
        Date fecha; //Fecha Parseada

        //Ciclo de lectura del archivo
        while ((linea = obj.readLine()) != null){

            Datos = linea.split(",");//Separacion de datos
            last = Datos[10].split(" "); //Arreglo del ultimo espacio
            Datos[10] = last[0]; //Asignacion del nuevo dato final
            fecha = formatoFecha.parse(Datos[6]); //Asignacion de la fecha

            //Creacion del repositorio
            Repositorio x = new Repositorio(Integer.parseInt(Datos[0]),Datos[1],Datos[2],Datos[3]
                    ,Datos[4],Datos[5],fecha,Integer.parseInt(Datos[7])
                    ,Integer.parseInt(Datos[8]),Integer.parseInt(Datos[9]),Integer.parseInt(Datos[10]));

            //Añadidura del repositorio
            repositorios.add(x);

        }
        
        System.out.println(repositorios.get(0));
        return repositorios;
        
        
    }

    public static BST<String, MinPQ<Repositorio>> rankingsPorLenguaje(ST<String,Bag<Repositorio>> repoXlenguaje){
        BST<String, MinPQ<Repositorio>> bst = new BST<String, MinPQ<Repositorio>>();
        int M = 10;
        for(String lenguaje : repoXlenguaje.keys()){
        MinPQ<Repositorio> aux = new MinPQ<>();
        for(Repositorio rep : repoXlenguaje.get(lenguaje)){
            aux.insert(rep); 
            if(aux.size() > M){ aux.delMin();}
            }
        bst.put(lenguaje, aux);            
        }
        return bst; 
    }
}