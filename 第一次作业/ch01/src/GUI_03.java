//This application is going to design GUI for user.
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class GUI_03 {
    public static void main(String[] args) {
        // 创建 JFrame 实例
        JFrame frame = new JFrame("投资值的计算");
        // Setting the width and height of frame
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* 创建面板，这个类似于 HTML 的 div 标签
         * 我们可以创建多个面板并在 JFrame 中指定位置
         * 面板中我们可以添加文本字段，按钮及其他组件。
         */
        JPanel panel = new JPanel();
        // 添加面板
        frame.add(panel);
        /*
         * 调用用户定义的方法并添加组件到面板
         */
        placeComponents(panel);

        // 设置界面可见
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {

        /* 布局部分我们这边不多做介绍
         * 这边设置布局为 null
         */
        panel.setLayout(null);

        // 创建 JLabel
        JLabel TotLabel = new JLabel("投资总额:");
        /* 这个方法定义了组件的位置。
         * setBounds(x, y, width, height)
         * x 和 y 指定左上角的新位置，由 width 和 height 指定新的大小。
         */
        TotLabel.setBounds(10,20,80,25);
        panel.add(TotLabel);

        /*
         * 创建文本域用于用户输入
         */
        JTextField TotText = new JTextField(20);
        TotText.setBounds(100,20,165,25);
        panel.add(TotText);

        // 输入密码的文本域
        JLabel PriceLabel = new JLabel("年利率：");
        PriceLabel.setBounds(10,50,80,25);
        panel.add(PriceLabel);

        /*
         *这个类似用于输入的文本域
         * 但是输入的信息会以点号代替，用于包含密码的安全性
         */
        JTextField PriceText = new JTextField(20);
        PriceText.setBounds(100,50,165,25);
        panel.add(PriceText);

        // 输入密码的文本域
        JLabel YearLabel = new JLabel("年数：");
        YearLabel.setBounds(10,80,80,25);
        panel.add(YearLabel);

        /*
         *这个类似用于输入的文本域
         * 但是输入的信息会以点号代替，用于包含密码的安全性
         */
        JTextField YearText = new JTextField(20);
        YearText.setBounds(100,80,165,25);
        panel.add(YearText);

        //创建文本输出框
        JTextArea AnswerText = new JTextArea();
        AnswerText.setBounds(100,110,165,25);
        panel.add(AnswerText);

        //创建答案文本框
        JLabel AnsLabel = new JLabel("应投资：");
        AnsLabel.setBounds(10,110,80,25);
        panel.add(AnsLabel);

        // 创建登录按钮
        JButton loginButton = new JButton("计算");
        loginButton.setBounds(100, 140, 80, 25);
        panel.add(loginButton);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double Tot = Double.parseDouble(TotText.getText());
                double Price = Double.parseDouble(PriceText.getText());
                double Years = Double.parseDouble(YearText.getText());
                double Answer = Tot*(Math.pow((1+Price),Years));
                AnswerText.setText(String.valueOf(Answer));
            }
        });
    }

}
