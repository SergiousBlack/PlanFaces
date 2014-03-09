
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
public class TableBean implements Serializable {

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
    private static List<String> types;

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
        types = conn.getList();
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
        eduForms.clear();
        galuzData.clear();
        naprav.clear();
        cycle = conn.getCycle(id);
        okr.clear();
        specList.clear();
        specializationList.clear();
        //eduForms.add(" ");
        eduForms.add("Дистанційна");
        eduForms.add("Денна");
        eduForms.add("Заочна");
    }

    public void Clear() {
        plans.clear();
        i = 0;
    }
    
    
    
    

    public void saveToBase() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        String Text = date + "_" + OKR + "_" + eduForm + "_" + napr + "_" + spec + "_" + specialization;
        conn.Query("Insert Into Plan (text,userid) Values ('" + Text + "'," + id + ") ");
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
    }
}
