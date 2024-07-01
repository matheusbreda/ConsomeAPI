package canal.masterdev.demoresttemplate.consultacep;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
@CrossOrigin(origins="*", maxAge = 3600)
public class ProductController {
	
	@Autowired
	private ProductService consomeService;
	
	@GetMapping("{page}")
	public List<Root> listarProduto(@PathVariable int page){
		return consomeService.consumirApiProduto(page);
	}
	
}
