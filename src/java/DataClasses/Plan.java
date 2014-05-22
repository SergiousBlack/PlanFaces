package DataClasses;


import java.io.Serializable;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "planitem")
public class Plan implements Serializable {
        
                private String idplan;
                private String OKR;

    public Plan(String idplan, String OKR, String eduform, String cycle, String napr, String spec, String specialization, String date) {
        this.idplan = idplan;
        this.OKR = OKR;
        this.eduform = eduform;
        this.cycle = cycle;
        this.napr = napr;
        this.spec = spec;
        this.specialization = specialization;
        this.date = date;
    }
                private String eduform;
                private String cycle;

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }
                
    public Plan(String idplan, String OKR, String eduform, String napr, String spec, String specialization, String date) {
        this.idplan = idplan;
        this.OKR = OKR;
        this.eduform = eduform;
        this.napr = napr;
        this.spec = spec;
        this.specialization = specialization;
        this.date = date;
    }

    public String getIdplan() {
        return idplan;
    }

    public void setIdplan(String idplan) {
        this.idplan = idplan;
    }

    public String getOKR() {
        return OKR;
    }

    public void setOKR(String OKR) {
        this.OKR = OKR;
    }

    public String getEduform() {
        return eduform;
    }

    public void setEduform(String eduform) {
        this.eduform = eduform;
    }

    public String getNapr() {
        return napr;
    }

    public void setNapr(String napr) {
        this.napr = napr;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
                private String napr;
                private String spec;
                private String specialization;
                private String date;


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    
}
