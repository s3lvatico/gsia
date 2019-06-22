package tech.jore.gsia.domain;


import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.CreditCardNumber;

import lombok.Data;


@Data
public class Order {

	@NotBlank(message = "nome richiesto")
	private String name;

	@NotBlank(message = "non saprei dove consegnare")
	private String street;

	@NotBlank(message = "città è richiesto")
	private String city;

	@NotBlank(message = "state è richiesto")
	private String state;

	@NotBlank(message = "CAP è richiesto")
	private String zip;

	@CreditCardNumber(message = "carta di credito non valida")
	private String ccNumber;

	@Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$", message = "formattata come MM/YY")
	private String ccExpiration;

	@Digits(fraction = 0, integer = 3, message = "3 cifre")
	private String ccCVV;
}
