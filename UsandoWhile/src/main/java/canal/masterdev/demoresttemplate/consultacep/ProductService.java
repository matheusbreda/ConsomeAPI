package canal.masterdev.demoresttemplate.consultacep;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;


@Service
public class ProductService {

	
	@Autowired
	private ResultRepository resultRepository;
	
	@Autowired
	private TimeRepository timeRepository;
	
	@Autowired
	private RootRepository rootRepository;
	
	public List<Root> consumirApiProduto(@PathVariable("page") int page) {
		List<Root> allResults = new ArrayList<>();
		 int limit = 20150;
	     int pageSize = 50;
	     while (page <= limit) {
	    	 
		RestTemplate restTemplate = new RestTemplate();
		RootDTO resultAPI = restTemplate.getForObject(String.format("https://syma.bitrix24.com.br/rest/71/1uqgro6xgaz5v5rg/crm.product.list.json?&start=%s", page), RootDTO.class);
		
	
		
		if(resultAPI != null) {
			Time time = new Time();
			time.setDateFinish(resultAPI.getTime().getDateFinish());
			time.setDateStart(resultAPI.getTime().getDateStart());
			time.setStart(resultAPI.getTime().getStart());
			time.setFinish(resultAPI.getTime().getFinish());
			time.setDuration(resultAPI.getTime().getDuration());
			time.setProcessing(resultAPI.getTime().getProcessing());
			time.setOperatingResetAt(resultAPI.getTime().getOperatingResetAt());
			time.setOperating(resultAPI.getTime().getOperating());
			
			timeRepository.save(time);
		}
		
		if (resultAPI != null && resultAPI.result != null) {
		    for (Result apiResult : resultAPI.result) {
		        Result result = new Result();
		        result.setID(apiResult.getID());
		        result.setNAME(apiResult.getNAME());
		        result.setCODE(apiResult.getCODE());
		        result.setACTIVE(apiResult.getACTIVE());
		        result.setSORT(apiResult.getSORT());
		        result.setXML_ID(apiResult.getXML_ID());
		        result.setTIMESTAMP_X(apiResult.getTIMESTAMP_X());
		        result.setDATE_CREATE(apiResult.getDATE_CREATE());
		        result.setMODIFIED_BY(apiResult.getMODIFIED_BY());
		        result.setCREATED_BY(apiResult.getCREATED_BY());
		        result.setCATALOG_ID(apiResult.getCATALOG_ID());
		        result.setDESCRIPTION_TYPE(apiResult.getDESCRIPTION_TYPE());
		        result.setVAT_INCLUDED(apiResult.getVAT_INCLUDED());

		        resultRepository.save(result);
		    }
		}
		
		if(resultAPI != null) {
			Root root = new Root();
			root.setResult(resultAPI.getResult());
			root.setNext(resultAPI.getNext());
			root.setTime(resultAPI.getTime());
			
			rootRepository.save(root);
			allResults.add(root);
		}
		
		 page += pageSize;
    }
	     
		
		return allResults;
	}
}
