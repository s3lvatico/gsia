package tech.gmnz.sandbox.torta.web;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import tech.gmnz.sandbox.torta.Ingredient;
import tech.gmnz.sandbox.torta.Ingredient.Type;
import tech.gmnz.sandbox.torta.Torta;

@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTortaController {

	@GetMapping
	public String showDesignForm(Model model) {
		List<Ingredient> ingredients = Arrays.asList(
				new Ingredient("TNRM", "Torta normale", Type.TORTA),
				new Ingredient("TINT", "Torta integrale", Type.TORTA),
				new Ingredient("TCIC", "Torta coi ciccioli", Type.TORTA),
				new Ingredient("SALC", "Salcicce", Type.PROTEINE),
				new Ingredient("PREG", "Pregiutto", Type.PROTEINE),
				new Ingredient("PORC", "Porchetta", Type.PROTEINE),
				new Ingredient("COPP", "Coppa", Type.PROTEINE),
				new Ingredient("ERBA", "Erba campagnola", Type.VEGETALI),
				new Ingredient("RUQL", "Rucola", Type.VEGETALI),
				new Ingredient("MELZ", "Melanzane", Type.VEGETALI),
				new Ingredient("CACT", "Caciotta", Type.FORMAGGIO),
				new Ingredient("GORG", "Gorgonzola", Type.FORMAGGIO),
				new Ingredient("PECR", "Pecorino", Type.FORMAGGIO)
		);

		for (Type t : Type.values()) {
			model.addAttribute(t.toString().toLowerCase(), filterByType(ingredients, t));
		}
		
		model.addAttribute("design", new Torta());
		
		return "design";
	}
	
	private List<Ingredient> filterByType(List<Ingredient> list, Type type) {
		return list
				.stream()
				.filter(x -> x.getType().equals(type))
				.collect(Collectors.toList());
	}
}
