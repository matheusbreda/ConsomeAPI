package canal.masterdev.demoresttemplate.consultacep;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@Entity
public class Result implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@JsonProperty("ID") 
    public String iD;
    @JsonProperty("NAME") 
    public String nAME;
    @JsonProperty("CODE") 
    public String cODE;
    @JsonProperty("ACTIVE") 
    public String aCTIVE;
    @JsonProperty("SORT") 
    public String sORT;
    @JsonProperty("XML_ID") 
    public String xML_ID;
    @JsonProperty("TIMESTAMP_X") 
    public Date tIMESTAMP_X;
    @JsonProperty("DATE_CREATE") 
    public Date dATE_CREATE;
    @JsonProperty("MODIFIED_BY") 
    public String mODIFIED_BY;
    @JsonProperty("CREATED_BY") 
    public String cREATED_BY;
    @JsonProperty("CATALOG_ID") 
    public String cATALOG_ID;
    @JsonProperty("DESCRIPTION_TYPE") 
    public String dESCRIPTION_TYPE;
    @JsonProperty("VAT_INCLUDED") 
    public String vAT_INCLUDED;
   
}
