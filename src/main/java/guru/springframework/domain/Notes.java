package guru.springframework.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;

@Data
//@EqualsAndHashCode(exclude= {"recipe"})
@EqualsAndHashCode
public class Notes {
	@Id
	private String id;
	
	//Formerly @OneToOne	
	//private Recipe recipe;
	
	//Formerly @Lob  
	private String recipeNotes;

	// *** Removed below all setters/getters because of using Lombok to remove boiler plate codes...****
	/*public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	public String getRecipeNotes() {
		return recipeNotes;
	}

	public void setRecipeNotes(String recipeNotes) {
		this.recipeNotes = recipeNotes;
	}*/
}
