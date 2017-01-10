package fr.pizzeria.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.model.CategoriePizza;
import fr.model.Pizza;
import fr.pizzeria.dao.IPizzaRepository;

@Controller
@RequestMapping("/pizza")
public class PizzaController {

	@Autowired
	private IPizzaRepository database;

	@PostConstruct
	public void setPizzaInitialise() {
		database.save(new Pizza("MAR", "MARGARITA", CategoriePizza.VIANDE, 16.1, "url"));
		database.save(new Pizza("PEP", "PEPRONI", CategoriePizza.VIANDE, 11.1, "url"));
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@RequestBody
	public List<Pizza> findAll() {
		return database.findAll();
	}

	public void save(Pizza newPizza) {
		database.save(newPizza);
	}

	public void delete(String pizzaCode) {
		Pizza pizza = database.findAll().stream().filter(x -> x.getCode() == pizzaCode).findFirst().get();
		database.delete(pizza);
	}
}
