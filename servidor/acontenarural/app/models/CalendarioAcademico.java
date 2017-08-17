package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.Model;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

@Entity
@Table
@JsonAutoDetect
public class CalendarioAcademico extends Model {
	@Id
	private Long id;
	@Column (nullable= false)
	private String title;
	
	@Column (nullable= false)
	private String start;
	
	@Column (nullable= false)
    private String end;
	
	@Column (nullable= false)
    private String color;
    
    public CalendarioAcademico( String title, String start, String end, String color){
    	 this.title = title;
    	 this.start = start;
         this.end = end;
         this.color= color;
    }
    
    public String getColor() {
		return color;
	}
    public String getEnd() {
		return end;
	}
    public String getStart() {
		return start;
	}
    public String getTitle() {
		return title;
	}
    
    public static  List<CalendarioAcademico> listar(){
		return Ebean.createQuery(CalendarioAcademico.class).where().findList();
	}
}
