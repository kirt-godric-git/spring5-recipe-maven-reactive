package guru.springframework.controllers;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.domain.Recipe;
//import guru.springframework.domain.Category;
//import guru.springframework.domain.UnitOfMeasure;
//import guru.springframework.repositories.CategoryRepository;
//import guru.springframework.repositories.UnitOfMeasureRepository;
import guru.springframework.services.RecipeService;
import guru.springframework.services.RecipeServiceImpl;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller	// <-- This class makes it as Spring Bean Component as a Controller
public class IndexController {
	/*private CategoryRepository categoryRepository;
	private UnitOfMeasureRepository unitOfMeasureRepository;
	
	public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
		super();
		this.categoryRepository = categoryRepository;
		this.unitOfMeasureRepository = unitOfMeasureRepository;
	}
	
	@RequestMapping({"", "/", "index"})
	public String getIndexPage() {
		Optional<Category> optionalCategory = categoryRepository.findByDescription("American");
		Optional<UnitOfMeasure> optionalUnitOfMeasure = unitOfMeasureRepository.findByDescription("Teaspoon");
		
		System.out.println("Category ID is "+optionalCategory.get().getId());
		System.out.println("UnitOfMeasure ID is "+optionalCategory.get().getId());
		
		return "index";	// <-- this will go to Thymeleaf template index.html
	}	
	*/

	private final RecipeService recipeService;
	
	public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }
	
	@RequestMapping({"", "/", "/index"})
	public String getIndexPage(Model model) {
		log.debug("Getting Index page");
		
		log.debug("Retrieving recipes from DB and routing to index.html...");		
		List<Recipe> recipes = recipeService.getRecipes().collectList().block();
		model.addAttribute("recipes", recipes);
		
		log.debug("recipes.size() = "+recipes.size());
		return "index";	// <-- this will go to Thymeleaf template index.html
	}
}
