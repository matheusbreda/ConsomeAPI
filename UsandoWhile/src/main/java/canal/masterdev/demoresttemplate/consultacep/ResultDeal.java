package canal.masterdev.demoresttemplate.consultacep;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
public class ResultDeal implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@JsonProperty("ID") 
    public String iD;
    @JsonProperty("TITLE") 
    public String tITLE;
    @JsonProperty("TYPE_ID") 
    public String tYPE_ID;
    @JsonProperty("STAGE_ID") 
    public String sTAGE_ID;
    @JsonProperty("CURRENCY_ID") 
    public String cURRENCY_ID;
    @JsonProperty("OPPORTUNITY") 
    public String oPPORTUNITY;
    @JsonProperty("IS_MANUAL_OPPORTUNITY") 
    public String iS_MANUAL_OPPORTUNITY;
    @JsonProperty("TAX_VALUE") 
    public String tAX_VALUE;
    @JsonProperty("COMPANY_ID") 
    public String cOMPANY_ID;
    @JsonProperty("CONTACT_ID") 
    public String cONTACT_ID;
    @JsonProperty("ASSIGNED_BY_ID") 
    public String aSSIGNED_BY_ID;
    @JsonProperty("CREATED_BY_ID") 
    public String cREATED_BY_ID;
    @JsonProperty("MODIFY_BY_ID") 
    public String mODIFY_BY_ID;
    @JsonProperty("OPENED") 
    public String oPENED;
    @JsonProperty("CLOSED") 
    public String cLOSED;
    @JsonProperty("COMMENTS") 
    public String cOMMENTS;
    @JsonProperty("CATEGORY_ID") 
    public String cATEGORY_ID;
    @JsonProperty("STAGE_SEMANTIC_ID") 
    public String sTAGE_SEMANTIC_ID;
    @JsonProperty("IS_NEW") 
    public String iS_NEW;
    @JsonProperty("IS_RECURRING") 
    public String iS_RECURRING;
    @JsonProperty("IS_RETURN_CUSTOMER") 
    public String iS_RETURN_CUSTOMER;
    @JsonProperty("IS_REPEATED_APPROACH") 
    public String iS_REPEATED_APPROACH;
    @JsonProperty("SOURCE_ID") 
    public String sOURCE_ID;
    @JsonProperty("SOURCE_DESCRIPTION") 
    public String sOURCE_DESCRIPTION;
    @JsonProperty("MOVED_BY_ID") 
    public String mOVED_BY_ID;
    @JsonProperty("LAST_ACTIVITY_BY") 
    public String lAST_ACTIVITY_BY;
	
}
