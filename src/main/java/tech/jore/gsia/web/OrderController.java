package tech.jore.gsia.web;


import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import tech.jore.gsia.domain.Order;


@Controller
@RequestMapping("/orders")
@Slf4j
public class OrderController {

	@GetMapping("/current")
	public String orderForm(Model model) {
		model.addAttribute("order", new Order());
		return "orderForm";
	}




	@PostMapping
	public String processOrder(@Valid Order order, Errors errors) {
		log.info("order submitted: {}", order);
		if (errors.hasErrors()) {
			log.warn("errors in processed order {} :", errors);
			return "orderForm";
		}
		return "redirect:/";
	}
}
