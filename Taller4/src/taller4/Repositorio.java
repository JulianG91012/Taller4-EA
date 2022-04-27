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
    public int id;
    public String repo_name;
    public String full_name;
    public String user_name;
    public String language;
    public String type;
    public Date created;
    public int forks;
    public int stars;
    public int open_issues;
    public int suscribers;
    
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
}
