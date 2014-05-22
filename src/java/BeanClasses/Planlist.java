package BeanClasses;

import DataBase.DataBaseConnector;
import DataClasses.PlanValuesFromBase;
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
public class Planlist implements Serializable{
	private List<Plan> carsSmall;
        private List<Plan> filteredCars;
        private SelectItem[] formedulist;
        private SelectItem[] okrlist;
    public List<Plan> getFilteredCars() {
        return filteredCars;
    }

    public SelectItem[] getOkrlist() {
        return okrlist;
    }

    public void setOkrlist(SelectItem[] okrlist) {
        this.okrlist = okrlist;
    }

    
    public void setFilteredCars(List<Plan> filteredCars) {
        this.filteredCars = filteredCars;
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
           List<PlanValuesFromBase> list = data.SelectPlanData(selectedCar,id);
           Car x;
           plans.clear();
           int g = 0;
           for(int i = 0;i<list.size()/53;i++){
               x = new Car(list.get(g).Course,list.get(g).Value,list.get(g+1).Value,list.get(g+2).Value,list.get(g+3).Value,list.get(g+4).Value,list.get(g+5).Value,list.get(g+6).Value,list.get(g+7).Value,list.get(g+8).Value,list.get(g+9).Value,list.get(g+10).Value,list.get(g+11).Value,list.get(g+12).Value,list.get(g+13).Value,list.get(g+14).Value,list.get(g+15).Value,list.get(g+16).Value,list.get(g+17).Value,list.get(g+18).Value,list.get(g+19).Value,list.get(g+20).Value,list.get(g+21).Value,list.get(g+22).Value,list.get(g+23).Value,list.get(g+24).Value,list.get(g+25).Value,list.get(g+26).Value,list.get(g+27).Value,list.get(g+28).Value,list.get(g+29).Value,list.get(g+30).Value,list.get(g+31).Value,list.get(g+32).Value,list.get(g+33).Value,list.get(g+34).Value,list.get(g+35).Value,list.get(g+36).Value,list.get(g+37).Value,list.get(g+38).Value,list.get(g+39).Value,list.get(g+40).Value,list.get(g+41).Value,list.get(g+42).Value,list.get(g+43).Value,list.get(g+44).Value,list.get(g+45).Value,list.get(g+46).Value,list.get(g+47).Value,list.get(g+48).Value,list.get(g+49).Value,list.get(g+50).Value,list.get(g+51).Value,list.get(g+52).Value);
           plans.add(x);
           g=g+53;
           }
           
        }
        
        public void deleteplan(){
            if(selectedCar!=null){
                try{
                data.Query("Delete from plan where idplan = "+selectedCar.getIdplan());
                carsSmall = data.ListPlans(id);
                }catch(Exception e){}
            }
        }
        
        public String insertData(){
            carsSmall.clear();
            carsSmall = data.ListPlans(id);
             return "planList.xhtml";
        }

    public SelectItem[] getFormedulist() {
        return formedulist;
    }

    public void setFormedulist(SelectItem[] formedulist) {
        this.formedulist = formedulist;
    }
        
	public Planlist() throws ClassNotFoundException, SQLException {
		carsSmall = new ArrayList<Plan>();
                filteredCars = new ArrayList<Plan>();
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
              insertData();
	}
        
        public void updateData() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
            String ID = selectedCar.getIdplan();
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
        FacesContext context = FacesContext.getCurrentInstance();
              context.addMessage(null, new FacesMessage("Удачно!", "План успешно сохранен и появился в списке")); 
        }
   public int otI;

    public int getOtI() {
        return otI;
    }

    public void setOtI(int otI) {
        this.otI = otI;
    }

    public int getDoI() {
        return doI;
    }

    public void setDoI(int doI) {
        this.doI = doI;
    }
    public int doI;
    
    public String selectedSelectinSelection;

    public String getSelectedSelectinSelection() {
        return selectedSelectinSelection;
    }

    public void setSelectedSelectinSelection(String selectedSelectinSelection) {
        this.selectedSelectinSelection = selectedSelectinSelection;
    }
    public int weekDO;

    public int getWeekDO() {
        return weekDO;
    }

    public void setWeekDO(int weekDO) {
        this.weekDO = weekDO;
    }
    
    public void seArray()
    {
        if(otI<doI && weekDO!=0&&otI>0&&doI>0&&plans.size()>0&&plans.size() >= weekDO-1){
            
           Car edt = plans.get(weekDO-1);
           
            
            for(int g = otI;g<doI+1;g++){
                                                     //Андрей Александрович если вы это видите я не виноват так нужно было...                           
                switch(g){
                    case 1: edt.setWeek1(selectedSelectinSelection); break;
                    case 2: edt.setWeek2(selectedSelectinSelection); break;   
                    case 3: edt.setWeek3(selectedSelectinSelection); break;
                    case 4: edt.setWeek4(selectedSelectinSelection); break;
                    case 5: edt.setWeek5(selectedSelectinSelection); break;    
                    case 6: edt.setWeek6(selectedSelectinSelection); break;    
                    case 7: edt.setWeek7(selectedSelectinSelection); break;   
                    case 8: edt.setWeek8(selectedSelectinSelection); break;    
                    case 9: edt.setWeek9(selectedSelectinSelection); break;
                    case 10: edt.setWeek10(selectedSelectinSelection); break;   
                    case 11: edt.setWeek11(selectedSelectinSelection); break;
                    case 12: edt.setWeek12(selectedSelectinSelection); break;
                    case 13: edt.setWeek13(selectedSelectinSelection); break;    
                    case 14: edt.setWeek14(selectedSelectinSelection); break;    
                    case 15: edt.setWeek15(selectedSelectinSelection); break;   
                    case 16: edt.setWeek16(selectedSelectinSelection); break;    
                    case 17: edt.setWeek17(selectedSelectinSelection); break;
                    case 18: edt.setWeek18(selectedSelectinSelection); break;   
                    case 19: edt.setWeek19(selectedSelectinSelection); break;
                    case 20: edt.setWeek20(selectedSelectinSelection); break;
                    case 21: edt.setWeek21(selectedSelectinSelection); break;    
                    case 22: edt.setWeek22(selectedSelectinSelection); break;    
                    case 23: edt.setWeek23(selectedSelectinSelection); break;   
                    case 24: edt.setWeek24(selectedSelectinSelection); break;    
                    case 25: edt.setWeek25(selectedSelectinSelection); break;
                    case 26: edt.setWeek26(selectedSelectinSelection); break;   
                    case 27: edt.setWeek27(selectedSelectinSelection); break;
                    case 28: edt.setWeek28(selectedSelectinSelection); break;
                    case 29: edt.setWeek29(selectedSelectinSelection); break;    
                    case 30: edt.setWeek30(selectedSelectinSelection); break;    
                    case 31: edt.setWeek31(selectedSelectinSelection); break;   
                    case 32: edt.setWeek32(selectedSelectinSelection); break;    
                    case 33: edt.setWeek33(selectedSelectinSelection); break;
                    case 34: edt.setWeek34(selectedSelectinSelection); break;   
                    case 35: edt.setWeek35(selectedSelectinSelection); break;
                    case 36: edt.setWeek36(selectedSelectinSelection); break;
                    case 37: edt.setWeek37(selectedSelectinSelection); break;    
                    case 38: edt.setWeek38(selectedSelectinSelection); break;    
                    case 39: edt.setWeek39(selectedSelectinSelection); break;   
                    case 40: edt.setWeek40(selectedSelectinSelection); break;   
                    case 41: edt.setWeek41(selectedSelectinSelection); break;
                    case 42: edt.setWeek42(selectedSelectinSelection); break;   
                    case 43: edt.setWeek43(selectedSelectinSelection); break;
                    case 44: edt.setWeek44(selectedSelectinSelection); break;
                    case 45: edt.setWeek45(selectedSelectinSelection); break;    
                    case 46: edt.setWeek46(selectedSelectinSelection); break;    
                    case 47: edt.setWeek47(selectedSelectinSelection); break;   
                    case 48: edt.setWeek48(selectedSelectinSelection); break;  
                    case 49: edt.setWeek49(selectedSelectinSelection); break;
                    case 50: edt.setWeek50(selectedSelectinSelection); break;   
                    case 51: edt.setWeek51(selectedSelectinSelection); break;
                    case 52: edt.setWeek52(selectedSelectinSelection); break;
                    case 53: edt.setWeek53(selectedSelectinSelection); break;    
                    
                }
                
                
                
            }
            
            plans.set(weekDO-1, edt);
            FacesContext context = FacesContext.getCurrentInstance();
              context.addMessage(null, new FacesMessage("БАБАМ", "ТЫДЫЩъ"));  
        }else{
           FacesContext context = FacesContext.getCurrentInstance();
              context.addMessage(null, new FacesMessage("Ошибка", "Не удалось произвести подстановку"));  
        }
    }
}
                    