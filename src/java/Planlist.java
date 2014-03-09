import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
@ManagedBean
@SessionScoped
public class Planlist implements Serializable{
	private List<Plan> carsSmall;
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
    public List<Car> getPlans() {
        return plans;
    }

    public void setPlans(List<Car> plans) {
        this.plans = plans;
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
        public void downloadData() throws SQLException{
           List<PlanValuesFromBase> list = data.SelectPlanData(selectedCar.getName());
           Car x;
           plans.clear();
           int g = 0;
           for(int i = 0;i<list.size()/53;i++){
               x = new Car(list.get(g).Course,list.get(g).Value,list.get(g+1).Value,list.get(g+2).Value,list.get(g+3).Value,list.get(g+4).Value,list.get(g+5).Value,list.get(g+6).Value,list.get(g+7).Value,list.get(g+8).Value,list.get(g+9).Value,list.get(g+10).Value,list.get(g+11).Value,list.get(g+12).Value,list.get(g+13).Value,list.get(g+14).Value,list.get(g+15).Value,list.get(g+16).Value,list.get(g+17).Value,list.get(g+18).Value,list.get(g+19).Value,list.get(g+20).Value,list.get(g+21).Value,list.get(g+22).Value,list.get(g+23).Value,list.get(g+24).Value,list.get(g+25).Value,list.get(g+26).Value,list.get(g+27).Value,list.get(g+28).Value,list.get(g+29).Value,list.get(g+30).Value,list.get(g+31).Value,list.get(g+32).Value,list.get(g+33).Value,list.get(g+34).Value,list.get(g+35).Value,list.get(g+36).Value,list.get(g+37).Value,list.get(g+38).Value,list.get(g+39).Value,list.get(g+40).Value,list.get(g+41).Value,list.get(g+42).Value,list.get(g+43).Value,list.get(g+44).Value,list.get(g+45).Value,list.get(g+46).Value,list.get(g+47).Value,list.get(g+48).Value,list.get(g+49).Value,list.get(g+50).Value,list.get(g+51).Value,list.get(g+52).Value);
           plans.add(x);
           g=g+53;
           }
           
        }
        public String insertData(){
            carsSmall.clear();
             List<String> a= new ArrayList<String>();
             a = data.ListPlans(id);
             for(int i = 0;i<a.size();i++)
            carsSmall.add(new Plan(a.get(i),""));
             
             return "planList?faces-redirect=true";
        }
	public Planlist() throws ClassNotFoundException, SQLException {
		carsSmall = new ArrayList<Plan>();
              insertData();
	}
        
        public void updateData() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
            int ID = data.SelectPlanID(selectedCar.getName());
        for(int i = 0; i<plans.size();i++){ 
              data.Query("Update PlanValues set value = '"+plans.get(i).getWeek1()+"' where idPlan = "+ID+" and week = "+1+" and course = "+(i+1));
              data.Query("Update PlanValues set value = '"+plans.get(i).getWeek2()+"' where idPlan = "+ID+" and week = "+2+" and course = "+(i+1));
              data.Query("Update PlanValues set value = '"+plans.get(i).getWeek3()+"' where idPlan = "+ID+" and week = "+3+" and course = "+(i+1));
              data.Query("Update PlanValues set value = '"+plans.get(i).getWeek4()+"' where idPlan = "+ID+" and week = "+4+" and course = "+(i+1));
              data.Query("Update PlanValues set value = '"+plans.get(i).getWeek5()+"' where idPlan = "+ID+" and week = "+5+" and course = "+(i+1));
              data.Query("Update PlanValues set value = '"+plans.get(i).getWeek6()+"' where idPlan = "+ID+" and week = "+6+" and course = "+(i+1));
              data.Query("Update PlanValues set value = '"+plans.get(i).getWeek7()+"' where idPlan = "+ID+" and week = "+7+" and course = "+(i+1));
              data.Query("Update PlanValues set value = '"+plans.get(i).getWeek8()+"' where idPlan = "+ID+" and week = "+8+" and course = "+(i+1));
              data.Query("Update PlanValues set value = '"+plans.get(i).getWeek9()+"' where idPlan = "+ID+" and week = "+9+" and course = "+(i+1));
              data.Query("Update PlanValues set value = '"+plans.get(i).getWeek10()+"' where idPlan = "+ID+" and week = "+10+" and course = "+(i+1));
              data.Query("Update PlanValues set value = '"+plans.get(i).getWeek11()+"' where idPlan = "+ID+" and week = "+11+" and course = "+(i+1));
              data.Query("Update PlanValues set value = '"+plans.get(i).getWeek12()+"' where idPlan = "+ID+" and week = "+12+" and course = "+(i+1));
              data.Query("Update PlanValues set value = '"+plans.get(i).getWeek13()+"' where idPlan = "+ID+" and week = "+13+" and course = "+(i+1));
              data.Query("Update PlanValues set value = '"+plans.get(i).getWeek14()+"' where idPlan = "+ID+" and week = "+14+" and course = "+(i+1));
              data.Query("Update PlanValues set value = '"+plans.get(i).getWeek15()+"' where idPlan = "+ID+" and week = "+15+" and course = "+(i+1));
              data.Query("Update PlanValues set value = '"+plans.get(i).getWeek16()+"' where idPlan = "+ID+" and week = "+16+" and course = "+(i+1));
              data.Query("Update PlanValues set value = '"+plans.get(i).getWeek17()+"' where idPlan = "+ID+" and week = "+17+" and course = "+(i+1));
              data.Query("Update PlanValues set value = '"+plans.get(i).getWeek18()+"' where idPlan = "+ID+" and week = "+18+" and course = "+(i+1));
              data.Query("Update PlanValues set value = '"+plans.get(i).getWeek19()+"' where idPlan = "+ID+" and week = "+19+" and course = "+(i+1));
              data.Query("Update PlanValues set value = '"+plans.get(i).getWeek20()+"' where idPlan = "+ID+" and week = "+20+" and course = "+(i+1));
              data.Query("Update PlanValues set value = '"+plans.get(i).getWeek21()+"' where idPlan = "+ID+" and week = "+21+" and course = "+(i+1));
              data.Query("Update PlanValues set value = '"+plans.get(i).getWeek22()+"' where idPlan = "+ID+" and week = "+22+" and course = "+(i+1));
              data.Query("Update PlanValues set value = '"+plans.get(i).getWeek23()+"' where idPlan = "+ID+" and week = "+23+" and course = "+(i+1));
              data.Query("Update PlanValues set value = '"+plans.get(i).getWeek24()+"' where idPlan = "+ID+" and week = "+24+" and course = "+(i+1));
              data.Query("Update PlanValues set value = '"+plans.get(i).getWeek25()+"' where idPlan = "+ID+" and week = "+25+" and course = "+(i+1));
              data.Query("Update PlanValues set value = '"+plans.get(i).getWeek26()+"' where idPlan = "+ID+" and week = "+26+" and course = "+(i+1));
              data.Query("Update PlanValues set value = '"+plans.get(i).getWeek27()+"' where idPlan = "+ID+" and week = "+27+" and course = "+(i+1));
              data.Query("Update PlanValues set value = '"+plans.get(i).getWeek28()+"' where idPlan = "+ID+" and week = "+28+" and course = "+(i+1));
              data.Query("Update PlanValues set value = '"+plans.get(i).getWeek29()+"' where idPlan = "+ID+" and week = "+29+" and course = "+(i+1));
              data.Query("Update PlanValues set value = '"+plans.get(i).getWeek30()+"' where idPlan = "+ID+" and week = "+30+" and course = "+(i+1));
              data.Query("Update PlanValues set value = '"+plans.get(i).getWeek31()+"' where idPlan = "+ID+" and week = "+31+" and course = "+(i+1));
              data.Query("Update PlanValues set value = '"+plans.get(i).getWeek32()+"' where idPlan = "+ID+" and week = "+32+" and course = "+(i+1));
              data.Query("Update PlanValues set value = '"+plans.get(i).getWeek33()+"' where idPlan = "+ID+" and week = "+33+" and course = "+(i+1));
              data.Query("Update PlanValues set value = '"+plans.get(i).getWeek34()+"' where idPlan = "+ID+" and week = "+34+" and course = "+(i+1));
              data.Query("Update PlanValues set value = '"+plans.get(i).getWeek35()+"' where idPlan = "+ID+" and week = "+35+" and course = "+(i+1));
              data.Query("Update PlanValues set value = '"+plans.get(i).getWeek36()+"' where idPlan = "+ID+" and week = "+36+" and course = "+(i+1));
              data.Query("Update PlanValues set value = '"+plans.get(i).getWeek37()+"' where idPlan = "+ID+" and week = "+37+" and course = "+(i+1));
              data.Query("Update PlanValues set value = '"+plans.get(i).getWeek38()+"' where idPlan = "+ID+" and week = "+38+" and course = "+(i+1));
              data.Query("Update PlanValues set value = '"+plans.get(i).getWeek39()+"' where idPlan = "+ID+" and week = "+39+" and course = "+(i+1));
              data.Query("Update PlanValues set value = '"+plans.get(i).getWeek40()+"' where idPlan = "+ID+" and week = "+40+" and course = "+(i+1));
              data.Query("Update PlanValues set value = '"+plans.get(i).getWeek41()+"' where idPlan = "+ID+" and week = "+41+" and course = "+(i+1));
              data.Query("Update PlanValues set value = '"+plans.get(i).getWeek42()+"' where idPlan = "+ID+" and week = "+42+" and course = "+(i+1));
              data.Query("Update PlanValues set value = '"+plans.get(i).getWeek43()+"' where idPlan = "+ID+" and week = "+43+" and course = "+(i+1));
              data.Query("Update PlanValues set value = '"+plans.get(i).getWeek44()+"' where idPlan = "+ID+" and week = "+44+" and course = "+(i+1));
              data.Query("Update PlanValues set value = '"+plans.get(i).getWeek45()+"' where idPlan = "+ID+" and week = "+45+" and course = "+(i+1));
              data.Query("Update PlanValues set value = '"+plans.get(i).getWeek46()+"' where idPlan = "+ID+" and week = "+46+" and course = "+(i+1));
              data.Query("Update PlanValues set value = '"+plans.get(i).getWeek47()+"' where idPlan = "+ID+" and week = "+47+" and course = "+(i+1));
              data.Query("Update PlanValues set value = '"+plans.get(i).getWeek48()+"' where idPlan = "+ID+" and week = "+48+" and course = "+(i+1));
              data.Query("Update PlanValues set value = '"+plans.get(i).getWeek49()+"' where idPlan = "+ID+" and week = "+49+" and course = "+(i+1));
              data.Query("Update PlanValues set value = '"+plans.get(i).getWeek50()+"' where idPlan = "+ID+" and week = "+50+" and course = "+(i+1));
              data.Query("Update PlanValues set value = '"+plans.get(i).getWeek51()+"' where idPlan = "+ID+" and week = "+51+" and course = "+(i+1));
              data.Query("Update PlanValues set value = '"+plans.get(i).getWeek52()+"' where idPlan = "+ID+" and week = "+52+" and course = "+(i+1));
              data.Query("Update PlanValues set value = '"+plans.get(i).getWeek53()+"' where idPlan = "+ID+" and week = "+53+" and course = "+(i+1));
        }
        }
 
}
                    