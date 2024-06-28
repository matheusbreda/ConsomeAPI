package canal.masterdev.demoresttemplate.consultacep;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class ConsomeAPIService {

	@Value("${url.bitrix}")
	private String url;
	
	@Autowired
	private ResultRepository resultRepository;
	
	@Autowired
	private TimeRepository timeRepository;
	
	@Autowired
	private RootRepository rootRepository;
	
	public List<Root> consumirApi() {
		String urlApi = url;
		RestTemplate restTemplate = new RestTemplate();
		RootDTO resultAPI = restTemplate.getForObject(urlApi, RootDTO.class);
		
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
		}
		
		return rootRepository.findAll();
	}
}
