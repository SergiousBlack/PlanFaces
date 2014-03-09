
import java.io.Serializable;
import javax.faces.bean.ManagedBean;


@ManagedBean
public class SpecialityData implements Serializable{
    public String disciple;
    public String cycle;

    public SpecialityData(String disciple, String cycle) {
        this.disciple = disciple;
        this.cycle = cycle;
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
