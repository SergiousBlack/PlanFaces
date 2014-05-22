package BeanClasses;


import DataClasses.oznaka;
import DataBase.DataBaseConnector;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class oznak {

    public List<oznaka> mainList = new ArrayList<oznaka>();

    public oznaka selected;
    public String shortoz;
    public String edtS;
    public String edtL;
    public String longoz;
    public DataBaseConnector data = new DataBaseConnector();

    public String getEdtS() {
        return edtS;
    }

    public void setEdtS(String edtS) {
        this.edtS = edtS;
    }

    public String getEdtL() {
        return edtL;
    }

    public void setEdtL(String edtL) {
        this.edtL = edtL;
    }

    public String getShortoz() {
        return shortoz;
    }

    public void setShortoz(String Short) {
        this.shortoz = Short;
    }

    public String getLongoz() {
        return longoz;
    }

    public void setLongoz(String Long) {
        this.longoz = Long;
    }

    public List<oznaka> getMainList() {
        return mainList;
    }

    public oznak() {
        mainList = data.getAlloznak();
    }

    public void setMainList(List<oznaka> mainList) {
        this.mainList = mainList;
    }

    public oznaka getSelected() {
        return selected;
    }

    public void setSelected(oznaka selected) {
        this.selected = selected;
    }

    public void deleteoz() {
        try {
            if (selected != null) {
                data.Query("Delete From legendic where code = " + selected.idOz);
                 mainList = data.getAlloznak();
            }
        } catch (Exception e) {
        }
    }

    public void addOZ() {
        try {
            if (longoz != "" && shortoz != "") {
                data.Query("Insert Into legendic (name,note) values ('" + shortoz + "','" + longoz + "')");
                mainList = data.getAlloznak();
            }
        } catch (Exception e) {
        }
    }
    public void edit(){
        this.edtL = selected.fullname;
        this.edtS = selected.shortname;
    }
   public void edtOZ(){
       if(longoz!=""&&shortoz!=""){
           try{
               
               data.Query("Update legendic set name = '"+edtS+"' , note = '"+edtL+"' where code = "+selected.idOz);
               mainList = data.getAlloznak();
               
           }catch(Exception e){}
       }
   }
    public void clearPannel() {
        longoz = "";
        shortoz = "";
    }

    public String enjoy() {
        mainList = data.getAlloznak();
        return "OznakList.xhtml?faces-redirect=true;";
    }

}
