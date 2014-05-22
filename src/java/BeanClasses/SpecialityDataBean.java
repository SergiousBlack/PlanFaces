package BeanClasses;


import DataBase.DataBaseConnector;
import DataClasses.SpecialityData;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
@ManagedBean
@SessionScoped
public class SpecialityDataBean implements Serializable {
    DataBaseConnector data;
    public  SpecialityData[] select;
    public String addNewDisciple;
    public String updNewDisciple;
    public String selectCycle;
    public String cycleUPD;

    public String getCycleUPD() {
        return cycleUPD;
    }

    public void setCycleUPD(String cycleUPD) {
        this.cycleUPD = cycleUPD;
    }
    public String getSelectCycle() {
        return selectCycle;
    }

    public void setSelectCycle(String selectCycle) {
        this.selectCycle = selectCycle;
    }
    public String getUpdNewDisciple() {
        return updNewDisciple;
    }

    public void setUpdNewDisciple(String updNewDisciple) {
        this.updNewDisciple = updNewDisciple;
    }
    public String getAddNewDisciple() {
        return addNewDisciple;
    }

    public void setAddNewDisciple(String addNewDisciple) {
        this.addNewDisciple = addNewDisciple;
    }
    public SpecialityData[] getSelect() {
        return select;
    }
    
    public void setSelect(SpecialityData[] select) {
        this.select = select;
    }
     private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    @ManagedProperty(value="#{logAdmin}")          
    public LoginAdmin admin;
    
    public void deleteData() throws ClassNotFoundException, InstantiationException, SQLException, IllegalAccessException{
        
       for(SpecialityData sel:select)
       {
        data.Query("Delete From dnamedic where code = "+sel.idSpec);
       }
       
        String test = download();//Обновление списка это нихера не тест не удалять.
    }
    public void setAdmin(LoginAdmin messageBean) {
        this.admin = messageBean;
        id = Integer.toString(messageBean.getAdminid());
	}
    List<SpecialityData> list = new ArrayList<SpecialityData>();

    List<String> cycle = new ArrayList<String>();

    public List<String>  getCycle() {
        return cycle;
    }
   public void addSpecialityToBase(){
       if(addNewDisciple != ""){
           try {
               String k = data.getInformationAboutIdCycleByname(selectCycle,id);
               data.Query("Insert into dnamedic (name,iduser,cycleid) values ('"+addNewDisciple+"',"+id+","+k+") ");
               String test = download();//Обновление списка это нихера не тест не удалять.
              FacesContext context = FacesContext.getCurrentInstance();
              context.addMessage(null, new FacesMessage("Удачно!", "Добавлена новая дисциплина")); 
           } catch (Exception ex) {
           }
       }
   } 
   public void updSpecialityToBase(){
       //if(updNewDisciple != " "&& updNewDisciple!= null){
          try {
                String k = data.getInformationAboutIdCycleByname(cycleUPD,id);
              data.Query("Update dnamedic  set name = '"+updNewDisciple+"', cycleid = "+k+" where code = "+select[0].idSpec);
               FacesContext context = FacesContext.getCurrentInstance();
              context.addMessage(null, new FacesMessage("Удачно!", "Дисциплина обновлена"));
               String test = download();//Обновление списка это нихера не тест не удалять.
           } catch (Exception ex) {
           }
      // }else{
        
      // }
   } 
   public void clear(){
   addNewDisciple = "";
   selectCycle = "";
   }
    public void setCycle(List<String> cycle) {
        this.cycle = cycle;
    }
    
    public List<SpecialityData> getList() {
        return list;
    }
    
    public void setList(List<SpecialityData> list) {
        this.list = list;
    }
    public String download() throws SQLException{
        list = data.SelectDiscplData(id);
        cycle = data.getTypeDicList(id);
        return "SpecialityData?faces-redirect=true";
    }
    public void update(){
        if(select.length>0){
            updNewDisciple = select[0].disciple;
            cycleUPD = select[0].cycle;
        }else{
             FacesContext context = FacesContext.getCurrentInstance();
             context.addMessage(null, new FacesMessage("Fail", "Нельзя редактировать несколько дисциплин одновременно"));
        }
    }
    public SpecialityDataBean() throws ClassNotFoundException, SQLException{
        this.data = new DataBaseConnector();
    }
    public void duplicate()
    {
      
           try {
               for(SpecialityData spec:select){
               data.Query("Insert into dnamedic (name,iduser,cycleid) values ('"+spec.disciple+"',"+id+","+data.getInformationAboutIdCycleByname(spec.cycle, id)+") ");
               }
               String test = download();//Обновление списка это нихера не тест не удалять.
              FacesContext context = FacesContext.getCurrentInstance();
              context.addMessage(null, new FacesMessage("Удачно!", "Дублирование завершено")); 
           } catch (Exception ex) {
           }
      
    }
}
