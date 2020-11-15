package main;

import producetopic.topic;
import main.xFrame;
import java.util.Scanner;

public class main {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n;
        n= sc.nextInt();
        int s[][]=new int[n][5];
        s= topic.generate(n);
        xFrame jf=new xFrame(n,s);

    }
    public static void Start(int n){
        int s[][]=new int[n][5];
        s=topic.generate(n);
        xFrame.Create(s,n);
    }
}
