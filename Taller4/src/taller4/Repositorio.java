/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller4;

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
            String type, Date created , int stars, int open_issues, int suscribers)
    {
        this.id = id;
        this.repo_name = repo_name;
        this.full_name = full_name;
        this.user_name = user_name;
        this.language = language;
        this.type = type;
        this.created = created 
        this.forks = forks;
        this.stars = stars;
        this.open_issues = open_issues;
        this.suscribers = suscribers;
    }
            
    
}
