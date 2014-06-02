package DataBase;

import DataClasses.GraphValue;
import DataClasses.Plan;
import DataClasses.PlanValuesFromBase;
import DataClasses.SpecialityData;
import DataClasses.StudyPlan;
import DataClasses.newGraph;
import DataClasses.oznaka;
import DataClasses.typeDic;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class DataBaseConnector  implements Serializable{
   public  Connection conn;
   public DataBaseConnector(){
            try{ String userName = "postgres";
            String password = "";
            String url = "jdbc:postgresql://localhost:5432/NewPlan";
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection (url, userName, password); // задаём строку подключения
            }catch(Exception e){
            
            }
   }
   public int login(String login, String pass){
       try
        {
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("SELECT iduser FROM users WHERE log = '"+login+"' AND pas = '"+pass+"'"); // выполняем запрос
           while(res.next()){
              return Integer.parseInt(res.getString("iduser"));
            }
        }
        catch (Exception e)
        {
            return 0;
        }
       return 0;
   }
   public List<oznaka> getAlloznak(){
       List<oznaka> list = new ArrayList<oznaka>();
       try{
           Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("SELECT * FROM legendic"); // выполняем запрос
           while(res.next()){
              list.add(new oznaka(res.getString("code"),res.getString("note"),res.getString("name")));
            }
       }catch(Exception e){
           
       }
       return list;
   }
   public List<String> getCycle(String id){
       List<String> list = new ArrayList<String>();
       try
        {
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("SELECT name FROM dsubtypedic where iduser = "+id+" order by name"); // выполняем запрос
           while(res.next()){
              list.add(res.getString(1));
            }
        }
        catch (Exception e)
        {
            System.err.println (e.getMessage());
        }
         return list;
   }
   
   public List<String> getListDnameDic(String id){
         List<String> list = new ArrayList<String>();
       
        try
        {
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("SELECT name FROM dnamedic where iduser = "+id+" order by name"); // выполняем запрос
            list.add("");
           while(res.next()){
              list.add(res.getString(1));
            }
        }
        catch (Exception e)
        {
            System.err.println (e.getMessage());
        }
         return list;
   }
   public String getInformationAboutIdCycleByname(String name,String id){
       String s = "";
       try
        {
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("SELECT code FROM dsubtypedic where name = '"+name+"' and iduser = "+id); // выполняем запрос
          
            if(res.next()){
                   s  =     res.getString(1);
            }
        }
        catch (Exception e)
        {
            System.err.println (e.getMessage());
        }
       
       return s;
   }
    public List<typeDic> getTypeDicListS(String id){
        List<typeDic> list = new ArrayList<typeDic>();
        try
        {
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("SELECT name FROM dsubtypedic where iduser = " + id); // выполняем запрос
          list.add(new typeDic(" "));
            while(res.next()){
              list.add(new typeDic(res.getString(1)));
            }
        }
        catch (Exception e)
        {
            System.err.println (e.getMessage());
        }
         return list;
   }
   
   public List<String> getTypeDicList(String id){
        List<String> list = new ArrayList<String>();
        try
        {
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("SELECT name FROM dsubtypedic where iduser = " + id); // выполняем запрос
            list.add("");
            while(res.next()){
              list.add(res.getString(1));
            }
        }
        catch (Exception e)
        {
            System.err.println (e.getMessage());
        }
         return list;
   }
   
   public int SelectPlanID(Plan s) throws SQLException{
       int id = 0;
       Statement stat = conn.createStatement();
             ResultSet res = stat.executeQuery("SELECT idplan FROM plan where text = '"+s+"'"); // выполняем запрос
             
            if(res.next()){
               id = res.getInt(1);
            }
       
       return id;
   }
   
   public int SelectedTypeDicID(String s) throws SQLException{
       int id = 0;
       Statement stat = conn.createStatement();
             ResultSet res = stat.executeQuery("SELECT code FROM dsubtypedic where name = '"+s+"'"); // выполняем запрос
             
            if(res.next()){
               id = res.getInt(1);
            }
       
       return id;
   }
        public String SelectCycleNameByID(int ids) throws SQLException{
            String name = "";
            
            
             Statement stat = conn.createStatement();
             ResultSet res = stat.executeQuery("SELECT name FROM dsubtypedic where code = "+ids+""); // выполняем запрос
             
            if(res.next()){
               name = res.getString(1);
            }
            
            
            return name;
          
        }
        public List<PlanValuesFromBase> SelectPlanData(Plan plan,String ids) throws SQLException{
            List<PlanValuesFromBase> list = new ArrayList<PlanValuesFromBase>();
             Statement stat = conn.createStatement();
                int id = Integer.parseInt(plan.getIdplan());
             ResultSet res = stat.executeQuery("Select course,week,value from planValues where idplan = "+id+" ORDER BY  planValues.course ASC, planValues.week ASC ");
            while(res.next()){
                list.add(new PlanValuesFromBase(res.getString(2),res.getString(1),res.getString(3)));
            }
            return list;
        }
        
        public int GetIDStudyPlanList(String plan,String ids) throws SQLException{
             Statement stat = conn.createStatement();
             ResultSet res = stat.executeQuery("SELECT idplan FROM studyplanlist where name = '"+plan+"' and userid = "+ids); // выполняем запрос
             int id = 0;
            if(res.next()){
               id = res.getInt(1);
            }
            return id;
        }
        public List<StudyPlan> SelectStudyPlanData(Plan plan,String ids) throws SQLException{
            List<StudyPlan> list = new ArrayList<StudyPlan>();
             Statement stat = conn.createStatement();
             ResultSet res = stat.executeQuery("Select * from planstud where planid = "+plan.getIdplan());
            while(res.next()){
                list.add(new StudyPlan(res.getString(2),res.getInt(1),res.getString(3),res.getString(4),res.getString(5),res.getString(6),res.getString(7),res.getString(8),res.getString(9),res.getString(10),res.getString(11),res.getString(12),res.getString(13),res.getString(14),res.getString(15),res.getString(16),res.getString(17),res.getString(18),res.getString(19),res.getString(20),res.getString(21),res.getString(22),res.getString(23),res.getString(24),res.getBoolean(25)));
            }
            return list;
        }
        
         public List<SpecialityData> SelectDiscplData(String id) throws SQLException{
            List<SpecialityData> list = new ArrayList<SpecialityData>();
             Statement stat = conn.createStatement();
             ResultSet res = stat.executeQuery("Select dnamedic.code, dnamedic.name , dsubtypedic.name from dnamedic Left JOIN dsubtypedic on dsubtypedic.code = dnamedic.cycleid where dnamedic.iduser = "+id); // выполняем запрос
            while(res.next()){
                list.add(new SpecialityData(res.getString(2),res.getString(3),res.getInt(1)));
            }
            return list;
        }
           public List<Plan> ListPlansStudy(String id){
       
                List<Plan> list = new ArrayList<Plan>();
 
        try
        {
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("SELECT * FROM studyplanlist where userid =  "+id); // выполняем запрос
           while(res.next()){
              list.add(new Plan(res.getString(1),res.getString(5),res.getString(6),SelectCycleNameByID(res.getInt(3)),res.getString(7),res.getString(8),res.getString(9),res.getString(4)));
            }
        }
        catch (Exception e)
        {
            System.err.println (e.getMessage());
        }
        return list;
   }
      public List<Plan> ListPlans(String id){
       
       List<Plan> list = new ArrayList<Plan>();
 
        try
        {
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("SELECT * FROM plan where userid =  "+id); // выполняем запрос
           while(res.next()){
              list.add(new Plan(res.getString(1),res.getString(4),res.getString(5),res.getString(6),res.getString(7),res.getString(8),res.getString(2)));
            }
        }
        catch (Exception e)
        {
            System.err.println (e.getMessage());
        }
        return list;
   }
   public List<String> getListLegendic(){
       
       List<String> list = new ArrayList<String>();
 
        try
        {
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("SELECT name FROM legendic "); // выполняем запрос
            
            list.add(" ");
           while(res.next()){
              list.add(res.getString(1));
            }
        }
        catch (Exception e)
        {
            System.err.println (e.getMessage());
        }
        return list;
   }
   public List<String> getOKR(){
       List<String> list = new ArrayList<String>();
        try
        {
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("SELECT name FROM okrdic "); // выполняем запрос
           while(res.next()){
              list.add(res.getString(1));
            }
        }
        catch (Exception e)
        {
            System.err.println (e.getMessage());
        }
        return list;
   }
   public List<String> getSpecializationList(String spec) throws SQLException{
       List<String> list = new ArrayList<String>();
       int idGZ = 0;
       spec = spec.trim();
        Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("SELECT code from spdic where name like '%"+spec+"%'"); // выполняем запрос
       if(res.next()){
          idGZ = res.getInt(1);
       }
            res = stat.executeQuery("Select name from subspdic where sp = "+idGZ);
       while(res.next()){
             list.add(res.getString(1));
       }
       return list;
   }
   public List<String> getSpeciality(String OKR,String gzdic) throws SQLException{
   List<String> list = new ArrayList<String>();
   int idGZ = 0;
    gzdic = gzdic.trim();
        Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("SELECT code from gzdic where name like '%"+gzdic+"%'"); // выполняем запрос
       if(res.next()){
          idGZ = res.getInt(1);
       }
   int OKRID = 0;
      ResultSet rss = stat.executeQuery("select code from okrdic where name = '"+OKR+"'");
        if(rss.next()){
          OKRID = rss.getInt(1);
        }
       res = stat.executeQuery("select name from spdic where gz = "+idGZ+" and okr = "+OKRID+"");
       while(res.next()){
           list.add(res.getString(1));
       }
   return list;
   }
   public List<String> getNaprav(String gzdic) throws SQLException{
       List<String> list = new ArrayList<String>();
   int idGZ = 0;
    gzdic = gzdic.trim();
        Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("SELECT code from gzdic where name like '%"+gzdic+"%'"); // выполняем запрос
       if(res.next()){
          idGZ = res.getInt(1);
       }
       System.err.println(idGZ);
       res = stat.executeQuery("Select name from npdic where gz =  "+idGZ);
       while(res.next()){
              list.add(res.getString(1));
            }
       return list;
   }
   public List<String> getGZ(){
       
       List<String> list = new ArrayList<String>();
 
        try
        {
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("SELECT name from gzdic"); // выполняем запрос
            while(res.next()){
              String [] t;
              t = res.getString(1).split(" ");
              String answer = "";
              for(int i = 1;i<t.length;i++){
                  answer +=t[i]+" ";
              } 
              list.add(answer);
            }
        }
        catch (Exception e)
        {
            System.err.println (e.getMessage());
        }
        return list;
   }
   public int getMaxSize() throws SQLException, ClassNotFoundException,InstantiationException,IllegalAccessException{
       
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("SELECT * FROM  plan ORDER BY  plan.idplan DESC "); // выполняем запрос
            
            if(res.next()){
                return res.getInt(1);}
            else return 0;
   }
   
    public int getMaxSizeGraphValues() throws SQLException, ClassNotFoundException,InstantiationException,IllegalAccessException{
       
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("SELECT * FROM  NewGraphValues ORDER BY  NewGraphValues.idValue DESC "); // выполняем запрос
            if(res.next()){
                return res.getInt(1);}
            else return 0;
   }
   
   public int getMaxSizeS() throws SQLException, ClassNotFoundException,InstantiationException,IllegalAccessException{
       
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("SELECT * FROM  studyplanlist ORDER BY  studyplanlist.idplan DESC "); // выполняем запрос
            
            if(res.next()){
                return res.getInt(1);}
            else return 0;
   }
   
   public List<newGraph> getNewGraphList(String idPlan){
       List<newGraph> list = new ArrayList<newGraph>();
       try{
           
       Statement stat = conn.createStatement();
       ResultSet res = null;
       
       res = stat.executeQuery("Select * from newgraphvalues where idgraph = " + idPlan);
       
       while (res.next()){
           list.add(new newGraph(res.getInt(1), res.getString(2), res.getString(3), res.getDate(4), res.getDate(5), new GraphValue(null, null, "", 0,true), new GraphValue(null, null, "", 0,true), new GraphValue(null, null, "", 0,true), new GraphValue(null, null, "", 0,true), new GraphValue(null, null, "", 0,true), new GraphValue(null, null, "", 0,true), new GraphValue(null, null, "", 0,true), new GraphValue(null, null, "", 0,true), new GraphValue(null, null, "", 0,true), new GraphValue(null, null, "", 0,true)));
       }
       
       for(int i = 0; i<list.size();i++){
           
           res = stat.executeQuery("Select * from newgraphvaluesbypoints where idvalue = "+list.get(i).id);
           
           while(res.next()){
           
               switch(res.getInt(8)){
                   case 1: { 
                       list.get(i).value1.idGraph = res.getInt(1);
                       list.get(i).value1.start = Date.valueOf(res.getString(2));
                       list.get(i).value1.end = Date.valueOf(res.getString(3));
                       list.get(i).value1.count = res.getInt(4);
                       list.get(i).value1.dayWalker = res.getBoolean(5);
                       list.get(i).value1.type = res.getString(7);
                           break;
                   }
                   case 2: { 
                       list.get(i).value2.idGraph = res.getInt(1);
                       list.get(i).value2.start = Date.valueOf(res.getString(2));
                       list.get(i).value2.end = Date.valueOf(res.getString(3));
                       list.get(i).value2.count = res.getInt(4);
                       list.get(i).value2.dayWalker = res.getBoolean(5);
                       list.get(i).value2.type = res.getString(7);
                           break;
                   }
                   case 3: { 
                       list.get(i).value3.idGraph = res.getInt(1);
                       list.get(i).value3.start = Date.valueOf(res.getString(2));
                       list.get(i).value3.end = Date.valueOf(res.getString(3));
                       list.get(i).value3.count = res.getInt(4);
                       list.get(i).value3.dayWalker = res.getBoolean(5);
                       list.get(i).value3.type = res.getString(7);
                           break;
                   }
                   case 4: { 
                       list.get(i).value4.idGraph = res.getInt(1);
                       list.get(i).value4.start = Date.valueOf(res.getString(2));
                       list.get(i).value4.end = Date.valueOf(res.getString(3));
                       list.get(i).value4.count = res.getInt(4);
                       list.get(i).value4.dayWalker = res.getBoolean(5);
                       list.get(i).value4.type = res.getString(7);
                           break;
                   }
                   case 5: { 
                       list.get(i).value5.idGraph = res.getInt(1);
                       list.get(i).value5.start = Date.valueOf(res.getString(2));
                       list.get(i).value5.end = Date.valueOf(res.getString(3));
                       list.get(i).value5.count = res.getInt(4);
                       list.get(i).value5.dayWalker = res.getBoolean(5);
                       list.get(i).value5.type = res.getString(7);
                           break;
                   }
                   case 6: { 
                       list.get(i).value6.idGraph = res.getInt(1);
                       list.get(i).value6.start = Date.valueOf(res.getString(2));
                       list.get(i).value6.end = Date.valueOf(res.getString(3));
                       list.get(i).value6.count = res.getInt(4);
                       list.get(i).value6.dayWalker = res.getBoolean(5);
                       list.get(i).value6.type = res.getString(7);
                           break;
                   }
                   case 7: { 
                       list.get(i).value7.idGraph = res.getInt(1);
                       list.get(i).value7.start = Date.valueOf(res.getString(2));
                       list.get(i).value7.end = Date.valueOf(res.getString(3));
                       list.get(i).value7.count = res.getInt(4);
                       list.get(i).value7.dayWalker = res.getBoolean(5);
                       list.get(i).value7.type = res.getString(7);
                           break;
                   }
                   case 8: { 
                       list.get(i).value8.idGraph = res.getInt(1);
                       list.get(i).value8.start = Date.valueOf(res.getString(2));
                       list.get(i).value8.end = Date.valueOf(res.getString(3));
                       list.get(i).value8.count = res.getInt(4);
                       list.get(i).value8.dayWalker = res.getBoolean(5);
                       list.get(i).value8.type = res.getString(7);
                           break;
                   }
                   case 9: { 
                       list.get(i).value9.idGraph = res.getInt(1);
                       list.get(i).value9.start = Date.valueOf(res.getString(2));
                       list.get(i).value9.end = Date.valueOf(res.getString(3));
                       list.get(i).value9.count = res.getInt(4);
                       list.get(i).value9.dayWalker = res.getBoolean(5);
                       list.get(i).value9.type = res.getString(7);
                           break;
                   }
                   case 10: { 
                       list.get(i).value10.idGraph = res.getInt(1);
                       list.get(i).value10.start = Date.valueOf(res.getString(2));
                       list.get(i).value10.end = Date.valueOf(res.getString(3));
                       list.get(i).value10.count = res.getInt(4);
                       list.get(i).value10.dayWalker = res.getBoolean(5);
                       list.get(i).value10.type = res.getString(7);
                           break;
                   }
               }
               
               
           }
           
       }
       
       }catch(Exception e){}
       return list;
   }
   
   public void Query(String text) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
            Statement stat = conn.createStatement();
            boolean res = stat.execute(text);
   }
}
