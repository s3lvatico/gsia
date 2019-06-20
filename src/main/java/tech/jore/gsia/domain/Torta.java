package tech.jore.gsia.domain;

import java.util.List;

import lombok.Data;

@Data
public class Torta {

	private String name;
	private List<Ingredient> ingredients;
}
