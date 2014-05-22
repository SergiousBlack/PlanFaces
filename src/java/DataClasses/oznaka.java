package DataClasses;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class oznaka {
    
    public String idOz;
    public String fullname;
    public String shortname;

    public String getIdOz() {
        return idOz;
    }

    public void setIdOz(String idOz) {
        this.idOz = idOz;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public oznaka(String idOz, String fullname, String shortname) {
        this.idOz = idOz;
        this.fullname = fullname;
        this.shortname = shortname;
    }
    
    
}
