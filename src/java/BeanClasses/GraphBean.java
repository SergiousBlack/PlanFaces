/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BeanClasses;

import DataBase.DataBaseConnector;
import DataClasses.GraphValue;
import DataClasses.newGraph;
import java.io.Serializable;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.primefaces.event.CellEditEvent;

/**
 *
 * @author Black
 */
@ManagedBean
@SessionScoped
public class GraphBean  implements Serializable{
    DataBaseConnector data =new DataBaseConnector();
    public List<newGraph> mainList = new ArrayList<newGraph>();
    public List<String> coursesList = new ArrayList<String>();
    public List<String> SemestersList = new ArrayList<String>();
    public List<String> reductionList = new ArrayList<String>();
   
    public List<String> getReductionList() {
        return reductionList;
    }

    public void setReductionList(List<String> reductionList) {
        this.reductionList = reductionList;
    }
    

    public List<String> getSemestersList() {
        return SemestersList;
    }

    public void setSemestersList(List<String> SemestersList) {
        this.SemestersList = SemestersList;
    }
    
    public List<String> getCoursesList() {
        return coursesList;
    }

    public void setCoursesList(List<String> coursesList) {
        this.coursesList = coursesList;
    }
    public String test;
    public boolean DayOrNight;
    
    public GraphBean(){
    coursesList.clear();
    coursesList.add("");
    coursesList.add("1");
    coursesList.add("2");
    coursesList.add("3");
    coursesList.add("4");
    coursesList.add("5");
    SemestersList.clear();
    SemestersList.add("");
    SemestersList.add("Весінній");
    SemestersList.add("Осінній");
    reductionList = data.getListLegendic();
    
    }
    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

   
    public void addyear(){
        mainList.add(new newGraph("", "",null,null, new GraphValue(null, null, "", 0,DayOrNight),new GraphValue(null, null, "", 0,DayOrNight),new GraphValue(null, null, "", 0,DayOrNight),new GraphValue(null, null, "", 0,DayOrNight),new GraphValue(null, null, "", 0,DayOrNight),new GraphValue(null, null, "", 0,DayOrNight),new GraphValue(null, null, "", 0,DayOrNight),new GraphValue(null, null, "", 0,DayOrNight),new GraphValue(null, null, "", 0,DayOrNight),new GraphValue(null, null, "", 0,DayOrNight)));
    }

    public List<newGraph> getMainList() {
        return mainList;
    }

    public void setMainList(List<newGraph> mainList) {
        this.mainList = mainList;
    }
    
    public void deleteYear(){
    mainList.clear();
    }
    
    public String nGraph(){
        mainList.clear();
        return "newGraph?faces-redirect=true";
    }
    
    
    public void tableCellEdit(CellEditEvent e){
       for(int i = 0;i<mainList.size();i++){
           
          mainList.get(i).end = mainList.get(i).start;
          
          if( mainList.get(i).value1.end!=null && mainList.get(i).value1.end.getTime() > mainList.get(i).end.getTime()){
              mainList.get(i).end = mainList.get(i).value1.end;
          }
          if( mainList.get(i).value2.end!=null && mainList.get(i).value2.end.getTime() > mainList.get(i).end.getTime()){
              mainList.get(i).end = mainList.get(i).value2.end;
          } 
          if(mainList.get(i).value3.end!=null && mainList.get(i).value3.end.getTime() > mainList.get(i).end.getTime()){
              mainList.get(i).end = mainList.get(i).value3.end;
          } 
          if(mainList.get(i).value4.end!=null&&mainList.get(i).value4.end.getTime() > mainList.get(i).end.getTime()){
              mainList.get(i).end = mainList.get(i).value4.end;
          } 
          if(mainList.get(i).value5.end!=null && mainList.get(i).value5.end.getTime() > mainList.get(i).end.getTime()){
              mainList.get(i).end = mainList.get(i).value5.end;
          } 
          if(mainList.get(i).value6.end!=null &&mainList.get(i).value6.end.getTime() > mainList.get(i).end.getTime()){
              mainList.get(i).end = mainList.get(i).value6.end;
          } 
          if(mainList.get(i).value7.end!=null &&mainList.get(i).value7.end.getTime() > mainList.get(i).end.getTime()){
              mainList.get(i).end = mainList.get(i).value7.end;
          } 
          if(mainList.get(i).value8.end!=null &&mainList.get(i).value8.end.getTime() > mainList.get(i).end.getTime()){
              mainList.get(i).end = mainList.get(i).value8.end;
          } 
          if(mainList.get(i).value9.end!=null &&mainList.get(i).value9.end.getTime() > mainList.get(i).end.getTime()){
              mainList.get(i).end = mainList.get(i).value9.end;
          } 
          if(mainList.get(i).value10.end!=null &&mainList.get(i).value10.end.getTime() > mainList.get(i).end.getTime()){
              mainList.get(i).end = mainList.get(i).value10.end;
          } 
          
       }
     
    }
    
    
     @ManagedProperty(value = "#{tableBean}")
    public TableBean admin;

    public void setAdmin(TableBean messageBean) {
        this.admin = messageBean;
        if(admin.getEduForm().equals("Денна")){
            DayOrNight = false;
        }else{
            DayOrNight = true;
        }
    }

    public String save() throws ClassNotFoundException, InstantiationException, SQLException, IllegalAccessException{
         data.Query("Insert Into Plan (date,okr,eduform,napr,spec,specialization,userid) Values ('" + admin.date + "','" + admin.getOKR() + "','" + admin.getEduForm() + "','" + admin.getNapr() + "','" + admin.getSpec() + "','" + admin.getSpecialization() + "'," + admin.getId() + ")");
         int ID = data.getMaxSize();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
         for(int i = 0;i<mainList.size();i++){
             String sql = "Insert Into NewGraphValues (course,semestr,startd,endd,idgraph) values ('"+mainList.get(i).course+"','"+mainList.get(i).semestr+"','"+dateFormat.format(mainList.get(i).start)+"','"+dateFormat.format(mainList.get(i).end)+"',"+ID+")  ";
             data.Query(sql);
             int idValue = data.getMaxSizeGraphValues();
            int walk = 0;
             if(mainList.get(i).value1.end!=null){
                 if(mainList.get(i).value1.dayWalker){
                     walk = 1;
                 }else{
                     walk = 0;
                 }
                 data.Query("Insert Into NewGraphValuesByPoints (startd,endd,count,dayWalker,idvalue,type) values ('"+dateFormat.format(mainList.get(i).value1.start)+"','"+dateFormat.format(mainList.get(i).value1.end)+"',"+mainList.get(i).value1.count+","+walk+","+idValue+",'"+mainList.get(i).value1.type+"') ");
             }
             if(mainList.get(i).value2.end!=null){
                  if(mainList.get(i).value2.dayWalker){
                     walk = 1;
                 }else{
                     walk = 0;
                 }
                 data.Query("Insert Into NewGraphValuesByPoints (startd,endd,count,dayWalker,idvalue,type) values ('"+dateFormat.format(mainList.get(i).value2.start)+"','"+dateFormat.format(mainList.get(i).value2.end)+"',"+mainList.get(i).value2.count+","+walk+","+idValue+",'"+mainList.get(i).value2.type+"') ");
             }
             if(mainList.get(i).value3.end!=null){
                  if(mainList.get(i).value3.dayWalker){
                     walk = 1;
                 }else{
                     walk = 0;
                 }
                 data.Query("Insert Into NewGraphValuesByPoints (startd,endd,count,dayWalker,idvalue,type) values ('"+dateFormat.format(mainList.get(i).value3.start)+"','"+dateFormat.format(mainList.get(i).value3.end)+"',"+mainList.get(i).value3.count+","+walk+","+idValue+",'"+mainList.get(i).value3.type+"') ");
             }
             if(mainList.get(i).value4.end!=null){
                  if(mainList.get(i).value4.dayWalker){
                     walk = 1;
                 }else{
                     walk = 0;
                 }
                 data.Query("Insert Into NewGraphValuesByPoints (startd,endd,count,dayWalker,idvalue,type) values ('"+dateFormat.format(mainList.get(i).value4.start)+"','"+dateFormat.format(mainList.get(i).value4.end)+"',"+mainList.get(i).value4.count+","+walk+","+idValue+",'"+mainList.get(i).value4.type+"') ");
             }
             if(mainList.get(i).value5.end!=null){
                  if(mainList.get(i).value5.dayWalker){
                     walk = 1;
                 }else{
                     walk = 0;
                 }
                 data.Query("Insert Into NewGraphValuesByPoints (startd,endd,count,dayWalker,idvalue,type) values ('"+dateFormat.format(mainList.get(i).value5.start)+"','"+dateFormat.format(mainList.get(i).value5.end)+"',"+mainList.get(i).value5.count+","+walk+","+idValue+",'"+mainList.get(i).value5.type+"') ");
             }
             if(mainList.get(i).value6.end!=null){
                  if(mainList.get(i).value6.dayWalker){
                     walk = 1;
                 }else{
                     walk = 0;
                 }
                 data.Query("Insert Into NewGraphValuesByPoints (startd,endd,count,dayWalker,idvalue,type) values ('"+dateFormat.format(mainList.get(i).value6.start)+"','"+dateFormat.format(mainList.get(i).value6.end)+"',"+mainList.get(i).value6.count+","+walk+","+idValue+",'"+mainList.get(i).value6.type+"') ");
             }
             if(mainList.get(i).value7.end!=null){
                  if(mainList.get(i).value7.dayWalker){
                     walk = 1;
                 }else{
                     walk = 0;
                 }
                 data.Query("Insert Into NewGraphValuesByPoints (startd,endd,count,dayWalker,idvalue,type) values ('"+dateFormat.format(mainList.get(i).value7.start)+"','"+dateFormat.format(mainList.get(i).value7.end)+"',"+mainList.get(i).value7.count+","+walk+","+idValue+",'"+mainList.get(i).value7.type+"') ");
             }
             if(mainList.get(i).value8.end!=null){
                  if(mainList.get(i).value8.dayWalker){
                     walk = 1;
                 }else{
                     walk = 0;
                 }
                 data.Query("Insert Into NewGraphValuesByPoints (startd,endd,count,dayWalker,idvalue,type) values ('"+dateFormat.format(mainList.get(i).value8.start)+"','"+dateFormat.format(mainList.get(i).value8.end)+"',"+mainList.get(i).value8.count+","+walk+","+idValue+",'"+mainList.get(i).value8.type+"') ");
             }
             if(mainList.get(i).value9.end!=null){
                  if(mainList.get(i).value9.dayWalker){
                     walk = 1;
                 }else{
                     walk = 0;
                 }
                 data.Query("Insert Into NewGraphValuesByPoints (startd,endd,count,dayWalker,idvalue,type) values ('"+dateFormat.format(mainList.get(i).value9.start)+"','"+dateFormat.format(mainList.get(i).value9.end)+"',"+mainList.get(i).value9.count+","+walk+","+idValue+",'"+mainList.get(i).value9.type+"') ");
             }
             if(mainList.get(i).value10.end!=null){
                  if(mainList.get(i).value10.dayWalker){
                     walk = 1;
                 }else{
                     walk = 0;
                 }
                data.Query("Insert Into NewGraphValuesByPoints (startd,endd,count,dayWalker,idvalue,type) values ('"+dateFormat.format(mainList.get(i).value10.start)+"','"+dateFormat.format(mainList.get(i).value10.end)+"',"+mainList.get(i).value10.count+","+walk+","+idValue+",'"+mainList.get(i).value10.type+"') "); 
             }
             
         }
        
         return "index.xhtml?faces-redirect=true;";
    }
}
