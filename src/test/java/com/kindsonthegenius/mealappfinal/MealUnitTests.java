package com.kindsonthegenius.mealappfinal;
import com.kindsonthegenius.mealappfinal.models.Meal;
import com.kindsonthegenius.mealappfinal.repositories.MealRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MealUnitTests {

    @Autowired
    private MealRepository mealRepository;

    @Test
    @Rollback(false)
    public void testCreateMeal(){
        Meal meal = new Meal(3,
                "Gyulas",
                50.4,
                "Salt",
                Boolean.TRUE,
                Boolean.FALSE,
                "Delicious",
                89.2,
                "/image");
        Meal newMeal = mealRepository.save(meal);
        assertNotNull(newMeal);
    }

    @Test
    public void testFindMealById(){
       Meal meal = mealRepository.findById(3).orElse(null);
       assertThat(meal.getMeal_name()).isEqualTo("Gyulas");
    }

    @Test
    public void testFindMealByIdNull(){
        Meal meal = mealRepository.findById(5).orElse(null);
        assertNull(meal);
    }

    @Test
    public void testUpdateMeal(){
        Meal meal = new Meal(3,
                "Gyulas",
                50.4,
                "Salt",
                Boolean.TRUE,
                Boolean.FALSE,
                "Delicious",
                89.2,
                "/image");
        meal.setMeal_name("Gyulas");
        mealRepository.save(meal);
        List<Meal> updatedMeal = mealRepository.findMealByDescription("Meat and Bread");
        assertEquals(new ArrayList<>(), updatedMeal);
    }

    @Test
    @Rollback(false)
    public void testDeleteMeal(){
        Integer id = 2;
        boolean existsBeforeDelete = mealRepository.findById(id).isPresent();
        mealRepository.deleteById(id);
        boolean notExistsAfterDelete = mealRepository.findById(id).isPresent();
        assertTrue(existsBeforeDelete);
        assertFalse(notExistsAfterDelete);
    }

}
