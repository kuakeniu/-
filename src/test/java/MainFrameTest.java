import bean.Formula;
import check.CheckAns;
import factory.ExerciseFactory;
import org.junit.Test;

import java.awt.event.ActionEvent;

import static org.junit.Assert.*;

public class MainFrameTest {
    int n=2;
    Formula[] e=new Formula[2];
    int[] userlist=new int[]{40,20};
    @Test
        public void actionPerformed(){
            e[0]=new Formula(1,20,30);
            e[0].setAns(50);
            e[1]=new Formula(2,40,15);
            e[1].setAns(25);
            Formula[] h = CheckAns.cal(e,n,userlist);
        }
}