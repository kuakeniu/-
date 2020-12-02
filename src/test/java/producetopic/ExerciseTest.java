package producetopic;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExerciseTest {
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void generate() {
        Exercise.generate(4,40);
    }
}