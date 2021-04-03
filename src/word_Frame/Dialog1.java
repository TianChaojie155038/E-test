package word_Frame;

import javax.print.attribute.Size2DSyntax;
import javax.swing.*;
import javax.swing.plaf.basic.BasicTreeUI;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;

public class Dialog1 extends JDialog {
    public Dialog1() {
        setBounds(600, 340, 430, 450);//放置在可见之前，否则无效
        setResizable(false);
        setLayout(null);
        Frame1 frame1 = new Frame1();
        frame1.setBounds(0, 0, 0, 0);
        frame1.setVisible(false);
        Container c = getContentPane();
        /**
         * “已有标签页↓”
         */
        JLabel jl8 = new JLabel("已有标签页↓");
        jl8.setBounds(5, 5, 188, 28);
        jl8.setFont(new Font("宋体", Font.BOLD, 25));
        c.add(jl8);
        /**
         * 文本域:显示已有标签页
         */
        JTextArea ta = new JTextArea();
        ta.setFont(new Font("宋体", Font.BOLD, 24));
        JScrollPane sp = new JScrollPane();
        sp.setViewportView(ta);
        sp.setBounds(5, 35, 388, 65);
        sp.setFont(new Font("宋体", Font.BOLD, 35));
        c.add(sp);
        /**
         * ”☆单词（要标记的单词）↓“
         */
        JLabel jl1 = new JLabel("☆单词(要更新的单词)↓");
        jl1.setBounds(5, 120, 288, 28);
        jl1.setFont(new Font("宋体", Font.BOLD, 20));
        c.add(jl1);
        /**
         * 单词框
         */
        JTextField tf = new JTextField();
        tf.setBounds(5, 168, 300, 30);
        tf.setFont(new Font("宋体", Font.BOLD, 23));
        c.add(tf);
        /**
         * “☆中文↓”
         */
        JLabel jl2 = new JLabel("☆中文↓");
        jl2.setBounds(5, 222, 188, 28);
        jl2.setFont(new Font("宋体", Font.BOLD, 20));
        c.add(jl2);
        /**
         * 中文框
         */
        JTextField tf1 = new JTextField();
        tf1.setBounds(5, 267, 300, 30);
        tf1.setFont(new Font("宋体", Font.BOLD, 23));
        c.add(tf1);
        /**
         * “要加入的标签页”
         */
        JLabel jl3 = new JLabel("☆要更新的标签页");
        jl3.setBounds(5, 310, 188, 28);
        jl3.setFont(new Font("宋体", Font.BOLD, 20));
        c.add(jl3);
        /**
         * 要加入的标签页
         */
        JTextField tf2 = new JTextField();
        tf2.setBounds(5, 352, 300, 30);
        tf2.setFont(new Font("宋体", Font.BOLD, 23));
        c.add(tf2);
        /**
         * 提示
         */
        JLabel jl4 = new JLabel("TIP:配合搜索拷贝粘贴可提高效率");
        jl4.setBounds(100, 210, 350, 28);
        jl4.setFont(new Font("宋体", Font.BOLD, 20));
        jl4.setForeground(Color.pink);
        c.add(jl4);
        /**
         * 添加
         */
        JLabel jl5 = new JLabel("ADD→");
        jl5.setBounds(325, 365, 188, 28);
        jl5.setFont(new Font("宋体", Font.BOLD, 20));
        jl5.setForeground(Color.pink);
        c.add(jl5);
        /**
         * 删除
         */
        JLabel jl7 = new JLabel("DELETE→");
        jl7.setBounds(325, 325, 188, 28);
        jl7.setFont(new Font("宋体", Font.BOLD, 20));
        jl7.setForeground(Color.pink);
        c.add(jl7);
        jl7.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {//鼠标点击时触发
                boolean b = false;//是否删除成功，默认为false（失败），成功后赋予true
                String s = tf.getText().replaceAll("\\s", "");//获取单词框内容并去除所有空格保存为s
                String s2 = "z" + frame1.zzh + "hb" + tf2.getText().replaceAll("\\s", "") + "q";//获取标签框内容并去除所有空格保存为s2,表名
                String url = "jdbc:mysql://127.0.0.1:3306/tip";//连接tip数据库
                String use = "root";
                String pw = "123456";
                String sql = "DELETE FROM " + s2 + " WHERE word = '" + s + "'";//在tip库中找到账号对应表,保存被标记的单词
                Connection co = null;
                Statement st = null;
                try {//无单词也可删除，只要语法对*******************************
                    co = DriverManager.getConnection(url, use, pw);//连接数据库
                    st = co.createStatement();
                    st.execute(sql);
                    b = true;
                    JLabel jl = new JLabel("删除成功");
                    jl.setBounds(320, 310, 150, 20);
                    jl.setFont(new Font("宋体", Font.BOLD, 20));
                    jl.setForeground(Color.red);
                    c.removeAll();
                    c.add(jl8);
                    c.add(sp);
                    c.add(jl1);
                    c.add(tf);
                    c.add(jl1);
                    c.add(jl2);
                    c.add(jl3);
                    c.add(tf2);
                    c.add(tf1);
                    c.add(jl4);
                    c.add(jl5);
                    c.add(jl7);
                    c.add(jl);
                    tf.setText("");
                    tf1.setText("");
                    tf.requestFocus();
                    c.repaint();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } finally {
                    if (b == false) {
                        JLabel jl = new JLabel("删除失败");
                        jl.setBounds(320, 310, 150, 20);
                        jl.setFont(new Font("宋体", Font.BOLD, 20));
                        jl.setForeground(Color.red);
                        c.removeAll();
                        c.add(jl8);
                        c.add(sp);
                        c.add(jl1);
                        c.add(tf);
                        c.add(jl1);
                        c.add(jl2);
                        c.add(jl3);
                        c.add(tf2);
                        c.add(tf1);
                        c.add(jl4);
                        c.add(jl5);
                        c.add(jl7);
                        c.add(jl);
                        tf.requestFocus();
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

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {//鼠标进入时触发
                jl7.setText("DELETE ");
                c.repaint();

            }

            @Override
            public void mouseExited(MouseEvent e) {//鼠标离开时触发
                jl7.setText("DELETE→");
                c.repaint();

            }
        });
        jl5.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {//鼠标点击触发
                boolean b = false;//是否添加成功，默认为false（失败），成功后赋予true
                String s = tf.getText().replaceAll("\\s", "");//获取单词框内容并去除所有空格保存为s
                String s1 = tf1.getText().replaceAll("\\s", "");//获取中文框内容并去除所有空格保存为s1
                String s2 = "z" + frame1.zzh + "hb" + tf2.getText().replaceAll("\\s", "") + "q";//获取标签框内容并去除所有空格保存为s2,表名
                String url = "jdbc:mysql://127.0.0.1:3306/tip";//连接tip数据库
                String use = "root";
                String pw = "123456";
                String sql = "INSERT INTO " + s2 + " VALUES('" + s + "','" + s1 + "')";//在tip库中找到账号对应表,保存被标记的单词
                Connection co = null;
                Statement st = null;
                try {
                    co = DriverManager.getConnection(url, use, pw);//连接数据库
                    st = co.createStatement();
                    st.execute(sql);
                    b = true;
                    JLabel jl = new JLabel("添加成功");
                    jl.setBounds(320, 310, 150, 20);
                    jl.setFont(new Font("宋体", Font.BOLD, 20));
                    jl.setForeground(Color.red);
                    c.removeAll();
                    c.add(jl8);
                    c.add(sp);
                    c.add(jl1);
                    c.add(tf);
                    c.add(jl1);
                    c.add(jl2);
                    c.add(jl3);
                    c.add(tf2);
                    c.add(tf1);
                    c.add(jl4);
                    c.add(jl5);
                    c.add(jl7);
                    c.add(jl);
                    tf.setText("");
                    tf1.setText("");
                    tf.requestFocus();
                    c.repaint();

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } finally {
                    if (b == false) {
                        JLabel jl = new JLabel("添加失败");
                        jl.setBounds(320, 310, 150, 20);
                        jl.setFont(new Font("宋体", Font.BOLD, 20));
                        jl.setForeground(Color.red);
                        c.removeAll();
                        c.add(jl8);
                        c.add(sp);
                        c.add(jl1);
                        c.add(tf);
                        c.add(jl1);
                        c.add(jl2);
                        c.add(jl3);
                        c.add(tf2);
                        c.add(tf1);
                        c.add(jl4);
                        c.add(jl5);
                        c.add(jl7);
                        c.add(jl);
                        tf.requestFocus();
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

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {//鼠标进入触发
                jl5.setText("ADD ");
                c.repaint();

            }

            @Override
            public void mouseExited(MouseEvent e) {//鼠标离开触发
                jl5.setText("ADD→");
                c.repaint();

            }
        });

        boolean b = false;//数据库查询tip名是否成功，默认为false（失败），成功后赋予true
        String url1 = "jdbc:mysql://127.0.0.1:3306/tipname";//连接tipname数据库
        String use = "root";
        String pw = "123456";
        String sql1 = "select * from " + frame1.zzh + "t";//在tipname库中查询tip名
        Connection co = null;
        Statement st = null;
        ResultSet rs = null;
        int i = 0;
        try {
            co = DriverManager.getConnection(url1, use, pw);//连接数据库
            st = co.createStatement();
            rs = st.executeQuery(sql1);
            b = true;
            String s = "";
            while (rs.next()) {
                i++;
                s = rs.getString(1);
                s = s.substring(0, s.length() - 1);
                s = s.substring(frame1.zzh.length() + 3, s.length());
                ta.append(i + " " + s + "\n");

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (b == false) {
                JLabel jl6 = new JLabel("网络错误");
                jl6.setBounds(150, 150, 188, 25);
                jl6.setFont(new Font("宋体", Font.BOLD, 22));
                jl6.setForeground(Color.red);
                c.removeAll();
                c.add(jl6);
                c.repaint();

            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
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

        setVisible(true);

    }
}
