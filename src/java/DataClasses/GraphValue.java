/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataClasses;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import org.joda.time.DateTime;
import org.joda.time.Period;

/**
 *
 * @author Black
 */
@ManagedBean
public class GraphValue implements Serializable{
   
    public int idGraph;   

    public int getIdGraph() {
        return idGraph;
    }

    public void setIdGraph(int idGraph) {
        this.idGraph = idGraph;
    }

    public GraphValue(int idGraph, Date start, Date end, String type, int count, boolean dayWalker) {
        this.idGraph = idGraph;
        this.start = start;
        this.end = end;
        this.type = type;
        this.count = count;
        this.dayWalker = dayWalker;
    }
    public Date start;
    public Date end;
    public String type;
    public int count;
    public boolean dayWalker;
    
    public GraphValue(Date start, Date end, String type, int count,boolean ff) {
        this.start = start;
        this.end = end;
        this.type = type;
        this.count = count;
        this.dayWalker = ff;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCount() {
        
        if(start==null||end==null){
        return 0;
        }
        
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2  = Calendar.getInstance();
        
        cal1.setTime(start);
        cal2.setTime(end);
        
        long time = cal2.getTimeInMillis() - cal1.getTimeInMillis();
        
        // в секундах
        long seconds = time / 1000;
        // в минутах
        long minutes = seconds / 60;
        // в часах
        long hours = minutes / 60;
        // в днях
        long days = hours / 24;
        
        long weeks = days / 7;
        
      if(dayWalker){
        count = (int)days;
      }else{
          count = (int) weeks;
      }
      
      return count;
      
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isDayWalker() {
        return dayWalker;
    }

    public void setDayWalker(boolean dayWalker) {
        this.dayWalker = dayWalker;
    }
    
    
}
