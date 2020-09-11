package guru.springframework.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.math.BigDecimal;
import java.util.UUID;

//@Data
@Getter
@Setter
//@EqualsAndHashCode(exclude = "recipe")
@EqualsAndHashCode
public class Ingredient {
	//@Id
	private String id = UUID.randomUUID().toString();
	private String description;
	private BigDecimal amount;
	
	// Formerly @OneToOne(fetch = FetchType.EAGER) 
	private UnitOfMeasure uom;
	
	//Formerly @ManyToOne	
	//private Recipe recipe;
	
    public Ingredient() {
    }
	
    public Ingredient(String description, BigDecimal amount, UnitOfMeasure uom) {
        this.description = description;
        this.amount = amount;
        this.uom = uom;
    }
    
    public Ingredient(String description, BigDecimal amount, UnitOfMeasure uom, Recipe recipe) {
        this.description = description;
        this.amount = amount;
        this.uom = uom;
        //this.recipe = recipe;
    }

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

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public UnitOfMeasure getUom() {
		return uom;
	}

	public void setUom(UnitOfMeasure uom) {
		this.uom = uom;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}*/
}
