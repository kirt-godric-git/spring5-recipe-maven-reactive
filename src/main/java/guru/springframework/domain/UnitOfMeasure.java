package guru.springframework.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


//@Data
@Getter
@Setter
@Document
public class UnitOfMeasure {

	@Id
	private String id;
	private String description;
	
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
	}*/
}
