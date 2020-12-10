package producetopic;

import factory.ExerciseFactory;
import org.junit.Before;
import org.junit.Test;

public class ExerciseFactoryTest {
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void generate() {
        ExerciseFactory.generate(4,40);
    }
}