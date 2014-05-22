package BeanClasses;


import DataBase.DataBaseConnector;
import DataClasses.typeDic;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class CycleDicBean implements Serializable{
    DataBaseConnector data;
    public typeDic Selected;
    public String add;
 private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    @ManagedProperty(value="#{logAdmin}")          
    public LoginAdmin admin;
    
    public void setAdmin(LoginAdmin messageBean) {
        this.admin = messageBean;
        id = Integer.toString(messageBean.getAdminid());
	}
    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }
    
    public typeDic getSelected() {
        return Selected;
    }

    public void setSelected(typeDic Selected) {
        this.Selected = Selected;
    }
    public String edit;
    public void postEdit() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
       int ids = data.SelectedTypeDicID(Selected.name);
            data.Query("Update dsubtypedic SET name = '"+edit+"' where code = "+ids+" and iduser = "+id);
             list = data.getTypeDicListS(id);
    }
   public void deleteCycle(){
       try{
           String name = Selected.name; 
       data.Query("Delete From dsubtypedic where name = '"+Selected.name+"' and iduser = "+id);
       list = data.getTypeDicListS(id);
       }catch(Exception e){
       
       }
   }
   public void postAdd() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
  
         data.Query("Insert Into dsubtypedic (name,iduser) Values ('"+add+"', "+id+")");
        list = data.getTypeDicListS(id);
       
   }
    public void editCycle(){
        edit = Selected.name;
    }
    public String getEdit() {
        return edit;
    }

    public void setEdit(String edit) {
        this.edit = edit;
    }
    
    List<typeDic> list  = new ArrayList<typeDic>();

    public List<typeDic> getList() {
        return list;
    }

    public void setList(List<typeDic> list) {
        this.list = list;
    }

   public String download()
   {
        list = data.getTypeDicListS(id);
        return "CycleDic?faces-redirect=true";
   }
    
  public CycleDicBean() throws ClassNotFoundException, SQLException{
      data  = new DataBaseConnector();
      
    }
    
    
    
}

