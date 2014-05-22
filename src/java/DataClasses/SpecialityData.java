package DataClasses;


import java.io.Serializable;
import javax.faces.bean.ManagedBean;


@ManagedBean
public class SpecialityData implements Serializable{
    public String disciple;
    public String cycle;
    public int idSpec;
    public SpecialityData(String disciple, String cycle, int idSpec) {
        this.disciple = disciple;
        this.cycle = cycle;
        this.idSpec = idSpec;
    }

    public String getDisciple() {
        return disciple;
    }

    public void setDisciple(String disciple) {
        this.disciple = disciple;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }
}
