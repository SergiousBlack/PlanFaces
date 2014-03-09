
import java.io.Serializable;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "planitem")
public class Plan implements Serializable {
        
                private String name;
                private String date;

    public Plan(String name, String date) {
        this.name = name;
        this.date = date;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    
}
