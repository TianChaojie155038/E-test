package word_Frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Dialog extends JDialog {

    public Dialog(JFrame frame) {
        super(frame, "新建文本页", true);
        setBounds(600, 340, 280, 270);//放置在可见之前，否则无效
        setLayout(null);
        setResizable(false);//放在可视之前，否则无效
        Frame1 frame1 = new Frame1();
        frame1.setBounds(0, 0, 0, 0);
        frame1.setVisible(false);
        Container c = getContentPane();
        /**
         * 以下是文本框的设置
         */
        JTextField tf = new JTextField();
        tf.setBounds(5, 113, 252, 30);
        tf.setFont(new Font("宋体", Font.BOLD, 28));
        c.add(tf);
        /**
         * 以下是标签的设置
         */
        JLabel jl = new JLabel("输入文本名↓");
        jl.setBounds(15, 50, 200, 28);
        jl.setFont(new Font("宋体", Font.BOLD, 30));
        jl.setForeground(Color.gray);
        c.add(jl);
        /**
         * 以下是标签1的设置
         */
        JLabel jl1 = new JLabel("next→");
        jl1.setBounds(160, 180, 200, 20);
        jl1.setFont(new Font("宋体", Font.BOLD, 20));
        jl1.setForeground(Color.pink);
        c.add(jl1);
        jl1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {//鼠标点击组件触发
                boolean b = false;//是否成功创建标签
                String s = tf.getText().replaceAll("\\s", "");//获取文本框内容并保存为s
                Date d = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-h-m-s");
                String da = sdf.format(d);
                Connection co = null;
                Statement st = null;
                String url = "jdbc:mysql://127.0.0.1:3306/tip";//连接tip数据库
                String url1 = "jdbc:mysql://127.0.0.1:3306/tipname";//连接tipname数据库
                String use = "root";
                String pw = "123456";
                String sql = "create table z" + frame1.zzh + "hb" + s + "q (word char(100) not null,Chinese char(100) not null,primary key (word)) ENGINE=InnoDB";//在tip库中建立表,保存被标签的单词
                String sql1 = "INSERT INTO " + frame1.zzh + "t VALUES('" + "z" + frame1.zzh + "hb" + s + "q','" + da + "')";//在tipname库中保存tip名
                try {
                    co = DriverManager.getConnection(url, use, pw);//连接数据库
                    st = co.createStatement();
                    st.execute(sql);
                    b = true;
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } finally {
                    if (b == false) {
                        JLabel jl = new JLabel("网络错误或错误创建");
                        jl.setBounds(10, 11, 188, 25);
                        jl.setFont(new Font("宋体", Font.BOLD, 18));
                        jl.setForeground(Color.red);
                        c.add(jl);
                        c.repaint();
                    }
                    if (st != null) {
                        try {
                            st.close();
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    }
                    if (co != null) {
                        try {
                            co.close();
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    }

                }
                if (b == false) {
                    return;
                }

                try {
                    co = DriverManager.getConnection(url1, use, pw);//连接数据库
                    st = co.createStatement();
                    st.execute(sql1);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } finally {
                    if (st != null) {
                        try {
                            st.close();
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    }
                    if (co != null) {
                        try {
                            co.close();
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    }

                }
                c.removeAll();
                JLabel jl1 = new JLabel("新建成功");
                jl1.setBounds(28, 28, 158, 25);
                jl1.setFont(new Font("宋体", Font.BOLD, 22));
                jl1.setForeground(Color.green);
                c.add(jl1);

                JLabel jl2 = new JLabel("去标记！！！");
                jl2.setBounds(100, 170, 158, 25);
                jl2.setFont(new Font("宋体", Font.BOLD, 25));
                jl2.setForeground(Color.gray);
                c.add(jl2);
                jl2.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {//鼠标点击触发
                        frame1.jb5.doClick();
                        new Dialog1();

                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {//鼠标进入触发
                        jl2.setText("去标记   ");
                        c.repaint();

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {//鼠标离开触发
                        jl2.setText("去标记!!!");
                        c.repaint();

                    }
                });

                c.repaint();

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {//鼠标进入组件触发
                jl1.setText("next");
                c.repaint();

            }

            @Override
            public void mouseExited(MouseEvent e) {//鼠标离开组件触发
                jl1.setText("next→");
                c.repaint();

            }
        });

        setVisible(true);//所有组件必须放在可视之前，否则无法正常显示

    }
}
