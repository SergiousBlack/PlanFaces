import java.io.Serializable;
import java.sql.Connection;
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
   public DataBaseConnector() throws ClassNotFoundException, SQLException{
             String userName = "postgres";
            String password = "";
            String url = "jdbc:postgresql://localhost:5432/NewPlan";
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection (url, userName, password); // задаём строку подключения
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
   
   public int SelectPlanID(String s) throws SQLException{
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
   
        public List<PlanValuesFromBase> SelectPlanData(String plan) throws SQLException{
            List<PlanValuesFromBase> list = new ArrayList<PlanValuesFromBase>();
             Statement stat = conn.createStatement();
             ResultSet res = stat.executeQuery("SELECT idplan FROM plan where text = '"+plan+"'"); // выполняем запрос
             int id = 0;
            if(res.next()){
               id = res.getInt(1);
            }
            
             res = stat.executeQuery("Select course,week,value from planValues where idplan = "+id+" ORDER BY  planValues.course ASC, planValues.week ASC ");
            while(res.next()){
                list.add(new PlanValuesFromBase(res.getString(2),res.getString(1),res.getString(3)));
            }
            return list;
        }
        
         public List<SpecialityData> SelectDiscplData(String id) throws SQLException{
            List<SpecialityData> list = new ArrayList<SpecialityData>();
             Statement stat = conn.createStatement();
             ResultSet res = stat.executeQuery("Select dnamedic.name , dsubtypedic.name from dnamedic Left JOIN dsubtypedic on dsubtypedic.code = dnamedic.cycleid where dnamedic.iduser = "+id); // выполняем запрос
            while(res.next()){
                list.add(new SpecialityData(res.getString(1),res.getString(2)));
            }
            return list;
        }
        
      public List<String> ListPlans(String id){
       
       List<String> list = new ArrayList<String>();
 
        try
        {
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("SELECT text FROM plan where userid =  "+id); // выполняем запрос
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
   public List<String> getList(){
       
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
   public int getMaxSizeS() throws SQLException, ClassNotFoundException,InstantiationException,IllegalAccessException{
       
            Statement stat = conn.createStatement();
            ResultSet res = stat.executeQuery("SELECT * FROM  studyplanlist ORDER BY  studyplanlist.idplan DESC "); // выполняем запрос
            
            if(res.next()){
                return res.getInt(1);}
            else return 0;
   }
   public void Query(String text) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
            Statement stat = conn.createStatement();
            boolean res = stat.execute(text);
   }
}