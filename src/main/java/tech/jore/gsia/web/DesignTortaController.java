package tech.jore.gsia.web;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import tech.jore.gsia.domain.Ingredient;
import tech.jore.gsia.domain.Ingredient.Type;
import tech.jore.gsia.domain.Torta;


@Controller
@RequestMapping("/design")
@Slf4j
public class DesignTortaController {

	@GetMapping
	public String showDesignForm(Model model) {

		log.debug("generating internal repository...");
//@formatter:off		
		List<Ingredient> ingredients = Arrays.asList(
			new Ingredient("TFAR", "Torta co' la farina normale", Type.WRAP),
			new Ingredient("TFAI", "Torta co' la farina integrale", Type.WRAP),
			new Ingredient("SALC", "Salcicce", Type.PROTEIN),
			new Ingredient("PREG", "Pregiutto", Type.PROTEIN),
			new Ingredient("ERBA", "Erba ripassata", Type.VEGGIE),
			new Ingredient("PEPR", "Peperoni", Type.VEGGIE),
			new Ingredient("CIPO", "Cipolla", Type.VEGGIE),
			new Ingredient("RUCO", "Ruq'la", Type.VEGGIE),
			new Ingredient("PECO", "Pecorino", Type.CHEESE),
			new Ingredient("STRA", "Stracchino", Type.CHEESE),
			new Ingredient("SCAM", "Scamorza", Type.CHEESE),
			new Ingredient("TART", "Salsa Tartufo", Type.SAUCE),
			new Ingredient("OLIV", "Salsa alle olive", Type.SAUCE)
		);
//@formatter:on		
		log.debug("internal repository generated");

		for (Type type : Type.values()) {
			model.addAttribute(type.name().toLowerCase(), filterByType(ingredients, type));
		}
		model.addAttribute("design", new Torta());

		return "design";
	}




	private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
		return ingredients.stream().filter(x -> x.getType().equals(type)).collect(Collectors.toList());
	}




	@PostMapping
	public String processDesign(Torta design) {
		log.info("processing {}", design);
		return "redirect:/orders/current";
	}
}
