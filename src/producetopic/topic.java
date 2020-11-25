package producetopic;

import produceequation.equation;

public class topic {
    public static int[][] generate(int n){
        int e[][]=new int[n][5];
        int temp[]=new int[3];
        for(int i=0;i<n;i++){
            temp=equation.getrandomnumber();
            e[i][0]=temp[0];                //0:+ or - , 1:a , 2:b , 3;answer  , 4:T or F
            e[i][1]=temp[1];
            e[i][2]=temp[2];
            if(e[i][0]==1) {
                e[i][3] = temp[1] + temp[2];
            }
            else{
                e[i][3]=temp[1]-temp[2];
            }
        }
        return e;
    }
}
