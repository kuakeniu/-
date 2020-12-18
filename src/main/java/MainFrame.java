import check.CheckAns;
import bean.Formula;
import csv.CsvOper;
import factory.ExerciseFactory;

import java.io.File;

import java.util.ArrayList;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class MainFrame extends JFrame {                         //计算页面
    public JPanel Countpanel;//创建计算面板
    public JPanel Buttonpanel;//创建按钮及结果面板
    public JButton Clearbutton;//创建清空按钮
    public JButton Resetbutton;//创建重置按钮
    public JButton Printfbutton;//创建打印按钮
    public JButton Savebutton;//创建保存按钮
    public JButton Recoverbutton;//创建恢复按钮
    public JLabel CountLable;//创建正确率(标签),正确率在标签正呈现
    public int[] userlist;//创建存储用户计算结果的集合
    public List<JLabel> questionLabel = new ArrayList<>();//创建题目(标签)集合,题目在标签中呈现
    public List<JTextField> inputTF = new ArrayList<>();//创建用户输入计算结果的文本框集合
    public List<JLabel> checkLabel =new ArrayList<>();//显示对错
    public List<JLabel> ansLabel =new ArrayList<>();//显示答案
    public int num;//设置用户答对的题数
    public int j = 0;
    private final int n;
    private int addPercentage;
    int control = 0;
    public MainFrame(int n,int addPercentage) {
        // add
        this.n = n;
        this.addPercentage=addPercentage;
        userlist = new int[n];
        Clearbutton = new JButton("重新生成题目");
        Resetbutton = new JButton("重写");
        Printfbutton = new JButton("检错显示答案");
        Savebutton = new JButton("存储");
        Recoverbutton = new JButton("恢复");
        Clearbutton.setSize(50,70);
        Resetbutton.setSize(50,70);
        Printfbutton.setSize(50,70);
        Savebutton.setSize(50,70);
        Recoverbutton.setSize(50,70);
        //初始化计数面板
        Countpanel = new JPanel();
        if(n % 2 != 0)
            control = n + 1;
        else
            control = n;
        Countpanel.setLayout(new GridLayout(control / 2 , 8 , 2 , 3));
        JScrollPane js=new JScrollPane(Countpanel,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        //初始化按钮面板
        Buttonpanel = new JPanel();
        Buttonpanel.setLayout(new GridLayout(6, 1,2,3));
        Buttonpanel.setSize(50, 600);
        Buttonpanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        CountLable = new JLabel("                         ");
        CountLable.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        //将按钮添加至按钮及结果面板中
        Buttonpanel.add(Resetbutton);
        Buttonpanel.add(Clearbutton);
        Buttonpanel.add(Printfbutton);
        Buttonpanel.add(Savebutton);
        Buttonpanel.add(Recoverbutton);
        Buttonpanel.add(CountLable);

        setLayout(new BorderLayout());
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = getContentPane();
        //将计数面板,按钮面板放置在容器中指定位置
        container.add(js, BorderLayout.CENTER);
        container.add(Buttonpanel, BorderLayout.WEST);
        setVisible(true);

        //
        CountLable();
        Create();
        myAddActionLIstener();
    }
    public void CountLable() {
        for (int i = 0; i < n; i++) {
            JLabel label = new JLabel();
            //重点:在设置布局的条件下,调用setPreferredSize(new Dimension(80, 20))可以设置标签的大小
            //重点:而不能调用setsize()方法
            label.setPreferredSize(new Dimension(50, 20));
            label.setFont(new Font("楷体", Font.BOLD, 20));
            label.setBorder(BorderFactory.createLineBorder(Color.RED));//设置标签的边界
            questionLabel.add(label);//list为题目(标签)集合,题目在标签中呈现
            JTextField textField = new JTextField(4);
            textField.setPreferredSize(new Dimension(50, 20));
            inputTF.add(textField);//inputTF为用户输入计算结果的文本框集合
            JLabel st = new JLabel();
            st.setPreferredSize(new Dimension(50, 20));
            checkLabel.add(st);
            JLabel jLabel = new JLabel();
            jLabel.setPreferredSize(new Dimension(50, 20));
            ansLabel.add(jLabel);
        }
        for (int i = 1; i <= n; i++) {//利用if-else语句来间隔输出标签和文本框
            Countpanel.add(questionLabel.get(j));
            Countpanel.add(inputTF.get(j));
            Countpanel.add(checkLabel.get(j));
            Countpanel.add(ansLabel.get(j));
            j++;
        }
        if( control > n){
            Countpanel.add(new JLabel());
            Countpanel.add(new JLabel());
            Countpanel.add(new JLabel());
            Countpanel.add(new JLabel());
        }
    }
    public void Create(){
        ExerciseFactory.generate(n,addPercentage);
        int i=0;
        for(JLabel jl: questionLabel){
            if(ExerciseFactory.e[i].getOp()==1){
                jl.setText(ExerciseFactory.e[i].getA()+"+"+ ExerciseFactory.e[i].getB());
                i++;
            }
            else {
                jl.setText(ExerciseFactory.e[i].getA()+"-"+ ExerciseFactory.e[i].getB());
                i++;
            }
        }
    }
    public void myAddActionLIstener() {
        //为清空按钮添加动作监听
        Clearbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                for(JLabel clearLable: questionLabel){
                    clearLable.setText("");
                }
                for(JTextField cleartextField : inputTF){
                    cleartextField.setText("");
                }
                for(JLabel jl: checkLabel){
                    jl.setText("");
                }
                for(JLabel jl: ansLabel){
                    jl.setText("");
                }
                Arrays.fill(userlist, 0);
                Create();
            }
        });
        //为重置按钮添加动作监听
        Resetbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                for(JTextField cleartextField : inputTF){
                    cleartextField.setText("");
                }
                for(JLabel jl: checkLabel){
                    jl.setText("");
                }
                for(JLabel jl: ansLabel){
                    jl.setText("");
                }
            }
        });
        //为打印按钮添加监听
        Printfbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Double result;
                num = 0;
                //获取用户在文本框中输入的计算结果

                for(int in = 0 ; in < userlist.length ; in++ ){//
                    String reg = "^[0-9]+(.[0-9]+)?$";
                    if(inputTF.get(in).getText().matches(reg)) {
                        userlist[in] = Integer.parseInt(inputTF.get(in).getText());
                    }
                    else{
                        userlist[in] = -1;
                    }
                }
                Formula[] h = CheckAns.cal(ExerciseFactory.e,n,userlist);
                int i=0;
                for(JLabel st: checkLabel){
                    if(h[i].isUserCheck()){
                        st.setText("正确");
                        i++;
                        num++;
                    }
                    else {
                        st.setText("错误");
                        i++;
                    }
                }
                for(int p=0;p<n;p++){
                    ansLabel.get(p).setText("答案:"+h[p].getAns());
                }
                //计算用户做题的正确率
                result = ((num*1.0)/(inputTF.size())*100);
                CountLable.setText(result + "%");
            }
        });
        Savebutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jFileChooser = new JFileChooser();
                FileFilter fileFilter = new FileFilter() {
                    @Override
                    public boolean accept(File pathname) {
                       if(pathname.getName().endsWith(".csv")||pathname.getName().endsWith(".CSV"))
                           return true;
                       else
                           return false;
                    }
                    @Override
                    public String getDescription() {
                        return null;
                    }
                };
                for(int in = 0 ; in < userlist.length ; in++ ){
                    String reg = "^[0-9]+(.[0-9]+)?$";
                    if(inputTF.get(in).getText().matches(reg)) {
                        ExerciseFactory.e[in].setUserAns(Integer.parseInt(inputTF.get(in).getText()));
                    }
                    else{
                        ExerciseFactory.e[in].setUserAns(-1);
                    }
                }
                jFileChooser.addChoosableFileFilter(fileFilter);
                jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                jFileChooser.showOpenDialog(null);
                String path = String.valueOf(jFileChooser.getSelectedFile());
                Object[] options = new Object[]{"批改文件" , "习题文件" , "中断文件"};
                int choose = JOptionPane.showOptionDialog(null ,"请选择存储类型","类型",
                        JOptionPane.YES_NO_CANCEL_OPTION , JOptionPane.ERROR_MESSAGE , null , options , options[1]);
                if(choose == 0)
                    CsvOper.writeCorrect(path);
                else if (choose == 1)
                    CsvOper.writeExercise(path);
                else if (choose == 2)
                    CsvOper.writeInterrupt(path);
            }
        });
        Recoverbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(JLabel clearLable: questionLabel){
                    clearLable.setText("");
                }
                for(JTextField cleartextField : inputTF){
                    cleartextField.setText("");
                }
                for(JLabel jl: checkLabel){
                    jl.setText("");
                }
                for(JLabel jl: ansLabel){
                    jl.setText("");
                }
                Arrays.fill(userlist, 0);
                FileFilter fileFilter = new FileFilter() {
                    @Override
                    public boolean accept(File pathname) {
                        if(pathname.getName().endsWith(".csv")||pathname.getName().endsWith(".CSV"))
                            return true;
                        else
                            return false;
                    }
                    @Override
                    public String getDescription() {
                        return null;
                    }
                };
                JFileChooser jFileChooser = new JFileChooser();
                jFileChooser.addChoosableFileFilter(fileFilter);
                jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                jFileChooser.showOpenDialog(null);
                String path = String.valueOf(jFileChooser.getSelectedFile());
                Object[] options = new Object[]{"批改文件" , "习题文件" , "中断文件"};
                int choose = JOptionPane.showOptionDialog(null ,"请选择存储类型","类型",
                        JOptionPane.YES_NO_CANCEL_OPTION , JOptionPane.ERROR_MESSAGE , null , options , options[1]);
                if(choose == 0) {
                    CsvOper.readCorrect(path);
                    int i = 0 ;
                    for(JLabel jl: questionLabel){
                        if(ExerciseFactory.e[i].getOp()==1){
                            jl.setText(ExerciseFactory.e[i].getA()+"+"+ ExerciseFactory.e[i].getB());
                            i++;
                        }
                        else {
                            jl.setText(ExerciseFactory.e[i].getA()+"-"+ ExerciseFactory.e[i].getB());
                            i++;
                        }
                    }
                    int ii = 0;
                    for(JTextField jtf : inputTF){
                        jtf.setText(String.valueOf(ExerciseFactory.e[ii].getUserAns()));
                        ii++;
                    }
                    int iii = 0;
                    for(JLabel jl : checkLabel){
                        jl.setText(String.valueOf(ExerciseFactory.e[iii].isUserCheck()));
                        iii++;
                    }
                    int iiii = 0;
                    for(JLabel jl : ansLabel){
                        jl.setText(String.valueOf(ExerciseFactory.e[iiii].getAns()));
                        iiii++;
                    }
                }
                else if (choose == 1){
                    CsvOper.readExercise( path );
                    int i=0;
                    for(JLabel jl: questionLabel){
                        if(ExerciseFactory.e[i].getOp()==1){
                            jl.setText(ExerciseFactory.e[i].getA()+"+"+ ExerciseFactory.e[i].getB());
                            i++;
                        }
                        else {
                            jl.setText(ExerciseFactory.e[i].getA()+"-"+ ExerciseFactory.e[i].getB());
                            i++;
                        }
                    }
                }
                else if (choose == 2){
                    CsvOper.readInterrupt( path );
                    int ii=0;
                    for(JLabel jl: questionLabel){
                        if(ExerciseFactory.e[ii].getOp()==1){
                            jl.setText(ExerciseFactory.e[ii].getA()+"+"+ ExerciseFactory.e[ii].getB());
                            ii++;
                        }
                        else {
                            jl.setText(ExerciseFactory.e[ii].getA()+"-"+ ExerciseFactory.e[ii].getB());
                            ii++;
                        }
                    }
                    int iii = 0;
                    for(JTextField jtf : inputTF){
                        if(ExerciseFactory.e[iii].getUserAns() != -1)
                            jtf.setText(String.valueOf(ExerciseFactory.e[iii].getUserAns()));
                        iii++;
                    }
                }
            }
        });
    }
}


