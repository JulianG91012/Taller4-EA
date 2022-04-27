/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller4;

import java.util.ArrayList;
import java.util.Date;


/**
 *
 * @author Julian Gómez
 */
public class Repositorio
{
    private int id;
    private String repo_name;
    private String full_name;
    private String user_name;
    private String language;
    private String type;
    private Date created;
    private int forks;
    private int stars;
    private int open_issues;
    private int suscribers;
    
    //Agregar el tipo de dato fecha
    public Repositorio(int id, String repo_name, String full_name, String user_name, String language, 
            String type, Date created, int forks, int stars, int open_issues, int suscribers)
    {
        this.id = id;
        this.repo_name = repo_name;
        this.full_name = full_name;
        this.user_name = user_name;
        this.language = language;
        this.type = type;
        this.created = created; 
        this.forks = forks;
        this.stars = stars;
        this.open_issues = open_issues;
        this.suscribers = suscribers;
    }
    
    public ArrayList<Repositorio> leerDataset(String ruta){
        
        ArrayList <Repositorio> repositorios = new ArrayList<>(); //Luego hay que ponerlo en funcion
        boolean cont = false; //Continuidad del ciclo
        Scanner scn = new Scanner(System.in); //Lectura de teclado
        //Se lee el archivo y se llena el array list
        do{
            StdOut.println("Ingrese la ruta del archivo: " );
            String res = scn.nextLine();
            String Datos[] = new String[10]; //Datos del archivo
            File doc = new File(res); //Archivo a leer
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
        }while(cont);
        
        System.out.println(repositorios.get(0));
    }
            
    
}
