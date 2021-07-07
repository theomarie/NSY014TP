package rest;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class EmployeController {
	private final AtomicLong counter = new AtomicLong();

	

	@GetMapping("employe")
	public Employe employe(@RequestParam(value = "name", defaultValue = "Corentin") String name) {
		return new Employe(counter.incrementAndGet(), name);
	}
	/*@PostMapping("/employees")
	ResponseEntity<?> newEmployee(@RequestBody Employe newEmployee) {

		  EntityModel<Employe> entityModel = assembler.toModel(repository.save(newEmployee));

		  return ResponseEntity //
		      .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
		      .body(entityModel);
		}*/
}
