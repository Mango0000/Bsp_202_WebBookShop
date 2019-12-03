/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojos;

/**
 *
 * @author manue
 */
public class Author {
    private String firstname;
    private String lastname;
    private String url;

    public Author(String firstname, String lastname, String url) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.url = url;
    }
    
    public String getAuth(){
        return firstname + " " + lastname;
    }
    
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    
}
