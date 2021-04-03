package word_Frame;

import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
/*
紫色字体是方法外的变量，区别方法内的变量（不会因此重名报错）
 */

/************************账号加密对应编码表************************
 数字篇：0~0         1~1            2~2              3~3             4~4           5~5          6~6         7~7       8~8         9~9
 字母篇：a~10   b~11  c~12   d~13   e~14  f~15  g~16 h~17  i~18  j~19  k~20 l~21 m~22 n~23 o~24 p~25 q~26 r~27 s~28 t~29 u~30 v~31 w~32 x~33 y~34 z~35
 A~36 B~37 C~38 D~39 E~40 F~41 G~42 H~43 I~44 J~45 K~46 L~47 M~48 N~49 O~50 P~51 Q~52 R~53 S~54 T~55 U~56 V~57 W~58 X~59 Y~60 Z~61
 符号篇：`62 ·63 ~64 !65 ！66 @67 #68 $69 ￥70 %71 ^72 ……73 &74 *75 (76 （77 )78 ）79 -80 _81 ——82 =83 +84 /85 [86 【87 {88 ]89 】90 }91 \92 、93 |94 ;95 ；96 :97 ：98
 '99 ’100 "101 “102 ,103 ，104 <105 《106 .107 。108 >109 》110 ?111 ？112
 */
public class Frame extends JFrame {
    Connection co1 = null;//进入注册界面就连接数据库，查询用户名是否有重复
    boolean b = false;//默认false(无格式错误)，如果发现格式错误，则显示格式错误，并赋予true
    boolean b1 = false;//默认false（有重复用户名），如果发现用户名重复，则显示用户名存在，并赋予true
    boolean b2 = false;//默认false（注册时两次密码一致），如果发现输入两次密码不一致，则显示密码不同，并赋予true
    boolean b3 = false;//密码虚弱的提示，默认为false（密码强），显示strong，发现密码弱后，显示weak，并赋予true
    boolean b4 = false;//密码强的提示，默认为false（密码弱），显示weak，发现密码强后，显示strong，并赋予strong
    boolean b5 = false;//关于登录账号，默认为false,为错误的用户名或未注册，找到用户名后赋予true，用来控制“账号或密码错误的显示”
    boolean b6 = false;//关于登录密码，默认为false，为错误的密码（账号正确的前提（仅程序可知）），在账号正确的前提下，若密码正确，则赋予true，用来控制“账号或密码错误的提示”
    boolean b7 = false;//格式错误的状态,在用户名是否存在的检测之前，防止“用户名格式错误”显示混乱
    boolean b8 = false;//注册是否成功,默认为false，注册成功后赋予true
    boolean b9 = false;//登录时是否连接到数据库
    JLabel j = null;//注册账号时格式错误的全局变量，因为无法移除单个组件，状态检测需移除某一组件时，需移除全部，再添加回原来正确的组件（和b、b7一组）b和b7必须存在，因为
    JLabel j1 = null;//用户名存否的全局变量(和b1一组)
    JLabel j2 = null;//密码虚弱
    JLabel j3 = null;//密码强
    JLabel jl33;//返回键的全局控制
    JLabel j4 = null;//两次密码的比较提示
    JTextField t = null;//文本框
    JPasswordField p = null;//密码框
    JButton jb1 = null;//登录按钮
    JLabel j5 = null;//主背景
    JLabel j6 = null;//注册
    Font f = new Font("宋体", Font.BOLD, 35);
    Font f1 = new Font("宋体", Font.BOLD, 30);

    public Frame() {
        super("E-test 版本号1.0  作者QQ:745609163");//设置主窗体标题
        Container c = getContentPane();//获取
        c.setLayout(null);//******注意:在使用绝对布局后，必须给组件设置大小及坐标才能正常显示
        /*
        以下是注册的设置
         */
        j6 = new JLabel();
        Icon i2 = new ImageIcon("Picture/注册账号（默认）.png");//默认
        Icon i3 = new ImageIcon("Picture/注册账号（辅）.png");
        j6.setIcon(i2);
        j6.setBounds(50, 258, 71, 30);
        jl33 = new JLabel();//返回键
        j6.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {//鼠标点击触发,进入注册界面
                String url = "jdbc:mysql://127.0.0.1:3306/user";
                String use = "root";
                String pw = "123456";
                Connection co = null;
                try {
                    co = DriverManager.getConnection(url, use, pw);//连接数据库
                    co1 = co;
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                c.removeAll();
                Icon i = new ImageIcon("Picture/返回键.png");
                jl33.setIcon(i);
                jl33.setBounds(20, 18, 100, 50);
                c.add(jl33);
                //用户名
                JTextField tf = new JTextField();
                tf.setLocation(220, 175);//坐标
                tf.setSize(260, 30);//宽度及高度，单位:像素
                tf.setFont(new Font("黑体", Font.PLAIN, 20));
                tf.setText("用户名:");
                c.add(tf);
                //第一次密码框
                JPasswordField pf = new JPasswordField();
                pf.setColumns(20);//设置密码框的长度为20个字符
                pf.setFont(new Font("宋体", Font.BOLD, 20));
                pf.setSize(260, 30);
                pf.setLocation(220, 220);
                pf.setEchoChar('\u2605');
                c.add(pf);
                //第二次密码框
                JPasswordField pf1 = new JPasswordField();
                pf1.setColumns(20);//设置密码框的长度为20个字符
                pf1.setFont(new Font("宋体", Font.BOLD, 20));
                pf1.setSize(260, 30);
                pf1.setLocation(220, 270);
                pf1.setEchoChar('\u2605');
                c.add(pf1);
                //
                JLabel jl1 = new JLabel("确认密码:");
                jl1.setBounds(118, 268, 155, 35);
                jl1.setFont(new Font("宋体", Font.BOLD, 22));
                c.add(jl1);
                //注册
                JLabel jl2 = new JLabel("注册账号");
                jl2.setBounds(258, 25, 188, 30);
                jl2.setFont(new Font("宋体", Font.BOLD, 28));
                c.add(jl2);

                //注册按钮
                JButton jb = new JButton("注册");
                jb.setFont(new Font("宋体", Font.BOLD, 19));
                jb.setBounds(220, 322, 260, 30);
                c.add(jb);
                //注册按钮的设置
                jb.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        if (b7 == false) {//账号格式错误
                            JLabel jl = new JLabel("账号格式错误");
                            jl.setBounds(166, 80, 200, 30);
                            jl.setFont(f1);
                            jl.setForeground(Color.pink);
                            c.add(jl);
                            c.repaint();
                            return;
                        }
                        if (b1) {//账号重复
                            JLabel jl = new JLabel("账号重复");
                            jl.setBounds(166, 80, 200, 30);
                            jl.setFont(f1);
                            jl.setForeground(Color.pink);
                            c.add(jl);
                            c.repaint();
                            return;
                        }
                        if (b2) {//两次密码错误
                            JLabel jl = new JLabel("两次密码不同");
                            jl.setBounds(400, 80, 200, 30);
                            jl.setFont(f1);
                            jl.setForeground(Color.pink);
                            c.add(jl);
                            c.repaint();
                            return;
                        }
                        String s = tf.getText().replaceAll("\\s", "");//将用户名去除所有空格，保存为s
                        char[] dm = pf.getPassword();
                        char[] em = pf1.getPassword();
                        String dm1 = "";//保存第一次密码
                        String em1 = "";//保存第二次密码
                        for (char tmp : dm) {
                            dm1 += tmp;
                        }
                        for (char tmp1 : em) {
                            em1 += tmp1;
                        }
                        String dm2 = dm1.replaceAll("\\s", "");//将保存好的密码去除空格
                        String em2 = em1.replaceAll("\\s", "");//将保存好的密码去除空格
                        Date d = new Date();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-h-m-s");
                        String da = sdf.format(d);
                        Connection co = null;
                        Statement st = null;
                        String url = "jdbc:mysql://127.0.0.1:3306/user";//连接user数据库
                        String url1 = "jdbc:mysql://127.0.0.1:3306/word";//连接word数据库
                        String url2 = "jdbc:mysql://127.0.0.1:3306/tipname";//连接tipname数据库
                        String use = "root";
                        String pw = "123456";
                        String sql = "INSERT INTO user VALUES('" + s + "','" + dm2 + "','" + da + "')";//添加账号及密码到user表,并记录时间
                        String sql1 = "CREATE TABLE " + s + "w(word  char(100) NOT NULL,Chinese  char(100) NOT NULL,PRIMARY KEY (word)) ENGINE=InnoDB";
                        String sql2 = "CREATE TABLE " + s + "t(name  char(100) NOT NULL,date char(100) NOT NULL,PRIMARY KEY (name)) ENGINE=InnoDB";//在tipname库中建立账号对应表，用来保存tip的名字
                        try {
                            co = DriverManager.getConnection(url, use, pw);//连接数据库
                            st = co.createStatement();
                            st.execute(sql);
                            b8 = true;
                            c.removeAll();
                            JLabel jl = new JLabel("注册成功");
                            jl.setBounds(30, 50, 280, 66);
                            jl.setFont(new Font("宋体", Font.BOLD, 50));
                            c.add(jl);
                            JLabel jl1 = new JLabel("你的账号:" + s);
                            jl1.setBounds(30, 120, 500, 40);
                            jl1.setFont(new Font("宋体", Font.BOLD, 35));
                            c.add(jl1);
                            JButton jb = new JButton("去登陆！！！");
                            jb.setBounds(250, 310, 400, 60);
                            jb.setFont(new Font("宋体", Font.BOLD, 35));
                            c.add(jb);
                            jb.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    c.removeAll();
                                    c.add(j6);
                                    c.add(t);
                                    c.add(p);
                                    c.add(jb1);
                                    c.add(j5);
                                    c.repaint();

                                }
                            });
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        } finally {
                            if (b8 == false) {
                                JLabel jl = new JLabel("网络错误");
                                jl.setBounds(150, 20, 288, 30);
                                jl.setFont(new Font("宋体", Font.BOLD, 25));
                                jl.setForeground(Color.pink);
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
                        if (b8 == false) {
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

                        try {
                            co = DriverManager.getConnection(url2, use, pw);//连接数据库
                            st = co.createStatement();
                            st.execute(sql2);
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

                        c.repaint();

                    }
                });
                //注册时用户名设置
                tf.addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {

                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {//按键释放触发
                        if (e.getKeyChar() == '\n') {
                            jb.doClick();
                        }
                        int lu = 0;
                        String u = tf.getText().replaceAll("\\s", "");//获取用户名保存为u，并去除空格
                        if (u.length() < 6 | u.length() > 16) {
                            b7 = false;
                        } else b7 = true;

                        JLabel jl = new JLabel("用户名格式错误（长度应在6~16之间）");
                        j = jl;

                        Statement st = null;
                        ResultSet rs = null;
                        String sql = "SELECT * FROM user";//检索用户名是否存在
                        try {
                            st = co1.createStatement();
                            rs = st.executeQuery(sql);
                            String id1;
                            j1 = new JLabel("用户名存在");
                            while (rs.next()) {
                                id1 = rs.getString(1);
                                if (id1.equals(u)) {//检索会把所有只要包含有这些字符的部分的账号输出，此处设置比较，若比较相等，才是有相同账号
                                    b1 = true;
                                    j1.setFont(new Font("宋体", Font.BOLD, 20));
                                    j1.setBounds(400, 120, 200, 30);
                                    j1.setForeground(Color.red);
                                    lu = 1;
                                    c.add(j1);
                                    c.repaint();
                                    //不能返回，否则无法判断格式是否错误,但是要加入一个记录器 int lu 判断是不是本次用户名相同，防止提示立马被删除
                                }
                            }

                            if (lu == 0) {
                                if (rs.next() == false) {
                                    if (b1) {//显示了'用户名存在',需删除
                                        c.removeAll();
                                        if (b7 == false) {
                                            c.add(j);
                                        }
                                        if (b2) {
                                            c.add(j4);
                                        }
                                        if (b3) {
                                            c.add(j2);
                                        }
                                        if (b4) {
                                            c.add(j3);
                                        }
                                        b1 = false;

                                        c.add(tf);
                                        c.add(pf);
                                        c.add(pf1);
                                        c.add(jb);
                                        c.add(jl33);
                                        c.add(jl1);
                                        c.add(jl2);
                                        tf.requestFocus();
                                        c.repaint();
                                    }

                                }
                            }
                            String id;
                            if (lu == 0) {
                                while (rs.next()) {
                                    id = rs.getString(1);
                                    if (!id.equals(u)) {
                                        if (b1) {//显示了'用户名存在',需删除
                                            c.removeAll();
                                            if (b7 == false) {
                                                c.add(j);
                                            }
                                            if (b2) {
                                                c.add(j4);
                                            }
                                            if (b3) {
                                                c.add(j2);
                                            }
                                            if (b4) {
                                                c.add(j3);
                                            }
                                            b1 = false;

                                            c.add(tf);
                                            c.add(pf);
                                            c.add(pf1);
                                            c.add(jb);
                                            c.add(jl33);
                                            c.add(jl1);
                                            c.add(jl2);
                                            tf.requestFocus();
                                            c.repaint();
                                            break;
                                        }
                                    }
                                }
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

                        }

                        if (u.length() < 6 | u.length() > 16) {
                            if (b == false) {//没有提示过才能触发
                                jl.setBounds(130, 130, 288, 30);
                                jl.setFont(new Font("宋体", Font.BOLD, 13));
                                jl.setForeground(Color.red);
                                b = true;
                                c.add(jl);
                                c.repaint();
                                return;//如果用户名格式错误就中断该事件
                            }
                        } else if (b) {//b为true，把格式错误删除
                            c.removeAll();
                            if (b1) {
                                c.add(j1);
                            }
                            if (b2) {
                                c.add(j4);

                            }
                            if (b3) {
                                c.add(j2);
                            }
                            if (b4) {
                                c.add(j3);
                            }
                            b = false;
                            c.add(tf);
                            c.add(pf);
                            c.add(pf1);
                            c.add(jb);
                            c.add(jl33);
                            c.add(jl1);
                            c.add(jl2);
                            tf.requestFocus();
                            c.repaint();
                        }

                    }
                });
                //
                tf.addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {

                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                });
                //密码框的键盘监听
                pf.addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {

                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {//按键被释放触发
                        if (e.getKeyChar() == '\n') {
                            jb.doClick();
                        }

                        char[] c2 = pf.getPassword();
                        int c1 = c2.length;
                        j2 = new JLabel("weak");
                        j2.setForeground(Color.red);
                        j2.setBounds(500, 220, 150, 30);
                        j2.setFont(new Font("宋体", Font.PLAIN, 30));
                        j3 = new JLabel("strong");
                        j3.setForeground(Color.green);
                        j3.setBounds(500, 220, 150, 30);
                        j3.setFont(new Font("宋体", Font.PLAIN, 30));
                        if (c1 >= 10) {
                            if (b4 == false) {
                                c.removeAll();
                                if (b) {
                                    c.add(j);//用户名的格式

                                }
                                if (b1) {
                                    c.add(j1);//用户名存否

                                }
                                if (b2) {
                                    c.add(j4);//两次密码的比较
                                }
                                b4 = true;
                                b3 = false;
                                c.add(j3);
                                c.add(tf);//注册时的用户名
                                c.add(pf);//第一次密码框
                                c.add(pf1);//第二次密码框
                                c.add(jb);
                                c.add(jl33);//返回键
                                c.add(jl1);//第二次密码框的文本标签
                                c.add(jl2);//顶部文本标签
                                pf.requestFocus();
                            }
                        }
                        if (c1 < 10) {
                            if (b3 == false) {
                                c.removeAll();
                                if (b) {
                                    c.add(j);

                                }
                                if (b1) {
                                    c.add(j1);

                                }
                                if (b2) {
                                    c.add(j4);
                                }
                                b3 = true;
                                b4 = false;
                                c.add(j2);
                                c.add(tf);
                                c.add(pf);
                                c.add(pf1);
                                c.add(jb);
                                c.add(jl33);
                                c.add(jl1);
                                c.add(jl2);
                                pf.requestFocus();
                            }
                        }

                        c.repaint();

                    }
                });
                //
                pf.addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {

                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                        char[] c1 = pf.getPassword();
                        char[] c2 = pf1.getPassword();
                        String s1 = "";
                        String s2 = "";
                        for (char tmp : c1) {
                            s1 += tmp;
                        }
                        for (char tmp1 : c2) {
                            s2 += tmp1;
                        }

                        j4 = new JLabel("两次密码不一致");
                        j4.setForeground(Color.red);
                        j4.setBounds(500, 240, 220, 100);
                        j4.setFont(new Font("宋体", Font.PLAIN, 18));

                        if (!s1.equals(s2)) {
                            if (b2 == false) {
                                c.add(j4);
                                c.repaint();
                                b2 = true;

                            }
                        }
                        if (s1.equals(s2)) {
                            if (b2) {
                                b2 = false;
                                c.removeAll();
                                if (b) {
                                    c.add(j);

                                }
                                if (b1) {
                                    c.add(j1);

                                }
                                if (b3) {
                                    c.add(j2);
                                }
                                if (b4) {
                                    c.add(j3);
                                }
                                c.add(tf);
                                c.add(pf);
                                c.add(pf1);
                                c.add(jb);
                                c.add(jl33);
                                c.add(jl1);
                                c.add(jl2);
                                pf1.requestFocus();
                                c.repaint();
                            }

                        }

                    }
                });
                //第二次密码框键盘监听
                pf1.addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {

                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                        if (e.getKeyChar() == '\n') {
                            jb.doClick();
                        }
                        char[] c1 = pf.getPassword();
                        char[] c2 = pf1.getPassword();
                        String s1 = "";
                        String s2 = "";
                        for (char tmp : c1) {
                            s1 += tmp;
                        }
                        for (char tmp1 : c2) {
                            s2 += tmp1;
                        }

                        JLabel jl6 = new JLabel("两次密码不一致");
                        jl6.setForeground(Color.red);
                        jl6.setBounds(500, 240, 220, 100);
                        jl6.setFont(new Font("宋体", Font.PLAIN, 18));

                        if (!s1.equals(s2)) {
                            if (b2 == false) {
                                c.add(jl6);
                                c.repaint();
                                b2 = true;

                            }
                        }
                        if (s1.equals(s2)) {
                            if (b2) {
                                b2 = false;
                                c.removeAll();
                                if (b) {
                                    c.add(j);

                                }
                                if (b1) {
                                    c.add(j1);

                                }
                                if (b3) {
                                    c.add(j2);
                                }
                                if (b4) {
                                    c.add(j3);
                                }
                                c.add(tf);
                                c.add(pf);
                                c.add(pf1);
                                c.add(jb);
                                c.add(jl33);
                                c.add(jl1);
                                c.add(jl2);
                                pf1.requestFocus();
                                c.repaint();
                            }

                        }

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
            public void mouseEntered(MouseEvent e) {//鼠标进入触发
                j6.setIcon(i3);
                c.repaint();

            }

            @Override
            public void mouseExited(MouseEvent e) {//鼠标离开触发
                j6.setIcon(i2);
                c.repaint();

            }
        });
        c.add(j6);

        /*
        以下是用户名文本框的设置
         */
        t = new JTextField();
        t.setLocation(220, 175);//坐标
        t.setSize(260, 30);//宽度及高度，单位:像素
        t.setFont(new Font("黑体", Font.PLAIN, 20));
        t.setText("用户名:");
        c.add(t);
          /*
        以下是密码框的设置
         */
        p = new JPasswordField();
        p.setColumns(20);//设置密码框的长度为20个字符
        p.setFont(new Font("宋体", Font.BOLD, 20));
        p.setSize(260, 30);
        p.setLocation(220, 220);
        p.setEchoChar('\u2605');

        c.add(p);
        /*
        以下是登录按钮的设置
         */
        jb1 = new JButton("登录");
        jb1.setFont(new Font("宋体", Font.BOLD, 19));
        jb1.setBounds(220, 290, 260, 30);
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = t.getText().replaceAll("\\s", "");//将用户名去除空格保存为s

                char[] mm = p.getPassword();
                String mm1 = "";
                for (char tmp : mm) {
                    mm1 += tmp;
                }
                String mm2 = mm1.replaceAll("\\s", "");//将用户输入的密码去除空格保存为mm2
                Connection co = null;
                Statement st = null;
                ResultSet rs = null;
                String url = "jdbc:mysql://127.0.0.1:3306/user";//连接user数据库
                String use = "root";
                String pw = "123456";
                String sql = "SELECT * FROM user";
                String userm;
                JLabel jl = new JLabel("账号或密码错误");
                jl.setBounds(10, 10, 288, 30);
                jl.setFont(new Font("宋体", Font.BOLD, 30));
                jl.setForeground(Color.red);
                File file = new File("zh.txt");
                FileWriter fw = null;
                BufferedWriter bw = null;
                try {
                    co = DriverManager.getConnection(url, use, pw);//连接数据库
                    st = co.createStatement();
                    rs = st.executeQuery(sql);
                    b9 = true;
                    String user;
                    while (rs.next()) {
                        user = rs.getString("id");
                        userm = rs.getString("pw");
                        if (user.equals(s)) {//找到对应的用户名
                            b5 = true;
                            if (userm.equals(mm2)) {//密码正确

                                fw = new FileWriter(file);
                                bw = new BufferedWriter(fw);
                                String ss = "";//记录转换后的用户名
                                String er = "";
                                List l = new ArrayList();//记录切割量
                                // String ss1 = "";//记录每次分割的单个字符
                                //char数组
                                char[] userc = s.toCharArray();//将用户名转换为单个字符
                                for (char tmp : userc) {
                                    switch (tmp) {
                                        case '0':
                                            ss += 0;
                                            l.add("1");
                                            break;
                                        case '1':
                                            ss += 1;
                                            l.add("1");
                                            break;
                                        case '2':
                                            ss += 2;
                                            l.add("1");
                                            break;
                                        case '3':
                                            ss += 3;
                                            l.add("1");
                                            break;
                                        case '4':
                                            ss += 4;
                                            l.add("1");
                                            break;
                                        case '5':
                                            ss += 5;
                                            l.add("1");
                                            break;
                                        case '6':
                                            ss += 6;
                                            l.add("1");
                                            break;
                                        case '7':
                                            ss += 7;
                                            l.add("1");
                                            break;
                                        case '8':
                                            ss += 8;
                                            l.add("1");
                                            break;
                                        case '9':
                                            ss += 9;
                                            l.add("1");
                                            break;
                                        case 'a':
                                            ss += 10;
                                            l.add("2");
                                            break;
                                        case 'b':
                                            ss += 11;
                                            l.add("2");
                                            break;
                                        case 'c':
                                            ss += 12;
                                            l.add("2");
                                            break;
                                        case 'd':
                                            ss += 13;
                                            l.add("2");
                                            break;
                                        case 'e':
                                            ss += 14;
                                            l.add("2");
                                            break;
                                        case 'f':
                                            ss += 15;
                                            l.add("2");
                                            break;
                                        case 'g':
                                            ss += 16;
                                            l.add("2");
                                            break;
                                        case 'h':
                                            ss += 17;
                                            l.add("2");
                                            break;
                                        case 'i':
                                            ss += 18;
                                            l.add("2");
                                            break;
                                        case 'j':
                                            ss += 19;
                                            l.add("2");
                                            break;
                                        case 'k':
                                            ss += 20;
                                            l.add("2");
                                            break;
                                        case 'l':
                                            ss += 21;
                                            l.add("2");
                                            break;
                                        case 'm':
                                            ss += 22;
                                            l.add("2");
                                            break;
                                        case 'n':
                                            ss += 23;
                                            l.add("2");
                                            break;
                                        case 'o':
                                            ss += 24;
                                            l.add("2");
                                            break;
                                        case 'p':
                                            ss += 25;
                                            l.add("2");
                                            break;
                                        case 'q':
                                            ss += 26;
                                            l.add("2");
                                            break;
                                        case 'r':
                                            ss += 27;
                                            l.add("2");
                                            break;
                                        case 's':
                                            ss += 28;
                                            l.add("2");
                                            break;
                                        case 't':
                                            ss += 29;
                                            l.add("2");
                                            break;
                                        case 'u':
                                            ss += 30;
                                            l.add("2");
                                            break;
                                        case 'v':
                                            ss += 31;
                                            l.add("2");
                                            break;
                                        case 'w':
                                            ss += 32;
                                            l.add("2");
                                            break;
                                        case 'x':
                                            ss += 33;
                                            l.add("2");
                                            break;
                                        case 'y':
                                            ss += 34;
                                            l.add("2");
                                            break;
                                        case 'z':
                                            ss += 35;
                                            l.add("2");
                                            break;
                                        case 'A':
                                            ss += 36;
                                            l.add("2");
                                            break;
                                        case 'B':
                                            ss += 37;
                                            l.add("2");
                                            break;
                                        case 'C':
                                            ss += 38;
                                            l.add("2");
                                            break;
                                        case 'D':
                                            ss += 39;
                                            l.add("2");
                                            break;
                                        case 'E':
                                            ss += 40;
                                            l.add("2");
                                            break;
                                        case 'F':
                                            ss += 41;
                                            l.add("2");
                                            break;
                                        case 'G':
                                            ss += 42;
                                            l.add("2");
                                            break;
                                        case 'H':
                                            ss += 43;
                                            l.add("2");
                                            break;
                                        case 'I':
                                            ss += 44;
                                            l.add("2");
                                            break;
                                        case 'J':
                                            ss += 45;
                                            l.add("2");
                                            break;
                                        case 'K':
                                            ss += 46;
                                            l.add("2");
                                            break;
                                        case 'L':
                                            ss += 47;
                                            l.add("2");
                                            break;
                                        case 'M':
                                            ss += 48;
                                            l.add("2");
                                            break;
                                        case 'N':
                                            ss += 49;
                                            l.add("2");
                                            break;
                                        case 'O':
                                            ss += 50;
                                            l.add("2");
                                            break;
                                        case 'P':
                                            ss += 51;
                                            l.add("2");
                                            break;
                                        case 'Q':
                                            ss += 52;
                                            l.add("2");
                                            break;
                                        case 'R':
                                            ss += 53;
                                            l.add("2");
                                            break;
                                        case 'S':
                                            ss += 54;
                                            l.add("2");
                                            break;
                                        case 'T':
                                            ss += 55;
                                            l.add("2");
                                            break;
                                        case 'U':
                                            ss += 56;
                                            l.add("2");
                                            break;
                                        case 'V':
                                            ss += 57;
                                            l.add("2");
                                            break;
                                        case 'W':
                                            ss += 58;
                                            l.add("2");
                                            break;
                                        case 'X':
                                            ss += 59;
                                            l.add("2");
                                            break;
                                        case 'Y':
                                            ss += 60;
                                            l.add("2");
                                            break;
                                        case 'Z':
                                            ss += 61;
                                            l.add("2");
                                            break;
                                        case '`':
                                            ss += 62;
                                            l.add("2");
                                            break;
                                        case '·':
                                            ss += 63;
                                            l.add("2");
                                            break;
                                        case '~':
                                            ss += 64;
                                            l.add("2");
                                            break;
                                        case '!':
                                            ss += 65;
                                            l.add("2");
                                            break;
                                        case '！':
                                            ss += 66;
                                            l.add("2");
                                            break;
                                        case '@':
                                            ss += 67;
                                            l.add("2");
                                            break;
                                        case '#':
                                            ss += 68;
                                            l.add("2");
                                            break;
                                        case '$':
                                            ss += 69;
                                            l.add("2");
                                            break;
                                        case '￥':
                                            ss += 70;
                                            l.add("2");
                                            break;
                                        case '%':
                                            ss += 71;
                                            l.add("2");
                                            break;
                                        case '^':
                                            ss += 72;
                                            l.add("2");
                                            break;
                                        // case "……":ss +=73;l.add("2");break;
                                        case '&':
                                            ss += 74;
                                            l.add("2");
                                            break;
                                        case '*':
                                            ss += 75;
                                            l.add("2");
                                            break;
                                        case '(':
                                            ss += 76;
                                            l.add("2");
                                            break;
                                        case '（':
                                            ss += 77;
                                            l.add("2");
                                            break;
                                        case ')':
                                            ss += 78;
                                            l.add("2");
                                            break;
                                        case '）':
                                            ss += 79;
                                            l.add("2");
                                            break;
                                        case '-':
                                            ss += 80;
                                            l.add("2");
                                            break;
                                        case '_':
                                            ss += 81;
                                            l.add("2");
                                            break;
                                        //case '——':ss +=82;l.add("2");break;
                                        case '=':
                                            ss += 83;
                                            l.add("2");
                                            break;
                                        case '+':
                                            ss += 84;
                                            l.add("2");
                                            break;
                                        case '/':
                                            ss += 85;
                                            l.add("2");
                                            break;
                                        case '[':
                                            ss += 86;
                                            l.add("2");
                                            break;
                                        case '【':
                                            ss += 87;
                                            l.add("2");
                                            break;
                                        case '{':
                                            ss += 88;
                                            l.add("2");
                                            break;
                                        case ']':
                                            ss += 89;
                                            l.add("2");
                                            break;
                                        case '】':
                                            ss += 90;
                                            l.add("2");
                                            break;
                                        case '}':
                                            ss += 91;
                                            l.add("2");
                                            break;
                                        case '\\':
                                            ss += 92;
                                            l.add("2");
                                            break;
                                        case '、':
                                            ss += 93;
                                            l.add("2");
                                            break;
                                        case '|':
                                            ss += 94;
                                            l.add("2");
                                            break;
                                        case ';':
                                            ss += 95;
                                            l.add("2");
                                            break;
                                        case '；':
                                            ss += 96;
                                            l.add("2");
                                            break;
                                        case ':':
                                            ss += 97;
                                            l.add("2");
                                            break;
                                        case '：':
                                            ss += 98;
                                            l.add("2");
                                            break;
                                        case '\'':
                                            ss += 99;
                                            l.add("2");
                                            break;
                                        case '’':
                                            ss += 100;
                                            l.add("3");
                                            break;
                                        case '"':
                                            ss += 101;
                                            l.add("3");
                                            break;
                                        case '“':
                                            ss += 102;
                                            l.add("3");
                                            break;
                                        case ',':
                                            ss += 103;
                                            l.add("3");
                                            break;
                                        case '，':
                                            ss += 104;
                                            l.add("3");
                                            break;
                                        case '<':
                                            ss += 105;
                                            l.add("3");
                                            break;
                                        case '《':
                                            ss += 106;
                                            l.add("3");
                                            break;
                                        case '.':
                                            ss += 107;
                                            l.add("3");
                                            break;
                                        case '。':
                                            ss += 108;
                                            l.add("3");
                                            break;
                                        case '>':
                                            ss += 109;
                                            l.add("3");
                                            break;
                                        case '》':
                                            ss += 110;
                                            l.add("3");
                                            break;
                                        case '?':
                                            ss += 111;
                                            l.add("3");
                                            break;
                                        case '？':
                                            ss += 112;
                                            l.add("3");
                                            break;

                                    }
                                }
                                for (int i = 0; i >= 0; i++) {//转为二进制，但是是反的
                                    if (Long.valueOf(ss) != 0) {//将编码后的用户名转为long值,防止超出值的范围
                                        er += Long.valueOf(ss) % 2;
                                        ss = String.valueOf(Long.valueOf(ss) / 2);

                                    } else
                                        break;
                                }

                                Random r = new Random();
                                int x1 = 0;
                                String x2 = "";
                                for (int x = 0; x < 5; x++) {
                                    x1 = r.nextInt(2);
                                    x2 += x1;
                                }
                                bw.write(er + x2);
                                for (Object ob : l) {
                                    bw.newLine();
                                    bw.write(String.valueOf(ob));
                                }
                                bw.flush();//一定要刷新，否则无法读取

                                new Frame1();
                                setVisible(false);
                                b6 = true;
                                return;

                            }

                        }

                    }
                    if (b5 == false) {

                        c.add(jl);
                        c.repaint();
                    }
                    if (b6 == false) {
                        c.add(jl);
                        c.repaint();
                    }

                } catch (SQLException | IOException throwables) {
                    throwables.printStackTrace();
                } finally {
                    if (b9 == false) {
                        JLabel jl1 = new JLabel("网络错误");
                        jl1.setBounds(170, 10, 200, 30);
                        jl1.setFont(new Font("宋体", Font.BOLD, 20));
                        c.add(jl1);
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
                    if (bw != null) {
                        try {
                            bw.close();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    }
                    if (fw != null) {
                        try {
                            fw.close();
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    }

                }

            }
        });
        c.add(jb1);


        /*
        以下是主背景的设置
         */
        j5 = new JLabel();
        Icon i1 = new ImageIcon("Picture/主背景.png");
        j5.setIcon(i1);
        j5.setBounds(0, 0, 700, 600);
        c.add(j5);


        /*
        以下是窗口坐标、大小、图标、关闭规则、显示、大小改变的设置
         */
        setDefaultCloseOperation(EXIT_ON_CLOSE);//设置窗体关闭规则:点击X关闭程序
        setVisible(true);//设置窗体可见
        setBounds(340, 100, 700, 600);//设置窗体坐标及大小
        Image i = Toolkit.getDefaultToolkit().getImage("Picture/改版3窗体图标.png");//获得窗口图标
        setIconImage(i);
        setResizable(false);//使窗口无法改变大小
        //**返回键的鼠标监听
        jl33.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {//鼠标点击触发
                try {
                    co1.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                c.removeAll();
                c.add(j6);
                c.add(t);
                c.add(p);
                c.add(jb1);
                c.add(j5);
                c.repaint();

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        /*
        以下是回车模拟鼠标点击
         */

        t.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == '\n') {
                    jb1.doClick();
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        p.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == '\n') {
                    jb1.doClick();
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

    }
}
