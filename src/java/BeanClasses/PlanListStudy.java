package BeanClasses;


import DataBase.DataBaseConnector;
import DataClasses.StudyPlan;
import DataClasses.Car;
import DataClasses.Plan;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

@ManagedBean
@SessionScoped
public class PlanListStudy implements Serializable{
    private List<Plan> carsSmall = new ArrayList<Plan>();
    public List<StudyPlan> plan = new ArrayList<StudyPlan>();
    private SelectItem[] formedulist;
        private SelectItem[] okrlist;

    public PlanListStudy() {
        //-----------------------------------------
                formedulist = new SelectItem[4];
                formedulist[0] = new SelectItem("","Усі");
                formedulist[1] = new SelectItem("Денна","Денна");
                formedulist[2] = new SelectItem("Заочна","Заочна");
                formedulist[3] = new SelectItem("Дистанційна","Дистанційна");
                //-----------------------------------------
                okrlist = new SelectItem[4];
                okrlist[0] = new SelectItem("","Усі");
                okrlist[1] = new SelectItem("Бакалавр","Бакалавр");
                okrlist[2] = new SelectItem("Спеціаліст","Спеціаліст");
                okrlist[3] = new SelectItem("Магістр","Магістр");
                //-----------------------------------------
              
    }
        public List<StudyPlan> getPlan() {
        return plan;
    }
 public void deletePlan(){
      if(selectedCar!=null){
          try{
          data.Query("Delete from studyplanlist where idplan = "+selectedCar.getIdplan());
          carsSmall.clear();
             carsSmall = data.ListPlansStudy(id);
          }catch(Exception e){}
      }
 }
    public SelectItem[] getFormedulist() {
        return formedulist;
    }

    public void setFormedulist(SelectItem[] formedulist) {
        this.formedulist = formedulist;
    }

    public SelectItem[] getOkrlist() {
        return okrlist;
    }

    public void setOkrlist(SelectItem[] okrlist) {
        this.okrlist = okrlist;
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
    public String seePlan() throws SQLException{
        typesDisciple = data.getListDnameDic(id);
        plan = data.SelectStudyPlanData(selectedCar,id);
        return "SeeStudyPlan.xhtml?faces-redirect=true";
    }
    public void addLine(){ plan.add(new StudyPlan(String.valueOf(plan.size()+1), "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",false));}
    public void savePlan(){
    try{
        for(StudyPlan gogo : plan){
   //       data.Query("Update planstud set oop = "+gogo.OOP+", nnd ='"+gogo.disciple+"' , eczam='"+gogo.SEkzam+"',zal='"+gogo.SZal+"',proj='"+gogo.SKProj+"',work='"+gogo.SKWork+"',cred='"+gogo.Credits+"',vzagal='"+gogo.Vzagali+"',alll='"+gogo.All+"',lection='"+gogo.Lecture+"',lab='"+gogo.Laborary+"',pract='"+gogo.Practic+"',sr='"+gogo.SR+"',s1='"+gogo.g1+"',s2='"+gogo.g2+"',s3='"+gogo.g3+"',s4='"+gogo.g4+"',s5='"+gogo.g5+"',s6='"+gogo.g6+"',s7='"+gogo.g7+"',s8='"+gogo.g8+"',s9='"+gogo.g9+"',s10='"+gogo.g10+"' where planid = "+data.GetIDStudyPlanList(selectedCar.getName(), id)+" and idplan = "+gogo.idplan+"");
        }
    FacesContext context = FacesContext.getCurrentInstance();
              context.addMessage(null, new FacesMessage("Удачно!", "План успешно сохранен и появился в списке")); 
    }catch(Exception e){}
    }
    public List<Plan> getCarsSmall() {
        return carsSmall;
    }

    public void setCarsSmall(List<Plan> carsSmall) {
        this.carsSmall = carsSmall;
    }

    public Plan getSelectedCar() {
        return selectedCar;
    }

    public void setSelectedCar(Plan selectedCar) {
        this.selectedCar = selectedCar;
    }
        public DataBaseConnector data = new DataBaseConnector();
	private Plan selectedCar;
        public  List<Car> plans = new ArrayList<Car>();
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
    public String downloadPlans(){
             carsSmall.clear();
             carsSmall = data.ListPlansStudy(id);
             return "StudyPlanList.xhtml";
    }
    
    
}
