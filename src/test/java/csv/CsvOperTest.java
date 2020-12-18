package csv;

import bean.Formula;
import com.csvreader.CsvWriter;
import factory.ExerciseFactory;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;

import static factory.ExerciseFactory.*;
import static org.junit.Assert.*;

public class CsvOperTest {
    @Test
    public void writeCorrect() {
        ExerciseFactory.generate(5 , 50);
        CsvOper.writeCorrect("D:\\study\\软件构造\\test.csv");
    }

    @Test
    public void writeExercise() {
        ExerciseFactory.generate(5 , 50);
        CsvOper.writeExercise("D:\\study\\软件构造\\test.csv");
    }

    @Test
    public void writeInterrupt() {
        ExerciseFactory.generate(5 , 50);
        CsvOper.writeCorrect("D:\\study\\软件构造\\test.csv");
    }

    @Test
    public void readCorrect() {
        ExerciseFactory.generate(6 , 50);
        CsvOper.readCorrect("D:\\study\\软件构造\\readCorrect.csv");
        System.out.println(e[0].getA()+" "+e[0].getOp()+" "+e[0].getB()+" "+e[0].getUserAns()+" "+e[0].isUserCheck()+" "+e[0].getAns());
    }

    @Test
    public void readExercise() {
        ExerciseFactory.generate(6 , 50);
        CsvOper.readExercise("D:\\study\\软件构造\\readExercise.csv");
        System.out.println(e[0].getA()+" "+e[0].getOp()+" "+e[0].getB()+" "+e[0].getAns());
    }

    @Test
    public void readInterrupt() {
        ExerciseFactory.generate(6 , 50);
        CsvOper.readInterrupt("D:\\study\\软件构造\\readInterrupt.csv");
        System.out.println(e[0].getA()+" "+e[0].getOp()+" "+e[0].getB()+" "+e[0].getUserAns()+" "+e[0].getAns());
    }
}