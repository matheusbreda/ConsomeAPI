package canal.masterdev.demoresttemplate.consultacep;

import java.util.ArrayList;

import lombok.Data;

@Data
public class RootDealDTO {
	
		public ArrayList<ResultDeal> result;
	    public int next;
	    public int total;
	    public TimeDeal time;
}

