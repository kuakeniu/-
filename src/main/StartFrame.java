package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
//开始页面
public class StartFrame extends JFrame{
    JPanel ButtonPanel=new JPanel();
    JPanel TextPanel=new JPanel();
    List<JTextField> JT=new ArrayList<>();
    private int n;
    private int addPercentage;
    public StartFrame(){
        ButtonPanel.setLayout(new GridLayout(1,1));
        TextPanel.setLayout(new GridLayout(2,2));
        setLayout(new GridLayout(2,1,20,80));
        setSize(800, 500);
        setLocationRelativeTo(null);
        Container container=getContentPane();
        JLabel jLabel0=new JLabel("请输入要生成的题目数量",JLabel.CENTER);
        jLabel0.setPreferredSize(new Dimension(80,30));
        jLabel0.setFont(new Font("Helvetica", Font.BOLD, 20));
        JLabel jLabel1=new JLabel("请输入要生成加法的百分比",JLabel.CENTER);
        jLabel1.setPreferredSize(new Dimension(80,30));
        jLabel1.setFont(new Font("Helvetica", Font.BOLD, 20));
        JButton jumpButton=new JButton("生成");
        jumpButton.setPreferredSize(new Dimension(80,30));
        for(int i=0;i<2;i++){
            JTextField jTextField=new JTextField();
            jTextField.setPreferredSize(new Dimension(80,30));
            jTextField.setHorizontalAlignment(JTextField.CENTER);
            JT.add(jTextField);
        }
        ButtonPanel.add(jumpButton);
        TextPanel.add(jLabel0);
        TextPanel.add(jLabel1);
        TextPanel.add(JT.get(0));
        TextPanel.add(JT.get(1));
        container.add(TextPanel);
        container.add(ButtonPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        jumpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                n=Integer.parseInt(JT.get(0).getText());
                addPercentage=Integer.parseInt(JT.get(1).getText());
                setVisible(false);
                MainFrame jf=new MainFrame(n,addPercentage);
            }
        });
    }
}
