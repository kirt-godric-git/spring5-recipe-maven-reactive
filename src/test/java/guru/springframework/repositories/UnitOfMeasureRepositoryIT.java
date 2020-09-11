 package guru.springframework.repositories;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import guru.springframework.bootstrap.RecipeBootstrap;
import guru.springframework.domain.UnitOfMeasure;
import lombok.extern.slf4j.Slf4j;

// When a class is annotated with @RunWith or extends a class annotated with 
// @RunWith, JUnit will invoke the class it references to run the tests in 
// that class instead of the runner built into JUnit.
@Slf4j
//@Ignore
@RunWith(SpringRunner.class)
// @DataJpaTest will bring up an embedded database also configure Spring DataJPA for us
//@DataJpaTest
@DataMongoTest
public class UnitOfMeasureRepositoryIT {
	
	@Autowired
	UnitOfMeasureRepository unitOfMeasureRepository;
	
    @Autowired
    CategoryRepository categoryRepository;
    
    @Autowired
    RecipeRepository recipeRepository;

	@Before
	public void setUp() throws Exception {
    	log.info("setUp() called");
    	
    	// Speaker: To reset the database records content
    	log.info("Deleting all data....");
    	recipeRepository.deleteAll();
    	unitOfMeasureRepository.deleteAll();
    	categoryRepository.deleteAll();
    	
    	// Speaker: Mimicking what Spring would do for us in the context.
    	log.info("Initialize database records....");
    	RecipeBootstrap recipeBootstrap = new RecipeBootstrap(categoryRepository, recipeRepository, unitOfMeasureRepository);
    	
    	// Speaker: We just wanna call that on application on that and we're not using that context in there.
    	// So I'm just gonna pass at it, event in as null, so we're not checking that but it'll trigger
    	// all these others to load this.
    	recipeBootstrap.onApplicationEvent(null);
	}

	@Test
	@DirtiesContext
	public void testFindByDescription() throws Exception {
		log.info("findByDescription() called");
		
		Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
		
		assertEquals("Teaspoon", uomOptional.get().getDescription());		// Success
		//assertEquals("Teaspoonsss", uomOptional.get().getDescription());	// Fail
	}

	@Test
	public void testFindByDescriptionCup() throws Exception {
		log.info("findByDescriptionCup() called");
		
		Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Cup");
		
		assertEquals("Cup", uomOptional.get().getDescription());		// Success
	}
}
