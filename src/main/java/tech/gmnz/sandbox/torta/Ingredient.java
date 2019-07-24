package tech.gmnz.sandbox.torta;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Ingredient {

	public enum Type {
		TORTA, VEGETALI, PROTEINE, FORMAGGIO
	}
	
	private final String id;
	private final String name;
	private final Type type;
	
}
