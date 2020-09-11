package guru.springframework.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
@Document
public class Category {
	@Id
	private String id;
	private String description;
	
	@EqualsAndHashCode.Exclude
	// Formerly @ManyToMany(mappedBy = "categories")
	private Set<Recipe> recipes;

	// *** Removed below all setters/getters because of using Lombok to remove boiler plate codes...****
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
	public Set<Recipe> getRecipes() {
		return recipes;
	}
	public void setRecipes(Set<Recipe> recipes) {
		this.recipes = recipes;
	}*/
}
