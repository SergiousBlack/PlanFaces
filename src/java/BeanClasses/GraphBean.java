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
        for(int i = 0; i < mainList.size(); i++){
            
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

    public void save(){
        
        String save = "";
        
    }
}
