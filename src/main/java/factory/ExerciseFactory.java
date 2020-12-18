package factory;
import com.csvreader.*;
import bean.Formula;
import factory.EquationsFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class ExerciseFactory {
    public static Formula[] e;

    public static void generate(int n, int addPercentage) {
        e = new Formula[n];
        Set<Formula> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            Formula temp;
            do {
                temp = EquationsFactory.getRandom(addPercentage);
            } while (!set.add(temp));

            if (temp.getOp() == 1) {
                temp.setAns(temp.getA() + temp.getB());
            } else {
                temp.setAns(temp.getA() - temp.getB());
            }
            e[i] = temp;
        }
    }
}
