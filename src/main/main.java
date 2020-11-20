package main;

import producetopic.topic;
import main.xFrame;

import javax.swing.*;
import java.util.Scanner;

public class main {
    public static void main(String args[]){
        iFrame iF=new iFrame();
    }
    public static void Start(int n){
        int s[][]=new int[n][5];
        s=topic.generate(n);
        xFrame.Create(s,n);
    }
}
