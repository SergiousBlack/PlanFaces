package BeanClasses;


import DataBase.DataBaseConnector;
import DataClasses.StudyPlan;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class StudyNewPlanBean implements Serializable{
    DataBaseConnector data;
    public static int k = 0;
    public String cycleNow;
    public boolean seen;

    public boolean isSeen() {
        return seen;
    }

    public void setSeen(boolean seen) {
        this.seen = seen;
    }
    public String seePlan(){
        return null;
    }
    public String getCycleNow() {
        return cycleNow;
    }

    public void setCycleNow(String cycleNow) {
        this.cycleNow = cycleNow;
    }
    public void addLine(){
        if(plan.size() == 0){
            typesDisciple = data.getListDnameDic(id);
        }
        k++;
        plan.add(new StudyPlan(String.valueOf(k)));
    }
    public String initializeForm(){
        plan.clear();
        k=0;
        cycleNow = tableBean.getSelectedCycle();
        return "StudyNewPlan.xhtml?faces-redirect=true";
    
    }
    public StudyNewPlanBean() throws ClassNotFoundException, SQLException {
        this.data = new DataBaseConnector();   
    }
    public String savePlan(){
       
        if(plan.size()>0){
            try{
             String test  = "Insert Into studyplanlist (date,okr,eduform,napr,spec,specialization,userid,cycleid) Values ('" + tableBean.date + "','" + tableBean.getOKR() + "','" + tableBean.getEduForm() + "','" + tableBean.getNapr() + "','" + tableBean.getSpec() + "','" + tableBean.getSpecialization() + "'," + id + ", "+data.getInformationAboutIdCycleByname(cycleNow, id)+") ";
             data.Query(test); 
             int k = data.getMaxSizeS();
            
        for(int i = 0;i<plan.size();i++){
            String ass = "Insert Into planstud (oop,nnd,eczam,zal,proj,work,cred,vzagal,alll,lection,lab,pract,sr,s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,planid,notinplan) "
                    + " values ('"+plan.get(i).OOP+"','"+plan.get(i).disciple+"','"+plan.get(i).SEkzam+"','"+plan.get(i).SZal+"','"+plan.get(i).SKProj+"','"+plan.get(i).SKWork+"','"+plan.get(i).Credits+"','"+plan.get(i).Vzagali+"','"+plan.get(i).All+"','"+plan.get(i).Lecture+"','"+plan.get(i).Laborary+"','"+plan.get(i).Practic+"','"+plan.get(i).SR+""
                    + "','"+plan.get(i).g1+"','"+plan.get(i).g2+"','"+plan.get(i).g3+"','"+plan.get(i).g4+"','"+plan.get(i).g5+"','"+plan.get(i).g6+"','"+plan.get(i).g7+"','"+plan.get(i).g8+"','"+plan.get(i).g9+"','"+plan.get(i).g10+"',"+k+","+plan.get(i).isInplan()+")";
            data.Query(ass);
        }
                 FacesContext context = FacesContext.getCurrentInstance();
              context.addMessage(null, new FacesMessage("Удачно!", "План успешно сохранен и появился в списке")); 
            return "";
            }catch(Exception e){ return "";}
        }else{
        return "";
        }
        
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
    
    public void setAdmin(LoginAdmin messageBean) {
        this.admin = messageBean;
        id = Integer.toString(messageBean.getAdminid());
	}
   @ManagedProperty(value="#{tableBean}")          
    public TableBean tableBean;
    
    public void setTableBean(TableBean messageBean) {
        this.tableBean = messageBean;
    
	}
    public List<StudyPlan> plan = new ArrayList<StudyPlan>();

    public List<StudyPlan> getPlan() {
        return plan;
    }

    public void setPlan(List<StudyPlan> plan) {
        this.plan = plan;
    }
  private  List<String> typesDisciple;

    public  List<String> getTypesDisciple() {
        return typesDisciple;
    }

    public  void setTypesDisciple(List<String> typesDisciple) {
        this.typesDisciple = typesDisciple;
    }
}
