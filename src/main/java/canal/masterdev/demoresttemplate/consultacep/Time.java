package canal.masterdev.demoresttemplate.consultacep;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
public class Time implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	public double start;
    public double finish;
    public double duration;
    public double processing;
    @JsonProperty("date_start") 
    public Date dateStart;
    @JsonProperty("date_finish") 
    public Date dateFinish;
    @JsonProperty("operating_reset_at") 
    public int operatingResetAt;
    public double operating;
}
