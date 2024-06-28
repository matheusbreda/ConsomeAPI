package canal.masterdev.demoresttemplate.consultacep;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consomeAPI")
@CrossOrigin(origins="*", maxAge = 3600)
public class ConsomeAPIController {
	
	@Autowired
	private ConsomeAPIService consomeService;
	
	@GetMapping
	public List<Root> listar(){
		return consomeService.consumirApi();
	}
	
}
