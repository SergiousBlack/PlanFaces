package BeanClasses;


import DataBase.DataBaseConnector;
import DataClasses.Car;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class TableBean implements Serializable {
    private boolean isSelect;

    public boolean isIsSelect() {
        return isSelect;
    }

    public void setIsSelect(boolean isSelect) {
        this.isSelect = isSelect;
    }
    private String eduForm;
    private String gzdata;
    private String OKR;
    private String napr;
    private String spec;
    private String specialization;
    private String id;
    private String selectedCycle;
    private List<String> cycle = new ArrayList<String>();
   
    public String getId() {
        return id;
    }

    public String getSelectedCycle() {
        return selectedCycle;
    }

    public void setSelectedCycle(String selectedCycle) {
        this.selectedCycle = selectedCycle;
    }

    public List<String> getCycle() {
        return cycle;
    }

    public void setCycle(List<String> Cycle) {
        this.cycle = Cycle;
    }

    public void setId(String id) {
        this.id = id;
    }
    @ManagedProperty(value = "#{logAdmin}")
    public LoginAdmin admin;

    public void setAdmin(LoginAdmin messageBean) {
        this.admin = messageBean;
        id = Integer.toString(messageBean.getAdminid());
    }

    public String getDate() {
        return date;
    }

    public String logout() throws SQLException {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        session.invalidate();
        return "login?faces-redirect=true";
    }

    public void setDate(String date) {
        this.date = date;
    }
    public String date;
    private List<String> specializationList = new ArrayList<String>();

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public List<String> getSpecializationList() {
        return specializationList;
    }

    public void setSpecializationList(List<String> specializationList) {
        this.specializationList = specializationList;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public List<String> getSpecList() {
        return specList;
    }

    public void setSpecList(List<String> specList) {
        this.specList = specList;
    }

    public String getGzdata() {
        return gzdata;
    }

    public void setGzdata(String gzdata) {
        this.gzdata = gzdata;
    }

    private List<String> naprav = new ArrayList<String>();
    private List<String> specList = new ArrayList<String>();

    public List<String> getNaprav() {
        return naprav;
    }

    public void setNaprav(List<String> naprav) {
        this.naprav = naprav;
    }
    private List<String> eduForms = new ArrayList<String>();
    private List<String> galuzData = new ArrayList<String>();
    private List<String> okr = new ArrayList<String>();

    public String getOKR() {
        return OKR;
    }

    public List<String> getEduForms() {
        return eduForms;
    }

    public void setEduForms(List<String> eduForms) {
        this.eduForms = eduForms;
    }

    public List<String> getGaluzData() {
        return galuzData;
    }

    public void setGaluzData(List<String> galuzData) {
        this.galuzData = galuzData;
    }

    public String getNapr() {
        return napr;
    }

    public void setNapr(String napr) {
        this.napr = napr;
    }

    public void updateGaluz() throws SQLException {
        galuzData = conn.getGZ();
        
    }

    public void updateOKR() throws SQLException {
        okr = conn.getOKR();
    }

    public void updateSpecialization() throws SQLException {
        specializationList = conn.getSpecializationList(spec);
    }

    public void update() throws SQLException {
        if (OKR.equals("Бакалавр")) {
            specList.clear();
            specializationList.clear();
            naprav = conn.getNaprav(gzdata);
        } else {
            naprav.clear();
            specializationList.clear();
            specList = conn.getSpeciality(OKR, gzdata);
        }
    }

    public void setOKR(String OKR) {
        this.OKR = OKR;
    }

    public List<String> getOkr() {
        return okr;
    }

    public void setOkr(List<String> okr) {
        this.okr = okr;
    }

    public String getEduForm() {
        return eduForm;
    }

    public void setEduForm(String eduForm) {
        this.eduForm = eduForm;
    }

    private final static String[] years;

    public static String[] getYears() {
        return years;
    }

    static {
        years = new String[7];
        years[0] = "Первый";
        years[1] = "Второй";
        years[2] = "Третий";
        years[3] = "Четвертый";
        years[4] = "Пятый";
        years[5] = "Шестой";
        years[6] = "Седьмой";
    }
    public  List<String> types;

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }
    public static List<Car> pl = new ArrayList<Car>();
    public static List<Car> plans = new ArrayList<Car>();

    DataBaseConnector conn;
    public static int i = 0;

    public TableBean() throws ClassNotFoundException, SQLException {
        this.conn = new DataBaseConnector();
        types = conn.getListLegendic();
        eduForms.add("Дистанційна");
        eduForms.add("Денна");
        eduForms.add("Заочна");
    }

    public void addyear() {
        if (i <= 6) {
            plans.add(new Car(years[i], "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""));
            i++;
        }
    }

    public void deleteyear() {
        plans.clear();
        i = 0;
    }

    public List<Car> getPlans() {
        return plans;
    }

    public void clearPannels() {
        types = conn.getListLegendic();
        eduForms.clear();
        selectedCycle = "";
        galuzData.clear();
        naprav.clear();
        cycle = conn.getCycle(id);
        okr.clear();
        specList.clear();
        specializationList.clear();
        eduForms.add("Дистанційна");
        eduForms.add("Денна");
        eduForms.add("Заочна");
    }

    public void clear() {
        types = conn.getListLegendic();
        plans.clear();
        i = 0;
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

    public void saveToBase() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
    
        conn.Query("Insert Into Plan (date,okr,eduform,napr,spec,specialization,userid) Values ('" + date + "','" + OKR + "','" + eduForm + "','" + napr + "','" + spec + "','" + specialization + "'," + id + ") ");
        int ID = conn.getMaxSize();
        for (int i = 0; i < plans.size(); i++) {
            conn.Query("Insert Into PlanValues (course,week,value,idPlan) values (" + (i + 1) + "," + 1 + ", '" + plans.get(i).getWeek1() + "' ," + ID + ")");
            conn.Query("Insert Into PlanValues (course,week,value,idPlan) values (" + (i + 1) + "," + 2 + ", '" + plans.get(i).getWeek2() + "' ," + ID + ")");
            conn.Query("Insert Into PlanValues (course,week,value,idPlan) values (" + (i + 1) + "," + 3 + ", '" + plans.get(i).getWeek3() + "' ," + ID + ")");
            conn.Query("Insert Into PlanValues (course,week,value,idPlan) values (" + (i + 1) + "," + 4 + ", '" + plans.get(i).getWeek4() + "' ," + ID + ")");
            conn.Query("Insert Into PlanValues (course,week,value,idPlan) values (" + (i + 1) + "," + 5 + ", '" + plans.get(i).getWeek5() + "' ," + ID + ")");
            conn.Query("Insert Into PlanValues (course,week,value,idPlan) values (" + (i + 1) + "," + 6 + ", '" + plans.get(i).getWeek6() + "' ," + ID + ")");
            conn.Query("Insert Into PlanValues (course,week,value,idPlan) values (" + (i + 1) + "," + 7 + ", '" + plans.get(i).getWeek7() + "' ," + ID + ")");
            conn.Query("Insert Into PlanValues (course,week,value,idPlan) values (" + (i + 1) + "," + 8 + ", '" + plans.get(i).getWeek8() + "' ," + ID + ")");
            conn.Query("Insert Into PlanValues (course,week,value,idPlan) values (" + (i + 1) + "," + 9 + ", '" + plans.get(i).getWeek9() + "' ," + ID + ")");
            conn.Query("Insert Into PlanValues (course,week,value,idPlan) values (" + (i + 1) + "," + 10 + ", '" + plans.get(i).getWeek10() + "' ," + ID + ")");
            conn.Query("Insert Into PlanValues (course,week,value,idPlan) values (" + (i + 1) + "," + 11 + ", '" + plans.get(i).getWeek11() + "' ," + ID + ")");
            conn.Query("Insert Into PlanValues (course,week,value,idPlan) values (" + (i + 1) + "," + 12 + ", '" + plans.get(i).getWeek12() + "' ," + ID + ")");
            conn.Query("Insert Into PlanValues (course,week,value,idPlan) values (" + (i + 1) + "," + 13 + ", '" + plans.get(i).getWeek13() + "' ," + ID + ")");
            conn.Query("Insert Into PlanValues (course,week,value,idPlan) values (" + (i + 1) + "," + 14 + ", '" + plans.get(i).getWeek14() + "' ," + ID + ")");
            conn.Query("Insert Into PlanValues (course,week,value,idPlan) values (" + (i + 1) + "," + 15 + ", '" + plans.get(i).getWeek15() + "' ," + ID + ")");
            conn.Query("Insert Into PlanValues (course,week,value,idPlan) values (" + (i + 1) + "," + 16 + ", '" + plans.get(i).getWeek16() + "' ," + ID + ")");
            conn.Query("Insert Into PlanValues (course,week,value,idPlan) values (" + (i + 1) + "," + 17 + ", '" + plans.get(i).getWeek17() + "' ," + ID + ")");
            conn.Query("Insert Into PlanValues (course,week,value,idPlan) values (" + (i + 1) + "," + 18 + ", '" + plans.get(i).getWeek18() + "' ," + ID + ")");
            conn.Query("Insert Into PlanValues (course,week,value,idPlan) values (" + (i + 1) + "," + 19 + ", '" + plans.get(i).getWeek19() + "' ," + ID + ")");
            conn.Query("Insert Into PlanValues (course,week,value,idPlan) values (" + (i + 1) + "," + 20 + ", '" + plans.get(i).getWeek20() + "' ," + ID + ")");
            conn.Query("Insert Into PlanValues (course,week,value,idPlan) values (" + (i + 1) + "," + 21 + ", '" + plans.get(i).getWeek21() + "' ," + ID + ")");
            conn.Query("Insert Into PlanValues (course,week,value,idPlan) values (" + (i + 1) + "," + 22 + ", '" + plans.get(i).getWeek22() + "' ," + ID + ")");
            conn.Query("Insert Into PlanValues (course,week,value,idPlan) values (" + (i + 1) + "," + 23 + ", '" + plans.get(i).getWeek23() + "' ," + ID + ")");
            conn.Query("Insert Into PlanValues (course,week,value,idPlan) values (" + (i + 1) + "," + 24 + ", '" + plans.get(i).getWeek24() + "' ," + ID + ")");
            conn.Query("Insert Into PlanValues (course,week,value,idPlan) values (" + (i + 1) + "," + 25 + ", '" + plans.get(i).getWeek25() + "' ," + ID + ")");
            conn.Query("Insert Into PlanValues (course,week,value,idPlan) values (" + (i + 1) + "," + 26 + ", '" + plans.get(i).getWeek26() + "' ," + ID + ")");
            conn.Query("Insert Into PlanValues (course,week,value,idPlan) values (" + (i + 1) + "," + 27 + ", '" + plans.get(i).getWeek27() + "' ," + ID + ")");
            conn.Query("Insert Into PlanValues (course,week,value,idPlan) values (" + (i + 1) + "," + 28 + ", '" + plans.get(i).getWeek28() + "' ," + ID + ")");
            conn.Query("Insert Into PlanValues (course,week,value,idPlan) values (" + (i + 1) + "," + 29 + ", '" + plans.get(i).getWeek29() + "' ," + ID + ")");
            conn.Query("Insert Into PlanValues (course,week,value,idPlan) values (" + (i + 1) + "," + 30 + ", '" + plans.get(i).getWeek30() + "' ," + ID + ")");
            conn.Query("Insert Into PlanValues (course,week,value,idPlan) values (" + (i + 1) + "," + 31 + ", '" + plans.get(i).getWeek31() + "' ," + ID + ")");
            conn.Query("Insert Into PlanValues (course,week,value,idPlan) values (" + (i + 1) + "," + 32 + ", '" + plans.get(i).getWeek32() + "' ," + ID + ")");
            conn.Query("Insert Into PlanValues (course,week,value,idPlan) values (" + (i + 1) + "," + 33 + ", '" + plans.get(i).getWeek33() + "' ," + ID + ")");
            conn.Query("Insert Into PlanValues (course,week,value,idPlan) values (" + (i + 1) + "," + 34 + ", '" + plans.get(i).getWeek34() + "' ," + ID + ")");
            conn.Query("Insert Into PlanValues (course,week,value,idPlan) values (" + (i + 1) + "," + 35 + ", '" + plans.get(i).getWeek35() + "' ," + ID + ")");
            conn.Query("Insert Into PlanValues (course,week,value,idPlan) values (" + (i + 1) + "," + 36 + ", '" + plans.get(i).getWeek36() + "' ," + ID + ")");
            conn.Query("Insert Into PlanValues (course,week,value,idPlan) values (" + (i + 1) + "," + 37 + ", '" + plans.get(i).getWeek37() + "' ," + ID + ")");
            conn.Query("Insert Into PlanValues (course,week,value,idPlan) values (" + (i + 1) + "," + 38 + ", '" + plans.get(i).getWeek38() + "' ," + ID + ")");
            conn.Query("Insert Into PlanValues (course,week,value,idPlan) values (" + (i + 1) + "," + 39 + ", '" + plans.get(i).getWeek39() + "' ," + ID + ")");
            conn.Query("Insert Into PlanValues (course,week,value,idPlan) values (" + (i + 1) + "," + 40 + ", '" + plans.get(i).getWeek40() + "' ," + ID + ")");
            conn.Query("Insert Into PlanValues (course,week,value,idPlan) values (" + (i + 1) + "," + 41 + ", '" + plans.get(i).getWeek41() + "' ," + ID + ")");
            conn.Query("Insert Into PlanValues (course,week,value,idPlan) values (" + (i + 1) + "," + 42 + ", '" + plans.get(i).getWeek42() + "' ," + ID + ")");
            conn.Query("Insert Into PlanValues (course,week,value,idPlan) values (" + (i + 1) + "," + 43 + ", '" + plans.get(i).getWeek43() + "' ," + ID + ")");
            conn.Query("Insert Into PlanValues (course,week,value,idPlan) values (" + (i + 1) + "," + 44 + ", '" + plans.get(i).getWeek44() + "' ," + ID + ")");
            conn.Query("Insert Into PlanValues (course,week,value,idPlan) values (" + (i + 1) + "," + 45 + ", '" + plans.get(i).getWeek45() + "' ," + ID + ")");
            conn.Query("Insert Into PlanValues (course,week,value,idPlan) values (" + (i + 1) + "," + 46 + ", '" + plans.get(i).getWeek46() + "' ," + ID + ")");
            conn.Query("Insert Into PlanValues (course,week,value,idPlan) values (" + (i + 1) + "," + 47 + ", '" + plans.get(i).getWeek47() + "' ," + ID + ")");
            conn.Query("Insert Into PlanValues (course,week,value,idPlan) values (" + (i + 1) + "," + 48 + ", '" + plans.get(i).getWeek48() + "' ," + ID + ")");
            conn.Query("Insert Into PlanValues (course,week,value,idPlan) values (" + (i + 1) + "," + 49 + ", '" + plans.get(i).getWeek49() + "' ," + ID + ")");
            conn.Query("Insert Into PlanValues (course,week,value,idPlan) values (" + (i + 1) + "," + 50 + ", '" + plans.get(i).getWeek50() + "' ," + ID + ")");
            conn.Query("Insert Into PlanValues (course,week,value,idPlan) values (" + (i + 1) + "," + 51 + ", '" + plans.get(i).getWeek51() + "' ," + ID + ")");
            conn.Query("Insert Into PlanValues (course,week,value,idPlan) values (" + (i + 1) + "," + 52 + ", '" + plans.get(i).getWeek52() + "' ," + ID + ")");
            conn.Query("Insert Into PlanValues (course,week,value,idPlan) values (" + (i + 1) + "," + 53 + ", '" + plans.get(i).getWeek53() + "' ," + ID + ")");
        }
        FacesContext context = FacesContext.getCurrentInstance();
              context.addMessage(null, new FacesMessage("Удачно!", "План успешно сохранен и появился в списке")); 
              eduForm="";
    }
}
