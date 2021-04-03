package word_Frame;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.*;
import java.util.List;

public class Dialog2 extends JDialog {
    public Dialog2() {
        setBounds(600, 340, 430, 450);//放置在可见之前，否则无效
        setResizable(false);
        setLayout(null);
        Frame1 frame1 = new Frame1();
        frame1.setBounds(0, 0, 0, 0);
        frame1.setVisible(false);
        Container c = getContentPane();
        boolean b = false;//数据库查询tip名是否成功，默认为false（失败），成功后赋予true
        String url1 = "jdbc:mysql://127.0.0.1:3306/tipname";//连接tipname数据库
        String use = "root";
        String pw = "123456";
        String sql1 = "select * from " + frame1.zzh + "t";//在tipname库中查询tip名
        Connection co = null;
        Statement st = null;
        ResultSet rs = null;
        List l = new ArrayList();//保存所有的标签名
        String bn = "";

        try {
            co = DriverManager.getConnection(url1, use, pw);//连接数据库
            st = co.createStatement();
            rs = st.executeQuery(sql1);
            b = true;
            while (rs.next()) {
                bn = rs.getString(1);
                l.add(bn);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {

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

        JTextArea ta = new JTextArea();
        ta.setBounds(5, 5, 500, 300);
        ta.setFont(new Font("宋体", Font.BOLD, 22));
        JScrollPane sp = new JScrollPane();
        sp.setViewportView(ta);
        sp.setBounds(5, 5, 405, 402);
        c.add(sp);
        if (l.size() == 0) {
            ta.append("没有标签");
        }
        if (b == false) {
            c.removeAll();
            JLabel jl = new JLabel("网络错误");
            jl.setBounds(100, 200, 188, 28);
            jl.setFont(new Font("宋体", Font.BOLD, 28));
            jl.setForeground(Color.red);
            c.add(jl);
            c.repaint();
        }
        for (Object o : l) {
            boolean b1 = false;//数据库查询tip名是否成功，默认为false（失败），成功后赋予true
            String url = "jdbc:mysql://127.0.0.1:3306/tip";//连接tip数据库
            String sql = "select * from " + o;
            String s = "";//记录单词
            String s1 = "";//记录中文
            int i = 0;
            try {
                co = DriverManager.getConnection(url, use, pw);//连接数据库
                st = co.createStatement();
                rs = st.executeQuery(sql);
                b1 = true;
                String o1 = String.valueOf(o);
                o1 = o1.substring(0, o1.length() - 1);
                o1 = o1.substring(frame1.zzh.length() + 3, o1.length());
                ta.append("(标签)" + o1 + ":\n");
                while (rs.next()) {
                    i++;
                    s = rs.getString(1);
                    s1 = rs.getString(2);
                    ta.append(i + " " + s + " " + s1 + " ");
                    if (i % 3 == 0) {
                        ta.append("\n");
                    }
                }
                ta.append("\n");

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                if (b1 == false) {
                    c.removeAll();
                    JLabel jl = new JLabel("网络错误");
                    jl.setBounds(100, 200, 188, 28);
                    jl.setFont(new Font("宋体", Font.BOLD, 28));
                    c.add(jl);
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
        }

        setVisible(true);
    }
}
