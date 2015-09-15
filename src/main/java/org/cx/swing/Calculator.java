package org.cx.swing;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 * 简单计算器
 * @author grass
 *
 */
public class Calculator implements ActionListener{
    JTextField jtf = new JTextField(20); 
    private String s1 = "0";
    private String operator ="+";
    private boolean append =false;                             //default is replace 
    public void actionPerformed(ActionEvent e){
        String comm = e.getActionCommand();
        if("0123456789".indexOf(comm)!=-1){
            if(append){
                String temp=jtf.getText();
                jtf.setText(temp+comm);
            }else{
                jtf.setText(comm);
                append = true;                                 //替换后又变成追回状态
            }
        }else if(".".equals(comm)){
            String temp=jtf.getText();
            if(temp.indexOf(".")==-1){
                jtf.setText(temp+".");             
                append = true;
            }
        }else if("+-*/".indexOf(comm)!=-1){
            s1 = jtf.getText();
            operator = comm;
            append = false;                                    // 变成替换的状态
        }else if("=".equals(comm)){
            String s2 = jtf.getText();
            double d1 = Double.parseDouble(s1);
            double d2 = Double.parseDouble(s2);
            BigDecimal bg1 = new BigDecimal(d1+"");
            BigDecimal bg2 = new BigDecimal(d2+"");
            if("+".equals(operator)){
                d1=bg1.add(bg2).doubleValue();
            }else if("-".equals(operator)){
                d1 = bg1.subtract(bg2).doubleValue();
            }
            else if("*".equals(operator)){
                d1 = bg1.multiply(bg2).doubleValue();
            }else if("/".equals(operator)){
                d1 = bg1.divide(bg2,10,BigDecimal.ROUND_HALF_UP).doubleValue();
            }
            if(d1 == (int)d1){    
                jtf.setText((int)d1+"");
            }else{
                jtf.setText(""+d1);
            }
            append =  false;
        }else if("+/-".equals(comm)){
            String temp = jtf.getText();
            if(temp.startsWith("-")){
                jtf.setText(temp.substring(1));
            }else if(!temp.equals("0")){
                jtf.setText("-"+temp);
            }
        }else if("CE".equals(comm) || "C".equals(comm)){
            jtf.setText("0");
            append = false;
        }else if("Back".equals(comm)){
            String temp = jtf.getText();
            if(temp.length()>0){
                jtf.setText(temp.substring(0,temp.length()-1));
            }
        }
    }
    public Calculator(){
        JFrame jf = new JFrame("My Calculator");
        jtf.setHorizontalAlignment(JTextField.RIGHT);         //右对齐
        jtf.setEditable(false);
        JPanel jp = new JPanel();
        jp.setLayout(new GridLayout(5,4));
        String[] label = {    "Back","CE","C","+",
                            "7","8","9","-",
                            "4","5","6","*",
                            "1","2","3","/",
                            "0","+/-",".","=",};
        JButton[] jb = new JButton[label.length];
        for(int i=0;i<jb.length;i++){
            jb[i] =  new JButton(label[i]);
            jp.add(jb[i]);
            jb[i].addActionListener(this);                    //给每一个按钮加一个监听的事件
        }
        jf.setLayout(new BorderLayout());                     //默认的布局管理器是BorderLayout,故此句可省略
        jf.add(jtf,BorderLayout.NORTH);
        jf.add(jp,BorderLayout.CENTER);
        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }catch(Exception e){
            System.exit(0);
        }
        jf.setSize(300,200);
        jf.setLocation(300,200);
        jf.setVisible(true);
        jf.setResizable(false);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new Calculator();
        }
}
