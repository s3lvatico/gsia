package tech.jore.gsia.domain;


import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;


@Data
public class Torta {

	@NotNull
	@Size(min = 3, message = "almeno 3 caratteri")
	private String name;

	@Size(min = 1, message = "scegli almeno un ingrediente")
	private List<String> ingredients;
}
