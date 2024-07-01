package canal.masterdev.demoresttemplate.consultacep;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;


@Service
public class ConsomeAPIService {

	
	@Autowired
	private ResultRepository resultRepository;
	private ResultDealRepository resultDealRepository;
	
	@Autowired
	private TimeRepository timeRepository;
	private TimeDealRepository timeDealRepository;
	
	@Autowired
	private RootRepository rootRepository;
	private RootDealRepository rootDealRepository;
	
	public List<Root> consumirApiProduto(@PathVariable("page") int page) {
		List<Root> allResults = new ArrayList<>();
		 int limit = 20150;
	     int pageSize = 50;
	     while (page <= limit) {
	    	 
		RestTemplate restTemplate = new RestTemplate();
		RootDTO resultAPI = restTemplate.getForObject(String.format("https://syma.bitrix24.com.br/rest/71/1uqgro6xgaz5v5rg/crm.product.list.json?&start=%s", page), RootDTO.class);
		
		System.out.println("Começando!");
		
		if(resultAPI != null) {
			Time time = new Time();
			time.setDateFinish(resultAPI.getTime().getDateFinish());
			time.setDateStart(resultAPI.getTime().getDateStart());
			time.setStart(resultAPI.getTime().getStart());
			
			timeRepository.save(time);
		}
		
		if (resultAPI != null && resultAPI.result != null) {
		    for (Result apiResult : resultAPI.result) {
		        Result result = new Result();
		        result.setID(apiResult.getID());
		        result.setNAME(apiResult.getNAME());
		        result.setCODE(apiResult.getCODE());
		        result.setACTIVE(apiResult.getACTIVE());
		        
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
	     
	     System.out.println("");
		
		return allResults;
	}
	
	public List<RootDeal> consumirApiNegocio(@PathVariable("page") int page) {
		List<RootDeal> allResults = new ArrayList<>();
		 int limit = 20000;
	     int pageSize = 50;
	     while (page <= limit) {
	    	 
		RestTemplate restTemplate = new RestTemplate();
		RootDealDTO resultAPI = restTemplate.getForObject(String.format("https://syma.bitrix24.com.br/rest/71/7m2mw3ab8l60j7dc/crm.deal.list.json?&start=%s", page), RootDealDTO.class);
		
		if(resultAPI != null) {
			TimeDeal time = new TimeDeal();
			time.setDateFinish(resultAPI.getTime().getDateFinish());
			time.setDateStart(resultAPI.getTime().getDateStart());
			time.setStart(resultAPI.getTime().getStart());
			
			timeDealRepository.save(time);
			
		}
		
		if (resultAPI != null && resultAPI.result != null) {
		    for (ResultDeal apiResult : resultAPI.result) {
		        ResultDeal result = new ResultDeal();
		        result.setID(apiResult.getID());
		        result.setTITLE(apiResult.getTITLE());
		        result.setTYPE_ID(apiResult.getTYPE_ID());
		        result.setSTAGE_ID(apiResult.getSTAGE_ID());
		        
		        resultDealRepository.save(result);
		    }
		}
		
		if(resultAPI != null) {
			RootDeal root = new RootDeal();
			root.setResult(resultAPI.getResult());
			root.setNext(resultAPI.getNext());
			root.setTime(resultAPI.getTime());
			
			rootDealRepository.save(root);
			allResults.add(root);
		}
		
		 page += pageSize;
    }
		
		return allResults;
	}
}
