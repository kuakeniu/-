package produceequation;

import bean.Formula;

public class Equations {
    public static Formula getRandom(int addPercentage){
        int a, b, op,isAddorSub;
        isAddorSub=(int)(Math.random()*(101));
        if(isAddorSub<=addPercentage){                     //如果小于百分比则为加法
            a=(int)(Math.random()*101);
            b=(int)(Math.random()*(101-a));
            op=1;
        }
        else {
            a=(int)(Math.random()*101);
            b=(int)(Math.random()*(a+1));
            op=2;
        }
        return new Formula(op, a, b);
    }
}
