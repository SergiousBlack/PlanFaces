package BeanClasses;


import DataBase.DataBaseConnector;
import java.io.Serializable;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "logAdmin")
@SessionScoped
public class LoginAdmin implements Serializable {

    private String login;
    private String password;
    private String fio;
    private int adminid;
     

    //-------------------------------
    public String getLogin() {
        return login;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    //-------------------------------
    public int getAdminid() {
        return adminid;
    }

    //-------------------------------
    public void setAdminid(int adminid) {
        this.adminid = adminid;
    }

    //-------------------------------
    public void setLogin(String login) {
        this.login = login;
    }

    //-------------------------------
    public String getPassword() {
        return password;
    }

    //-------------------------------
    public void setPassword(String password) {
        this.password = password;
    }

    //-------------------------------
    public String Enter() throws SQLException, ClassNotFoundException {
        DataBaseConnector conn = new DataBaseConnector();
        if((adminid=conn.login(login, password))==0){
        FacesMessage msg = new FacesMessage("Невірний логін або пароль");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return "";
        }
        return "index?faces-redirect=true";
    }
    //-------------------------------
}
