package producetopic;

import bean.Formula;
import produceequation.Equations;

import java.util.HashSet;
import java.util.Set;

public class Exercise {
    public static Formula[] e;
    public static void generate(int n,int addPercentage){
        e = new Formula[n];
        Set<Formula> set = new HashSet<>();
        for(int i=0;i<n;i++){
            Formula temp;
            do {
                temp= Equations.getRandom(addPercentage);
            } while (!set.add(temp));

            if(temp.getOp() ==1) {
                temp.setAns(temp.getA() + temp.getB());
            }
            else{
                temp.setAns(temp.getA() - temp.getB());
            }
            e[i] = temp;
        }
    }
}
