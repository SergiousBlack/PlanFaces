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

/**
 *
 * @author Black
 */
@ManagedBean
public class newGraph implements Serializable{
    
    public int id;
    public String course;
    public String semestr;
    public Date start;
    public Date end;
    public GraphValue value1;
    public GraphValue value2;
    public GraphValue value3;
    public GraphValue value4;
    public GraphValue value5;
    public GraphValue value6;
    public GraphValue value7;
    public GraphValue value8;
    public GraphValue value9;
    public GraphValue value10;

    public newGraph(int id, String course, String semestr, Date start, Date end, GraphValue value1, GraphValue value2, GraphValue value3, GraphValue value4, GraphValue value5, GraphValue value6, GraphValue value7, GraphValue value8, GraphValue value9, GraphValue value10) {
        this.id = id;
        this.course = course;
        this.semestr = semestr;
        this.start = start;
        this.end = end;
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
        this.value4 = value4;
        this.value5 = value5;
        this.value6 = value6;
        this.value7 = value7;
        this.value8 = value8;
        this.value9 = value9;
        this.value10 = value10;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getSemestr() {
        return semestr;
    }

    public void setSemestr(String semestr) {
        this.semestr = semestr;
    }

    public Date getStart() {
        if(start!=null){
        Calendar f = Calendar.getInstance();
        f.setTime(start);
        f.add(Calendar.DATE, 1); 
        start = f.getTime();
        }
        return start;
    }

    public newGraph(String course, String semestr, Date start, Date end, GraphValue value1, GraphValue value2, GraphValue value3, GraphValue value4, GraphValue value5, GraphValue value6, GraphValue value7, GraphValue value8, GraphValue value9, GraphValue value10) {
        this.course = course;
        this.semestr = semestr;
        this.start = start;
        this.end = end;
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
        this.value4 = value4;
        this.value5 = value5;
        this.value6 = value6;
        this.value7 = value7;
        this.value8 = value8;
        this.value9 = value9;
        this.value10 = value10;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        if(end!=null){
        Calendar f = Calendar.getInstance();
        f.setTime(end);
        f.add(Calendar.DATE, 1); 
        end = f.getTime();
        }
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public GraphValue getValue1() {
        return value1;
    }

    public void setValue1(GraphValue value1) {
        this.value1 = value1;
    }

    public GraphValue getValue2() {
        return value2;
    }

    public void setValue2(GraphValue value2) {
        this.value2 = value2;
    }

    public GraphValue getValue3() {
        return value3;
    }

    public void setValue3(GraphValue value3) {
        this.value3 = value3;
    }

    public GraphValue getValue4() {
        return value4;
    }

    public void setValue4(GraphValue value4) {
        this.value4 = value4;
    }

    public GraphValue getValue5() {
        return value5;
    }

    public void setValue5(GraphValue value5) {
        this.value5 = value5;
    }

    public GraphValue getValue6() {
        return value6;
    }

    public void setValue6(GraphValue value6) {
        this.value6 = value6;
    }

    public GraphValue getValue7() {
        return value7;
    }

    public void setValue7(GraphValue value7) {
        this.value7 = value7;
    }

    public GraphValue getValue8() {
        return value8;
    }

    public void setValue8(GraphValue value8) {
        this.value8 = value8;
    }

    public GraphValue getValue9() {
        return value9;
    }

    public void setValue9(GraphValue value9) {
        this.value9 = value9;
    }

    public GraphValue getValue10() {
        return value10;
    }

    public void setValue10(GraphValue value10) {
        this.value10 = value10;
    }

    
     
}
