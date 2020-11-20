package main;

import producetopic.topic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class iFrame extends JFrame{
    JPanel ButtonPanel=new JPanel();
    JPanel TextPanel=new JPanel();
    int n;
    int s[][]=new int[n][5];
    public iFrame (){
        ButtonPanel.setLayout(new GridLayout(1,1));
        TextPanel.setLayout(new GridLayout(2,1));
        setLayout(new GridLayout(2,1,20,80));
        setSize(800, 500);
        setLocationRelativeTo(null);
        Container container=getContentPane();
        JLabel jLabel=new JLabel("请输入要生成的题目数量",JLabel.CENTER);
        jLabel.setPreferredSize(new Dimension(80,30));
        jLabel.setFont(new Font("楷体", Font.BOLD, 20));
        JButton jumpButton=new JButton("生成");
        jumpButton.setPreferredSize(new Dimension(80,30));
        JTextField jTextField=new JTextField();
        jTextField.setPreferredSize(new Dimension(80,30));
        jTextField.setHorizontalAlignment(JTextField.CENTER);
        ButtonPanel.add(jumpButton);
        TextPanel.add(jLabel);
        TextPanel.add(jTextField);
        container.add(TextPanel);
        container.add(ButtonPanel);
        setVisible(true);
        jumpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                n=Integer.valueOf(jTextField.getText());
                s= topic.generate(n);
                setVisible(false);
                xFrame jf=new xFrame(n,s);
            }
        });
    }
}
