package tech.jore.gsia.web;


import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import tech.jore.gsia.domain.Anno;


@Controller
@RequestMapping("/newYear")
@Slf4j
public class NewYearController {

	@GetMapping
	public String prepareNewYear(Model model) {
		int y = Calendar.getInstance().get(Calendar.YEAR);
		log.debug("new year planning requested for year {}", y);
		model.addAttribute("anno", new Anno(y));
		return "editYear";
	}
}
