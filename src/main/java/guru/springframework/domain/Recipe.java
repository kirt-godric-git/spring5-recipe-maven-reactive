package guru.springframework.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Data
@Document
public class Recipe {
	
	@Id
	private String id;
	private String description;
	private Integer prepTime;
	private Integer cookTime;
	private Integer servings;
	private String source;
	private String url;
	
	//Formerly @Lob
	private String directions;
	
	//Formerly @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe") 
	private Set<Ingredient> ingredients = new HashSet<>();

	//Formerly @Lob   
	private Byte[] image;
	
	// ** Specifies String values instead of Ordinal(e.g. 1,2..n) to avoid changing the values of Enum.
	//Formerly @Enumerated(value = EnumType.STRING) 
	private Difficulty difficulty;
	
	//Formerly @OneToOne(cascade = CascadeType.ALL)  
	private Notes notes;
	
	//Formerly @ManyToMany
	//Formerly@JoinTable(name = "recipe_category", 
	//	joinColumns = @JoinColumn(name = "recipe_id"), 
	//		inverseJoinColumns = @JoinColumn(name = "category_id"))
	private Set<Category> categories = new HashSet<>();
	
	// *** Removed below some setters/getters because of using Lombok to remove boiler plate codes...****
	/*public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Integer getPrepTime() {
		return prepTime;
	}
	public void setPrepTime(Integer prepTime) {
		this.prepTime = prepTime;
	}
	public Integer getCookTime() {
		return cookTime;
	}
	public void setCookTime(Integer cookTime) {
		this.cookTime = cookTime;
	}
	public Integer getServings() {
		return servings;
	}
	public void setServings(Integer servings) {
		this.servings = servings;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
    public String getDirections() {
        return directions;
    }
    public void setDirections(String directions) {
        this.directions = directions;
    }	
	public Byte[] getImage() {
		return image;
	}
	public void setImage(Byte[] image) {
		this.image = image;
	}
	public Notes getNotes() {
		return notes;
	}*/
	
	public void setNotes(Notes notes) {
		if (notes != null) {
			this.notes = notes;
			//notes.setRecipe(this);	// <-- might causing circular dependency exception!!!
		}
	}
	
	public Recipe addIngredient(Ingredient ingredient) {
		//ingredient.setRecipe(this);	// <-- causing circular dependency exception!!!
		this.ingredients.add(ingredient);
		return this;
	}
	
	/*public Set<Ingredient> getIngredients() {
		return ingredients;
	}
	public void setIngredients(Set<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	public Difficulty getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}
	public Set<Category> getCategories() {
		return categories;
	}
	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}*/
}
