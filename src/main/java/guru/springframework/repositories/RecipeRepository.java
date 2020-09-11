package guru.springframework.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import guru.springframework.domain.Recipe;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, String> {
	Optional<Recipe> findByDescription(String description);
}
