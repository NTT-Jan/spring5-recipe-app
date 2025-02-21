package guru.springframework.integrationtest;

import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repositories.UnitOfMeasureRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryIT {

    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;



    @Test
    public void test() {
        Optional<UnitOfMeasure> unOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        Assert.assertEquals("Teaspoonss", unOptional.get().getDescription());
    }
}
