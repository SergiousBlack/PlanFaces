import java.io.Serializable;
import java.util.Map;


import javax.faces.context.FacesContext;


public class GuestPerreference implements Serializable {


        private String theme = "south-street"; //default


        public String getTheme() {
                Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
                if(params.containsKey("theme")) {
                        theme = params.get("theme");
                }
                
                return theme;
        }


        public void setTheme(String theme) {
                this.theme = theme;
        }
}