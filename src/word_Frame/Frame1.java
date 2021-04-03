package word_Frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.List;
import static java.awt.event.KeyEvent.*;

public class Frame1 extends JFrame {
    int i;//日志条数记录
    int q;//记录第一次索引
    int w;//记录第一次索引
    int sl;//记录测试总单词数
    JLabel jl4 = null;//添加界面的主标题
    JLabel jl5 = null;//添加界面的“单词:”
    JLabel jl6 = null;//添加界面的“中文:”
    JLabel jl7 = null;//搜索界面的“从词库搜索”
    JLabel jlz = null;//账号欢迎
    JTextField tf1 = null;//添加界面的单词框
    JTextField tf2 = null;//添加界面的中文框
    JButton jb5;//搜索按钮
    JButton jb6;//tip按钮
    JButton jb7;//添加界面的ADD按钮
    JTextField tf3;//搜索界面的搜索框
    JScrollPane sp2;//搜索界面的文本域
    JList jll1;
    String zzh = "";

    public Frame1() {
        super("E-test 版本号1.0  作者QQ:745609163");
        setBounds(380, 110, 700, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        final Container[] c = {getContentPane()};
        c[0].setLayout(null);
        //解出登录账号
        File fi = new File("zh.txt");
        FileReader fr = null;
        BufferedReader br = null;
        String zh = "";//读取第一行的账号
        try {
            fr = new FileReader(fi);
            br = new BufferedReader(fr);
            List l = new ArrayList();
            zh = br.readLine();

            char[] zh1 = zh.toCharArray();//将二进制码单独读进数组
            String zh3 = "";

            for (int i = 0; i < zh1.length - 5; i++) {
                zh3 += zh1[i];//获得转换后的账号的真实二进制码
            }
            char[] zh4 = zh3.toCharArray();//将真实的二进制码转化进数组
            String zh5 = "";
            for (int k = zh4.length - 1; k >= 0; k--) {
                zh5 += zh4[k];
            }
            zh3 = String.valueOf(Long.parseLong(zh5, 2));//获得转换后的账号,设置为long值
            char zh6[] = zh3.toCharArray();//将账号写进数组
            String fg = "";//记录分割数
            int sy = 0;//记录上一次读到的位置
            for (int ik = 0; ik >= 0; ik++) {
                fg = br.readLine();
                if (fg == null) {
                    break;
                }
                if (fg.equals("1")) {//分割数为1
                    String z = "";
                    z += zh6[sy];
                    switch (z) {
                        case "0":
                            zzh += 0;
                            break;
                        case "1":
                            zzh += 1;
                            break;
                        case "2":
                            zzh += 2;
                            break;
                        case "3":
                            zzh += 3;
                            break;
                        case "4":
                            zzh += 4;
                            break;
                        case "5":
                            zzh += 5;
                            break;
                        case "6":
                            zzh += 6;
                            break;
                        case "7":
                            zzh += 7;
                            break;
                        case "8":
                            zzh += 8;
                            break;
                        case "9":
                            zzh += 9;
                            break;

                    }

                    sy++;
                }

                if (fg.equals("2")) {//分割数为2
                    String z = "";
                    for (int i = sy; i < sy + 2; i++) {
                        z += zh6[i];
                    }
                    switch (z) {
                        case "10":
                            zzh += "a";
                            break;
                        case "11":
                            zzh += "b";
                            break;
                        case "12":
                            zzh += "c";
                            break;
                        case "13":
                            zzh += "d";
                            break;
                        case "14":
                            zzh += "e";
                            break;
                        case "15":
                            zzh += "f";
                            break;
                        case "16":
                            zzh += "g";
                            break;
                        case "17":
                            zzh += "h";
                            break;
                        case "18":
                            zzh += "i";
                            break;
                        case "19":
                            zzh += "j";
                            break;
                        case "20":
                            zzh += "k";
                            break;
                        case "21":
                            zzh += "l";
                            break;
                        case "22":
                            zzh += "m";
                            break;
                        case "23":
                            zzh += "n";
                            break;
                        case "24":
                            zzh += "o";
                            break;
                        case "25":
                            zzh += "p";
                            break;
                        case "26":
                            zzh += "q";
                            break;
                        case "27":
                            zzh += "r";
                            break;
                        case "28":
                            zzh += "s";
                            break;
                        case "29":
                            zzh += "t";
                            break;
                        case "30":
                            zzh += "u";
                            break;
                        case "31":
                            zzh += "v";
                            break;
                        case "32":
                            zzh += "w";
                            break;
                        case "33":
                            zzh += "x";
                            break;
                        case "34":
                            zzh += "y";
                            break;
                        case "35":
                            zzh += "z";
                            break;
                        case "36":
                            zzh += "A";
                            break;
                        case "37":
                            zzh += "B";
                            break;
                        case "38":
                            zzh += "C";
                            break;
                        case "39":
                            zzh += "D";
                            break;
                        case "40":
                            zzh += "E";
                            break;
                        case "41":
                            zzh += "F";
                            break;
                        case "42":
                            zzh += "G";
                            break;
                        case "43":
                            zzh += "H";
                            break;
                        case "44":
                            zzh += "I";
                            break;
                        case "45":
                            zzh += "J";
                            break;
                        case "46":
                            zzh += "K";
                            break;
                        case "47":
                            zzh += "L";
                            break;
                        case "48":
                            zzh += "M";
                            break;
                        case "49":
                            zzh += "N";
                            break;
                        case "50":
                            zzh += "O";
                            break;
                        case "51":
                            zzh += "P";
                            break;
                        case "52":
                            zzh += "Q";
                            break;
                        case "53":
                            zzh += "R";
                            break;
                        case "54":
                            zzh += "S";
                            break;
                        case "55":
                            zzh += "T";
                            break;
                        case "56":
                            zzh += "U";
                            break;
                        case "57":
                            zzh += "V";
                            break;
                        case "58":
                            zzh += "W";
                            break;
                        case "59":
                            zzh += "X";
                            break;
                        case "60":
                            zzh += "Y";
                            break;
                        case "61":
                            zzh += "Z";
                            break;
                        case "62":
                            zzh += "`";
                            break;
                        case "63":
                            zzh += "·";
                            break;
                        case "64":
                            zzh += "~";
                            break;
                        case "65":
                            zzh += "!";
                            break;
                        case "66":
                            zzh += "！";
                            break;
                        case "67":
                            zzh += "@";
                            break;
                        case "68":
                            zzh += "#";
                            break;
                        case "69":
                            zzh += "$";
                            break;
                        case "70":
                            zzh += "￥";
                            break;
                        case "71":
                            zzh += "%";
                            break;
                        case "72":
                            zzh += "^";
                            break;
                        // case "73":zzh +="……";break;
                        case "74":
                            zzh += "&";
                            break;
                        case "75":
                            zzh += "*";
                            break;
                        case "76":
                            zzh += "(";
                            break;
                        case "77":
                            zzh += "（";
                            break;
                        case "78":
                            zzh += ")";
                            break;
                        case "79":
                            zzh += "）";
                            break;
                        case "80":
                            zzh += "-";
                            break;
                        case "81":
                            zzh += "_";
                            break;
                        //case "82":zzh +="——";break;
                        case "83":
                            zzh += "=";
                            break;
                        case "84":
                            zzh += "+";
                            break;
                        case "85":
                            zzh += "/";
                            break;
                        case "86":
                            zzh += "[";
                            break;
                        case "87":
                            zzh += "【";
                            break;
                        case "88":
                            zzh += "{";
                            break;
                        case "89":
                            zzh += "]";
                            break;
                        case "90":
                            zzh += "】";
                            break;
                        case "91":
                            zzh += "}";
                            break;
                        case "92":
                            zzh += "\\";
                            break;
                        case "93":
                            zzh += "、";
                            break;
                        case "94":
                            zzh += "|";
                            break;
                        case "95":
                            zzh += ";";
                            break;
                        case "96":
                            zzh += "；";
                            break;
                        case "97":
                            zzh += ":";
                            break;
                        case "98":
                            zzh += "：";
                            break;
                        case "99":
                            zzh += "\'";
                            break;
                    }

                    sy += 2;
                }
                if (fg.equals("3")) {//分割数为3
                    String z = "";
                    for (int i = sy; i < sy + 3; i++) {
                        z += zh6[i];
                    }
                    switch (z) {
                        case "100":
                            zzh += "’";
                            break;
                        case "101":
                            zzh += "\"";
                            break;
                        case "102":
                            zzh += "“";
                            break;
                        case "103":
                            zzh += ",";
                            break;
                        case "104":
                            zzh += "，";
                            break;
                        case "105":
                            zzh += "<";
                            break;
                        case "106":
                            zzh += "《";
                            break;
                        case "107":
                            zzh += ".";
                            break;
                        case "108":
                            zzh += "。";
                            break;
                        case "109":
                            zzh += ">";
                            break;
                        case "110":
                            zzh += "》";
                            break;
                        case "111":
                            zzh += "?";
                            break;
                        case "112":
                            zzh += "？";
                            break;
                    }

                    sy += 3;

                }

            }

        } catch (IOException throwables) {
            throwables.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException throwables) {
                    throwables.printStackTrace();
                }
            }

        }

        /*
        以下是按钮面板的设置
         */
        JPanel jp1 = new JPanel();
        jp1.setLayout(null);
        jp1.setBounds(0, 0, 160, 600);
        JLabel jl = new JLabel();
        jl.setBounds(150, 0, 10, 600);
        Icon i2 = new ImageIcon("Picture/界限.png");
        jl.setIcon(i2);
        jp1.add(jl);
        c[0].add(jp1);
         /*
        以下是程序活动显示面板的设置//*******用一张透明图片覆盖覆盖，达到文字颜色的效果
*/
        Icon i4 = new ImageIcon("Picture/透明图.png");
        JLabel jl2 = new JLabel();
        jl2.setBounds(10, 338, 130, 218);
        jl2.setIcon(i4);
        jp1.add(jl2);
        JTextArea ta1 = new JTextArea("这是程序的活动日志");
        ta1.setFont(new Font("宋体", Font.BOLD, 14));
        JScrollPane sp1 = new JScrollPane();
        //ta1.setEnabled(false);
        sp1.setViewportView(ta1);//*******注意:将文本域对象直接当做参数放入会造成文本域锁定
        sp1.setBounds(10, 338, 130, 218);
        jp1.add(sp1);

        /**
         以下是执行面板的设置
         */
        JPanel jp = new JPanel();
        jp.setLayout(null);
        jp.setBounds(160, 0, 540, 600);
        JLabel jl1 = new JLabel("欢迎使用,");
        jl1.setFont(new Font("微软雅黑", Font.BOLD, 35));
        jl1.setBounds(100, 200, 520, 220);
        jp.add(jl1);
        jlz = new JLabel(zzh);
        jlz.setFont(new Font("微软雅黑", Font.BOLD, 35));
        jlz.setBounds(190, 260, 520, 220);
        jp.add(jlz);

        c[0].add(jp);
        /**
         以下是词库搜索框的设置
         */
        jb5 = new JButton();
        jb5.setBounds(5, 2, 50, 50);
        jb5.setToolTipText("点击搜索单词");
        Icon i6 = new ImageIcon("Picture/搜索图标.png");
        jb5.setIcon(i6);
        jp.add(jb5);
        JTextField tf = new JTextField();
        tf.setBounds(100, 120, 288, 29);
        tf.setFont(new Font("宋体", Font.BOLD, 28));
        tf3 = tf;
        JLabel jl3 = new JLabel("从词库搜索");
        jl3.setBounds(120, 78, 188, 30);
        jl3.setFont(new Font("宋体", Font.BOLD, 28));
        jl7 = jl3;

        jb5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jp.removeAll();
                JTextArea ta = new JTextArea();
                JScrollPane sp = new JScrollPane(ta);
                sp.setViewportView(ta);
                ta.setBounds(22, 173, 468, 378);
                ta.setFont(new Font("宋体", Font.BOLD, 18));
                sp.setBounds(22, 173, 468, 378);
                sp2 = sp;
                jp.add(sp);//先创建对象，过会再加入会造成文本域无法输入的情况*******
                jp.add(jb5);//将自己清除再添加，可以形成连点，但是没有闪动效果
                jp.add(tf);//添加搜索框
                jp.add(jl3);//添加“从词库搜索”
                jp.add(jb6);//标签
                String url = "jdbc:mysql://127.0.0.1:3306/word";
                String use = "root";
                String pw = "123456";

                tf.requestFocus();
                tf.addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {

                    }

                    @Override
                    public void keyPressed(KeyEvent e) {

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {//按键被释放触发
                        String s = tf.getText().replaceAll("\\s", "");//获取用户输入并保存为s
                        String sql = "select word,Chinese from " + zzh + "w " + "where word regexp '" + s + "' order by word";
                        ta.setText("");
                        Connection co = null;
                        Statement st = null;
                        ResultSet rs = null;
                        boolean b2 = false;//查询时，是否成功连接词库,成功后赋予true
                        int i = 0;
                        try {
                            co = DriverManager.getConnection(url, use, pw);//连接数据库
                            st = co.createStatement();
                            rs = st.executeQuery(sql);//用正则表达式查询，并返回查询结果
                            b2 = true;
                            while (rs.next()) {
                                i++;
                                ta.append(i + " " + rs.getString("word"));
                                ta.append(" " + rs.getString("Chinese") + " ");

                                if (i % 4 == 0) {
                                    ta.append("\n");
                                }
                                ta.repaint();
                            }
                            JLabel jl = new JLabel("（本次共查询到" + i + "个单词）");
                            jl.setBounds(288, 79, 288, 16);
                            jl.setFont(new Font("宋体", Font.BOLD, 16));
                            jl.setBackground(Color.pink);
                            jp.removeAll();
                            jp.add(tf);//搜索框
                            jp.add(sp);//显示框
                            jp.add(jb5);//搜索按钮
                            jp.add(jl3);//添加“从词库搜索”
                            jp.add(jb6);//标签
                            jp.add(jl);
                            tf.requestFocus();
                            jp.repaint();
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        } finally {
                            if (b2 == false) {//数据库连接失败
                                ta.append("网络错误或空白查询");
                                ta.repaint();

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
                });

                jp.repaint();
            }
        });
        /**
         * 以下是标签的设置
         */
        jb6 = new JButton();
        Icon i7 = new ImageIcon("Picture/标签.png");
        jb6.setIcon(i7);
        jb6.setBounds(70, 2, 50, 50);
        jp.add(jb6);
        jb6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jp.removeAll();
                jp.add(jb5);//添加搜索按钮
                jp.add(jb6);
                /**
                 * 新建标签页的设置
                 */

                JLabel jl = new JLabel("+新建标签");
                jl.setBounds(28, 158, 188, 30);
                jl.setFont(new Font("宋体", Font.BOLD, 20));
                jl.setToolTipText("新建标签");
                jp.add(jl);
                jl.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {//鼠标点击触发
                        Frame1 frame1 = new Frame1();
                        frame1.setBounds(0, 0, 0, 0);
                        frame1.setVisible(false);
                        new Dialog(frame1);

                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {//鼠标进入触发
                        jl.setText(" 新建标签");
                        jp.repaint();

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {//鼠标离开触发
                        jl.setText("+新建标签");
                        jp.repaint();

                    }
                });
                /**
                 * 添加单词到已有标签的设置
                 */
                JLabel jl1 = new JLabel("★☆更新单词");
                jl1.setBounds(28, 200, 188, 30);
                jl1.setFont(new Font("宋体", Font.BOLD, 20));
                jl1.setToolTipText("更新单词的状态");
                jp.add(jl1);
                jl1.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {//鼠标点击触发
                        jb5.doClick();

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
                        jl1.setText("    更新单词");
                        jp.repaint();

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {//鼠标离开触发
                        jl1.setText("★☆更新单词");
                        jp.repaint();

                    }
                });
                /**
                 * 从标签页中查询单词的设置
                 */
                JLabel jl2 = new JLabel("[放大镜]查询标签");
                jl2.setBounds(28, 242, 188, 30);
                jl2.setFont(new Font("宋体", Font.BOLD, 20));
                jl2.setToolTipText("从已有标签中查询单词");
                jp.add(jl2);
                jl2.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {//鼠标点击触发
                        new Dialog2();

                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {//鼠标进入触发
                        jl2.setText("        查询标签");
                        jp.repaint();

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {//鼠标离开触发
                        jl2.setText("[放大镜]查询标签");
                        jp.repaint();

                    }
                });

                jp.repaint();
            }
        });

        /**
         以下是一键返回主界面按钮的设置
         */
        JButton jb4 = new JButton();
        jb4.setToolTipText("一键返回主界面");
        jb4.setBounds(0, 0, 150, 31);
        Icon i5 = new ImageIcon("Picture/一键返回主界面.png");
        jb4.setIcon(i5);
        jp1.add(jb4);
        jb4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jp.removeAll();
                jp.add(jl1);
                jp.add(jb5);
                jp.add(jb6);
                jp.add(jlz);
                jp.repaint();
            }
        });

        /*
        以下是词库按钮的设置
         */
        JButton jb = new JButton();
        jb.setBounds(30, 44, 100, 50);
        Icon i1 = new ImageIcon("Picture/词库.png");
        jb.setIcon(i1);
        jb.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jp.removeAll();
                JLabel jl = new JLabel("以下是词库中的全部单词");
                jl.setBounds(25, 25, 588, 35);
                jl.setFont(new Font("宋体", Font.BOLD, 24));
                jp.add(jl);
                String url = "jdbc:mysql://127.0.0.1:3306/word";
                String use = "root";
                String pw = "123456";
                String sql = "select * from " + zzh + "w";

                // List i = new ArrayList();//id的集合
                /*
                 *******:数据库无ID设置时，新加入的数据是加在最前面的
                 */
                List w = new ArrayList();//单词的集合
                List C = new ArrayList();//中文的集合***注意:此处C是大写
                Connection co = null;
                Statement st = null;
                ResultSet rs = null;
                boolean b3 = false;//查询时，是否成功连接词库(总显示),成功后赋予true
                //
                try {
                    co = DriverManager.getConnection(url, use, pw);//连接数据库
                    st = co.createStatement();
                    rs = st.executeQuery(sql);
                    b3 = true;
                    while (rs.next()) {
                        // i.add(rs.getInt("id"));//获取数据库内id，并保存为i
                        w.add(rs.getString("word"));//获取单词，并保存到w集合中，做到ID重排，用户删除单词和测验可方便
                        C.add(rs.getString("Chinese"));//获取中文，并保存到C集合中，做到ID重排，用户删除单词和测验可方便
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } finally {
                    if (b3 == false) {
                        jp.removeAll();
                        JLabel jl1 = new JLabel("网络错误");
                        jl1.setForeground(Color.red);
                        jl1.setBounds(250, 199, 288, 30);
                        jl1.setFont(new Font("宋体", Font.BOLD, 30));
                        jp.add(jl1);
                        jp.repaint();

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
                //

                JTextArea ta = new JTextArea();//将数据库中获得的数据写入文本域
                int w1 = 0;//单词集合的索引
                int w2;//单词的影子id
                if (!w.isEmpty()) {//如果集合中有值，则循环添加到文本域
                    for (w2 = 0; w2 < w.size(); w1++) {
                        w2++;
                        ta.append(String.valueOf(w2) + " " + String.valueOf(w.get(w1)) + " " + String.valueOf(C.get(w1)) + "  ");//集合中的值为Object值，添加到文本域中的值应为String值
                        //切换界面已设置重画，如果在同一界面中添加并且查询，必须在此处再设置重画
                        String s1 = String.valueOf(w.get(w1));
                        if (w2 % 4 == 0) {
                            ta.append("\n");//如果单词数到4个，就换行，保持面板整洁
                        }
                    }

                }

                ta.setBounds(15, 88, 490, 450);
                ta.setEnabled(false);
                ta.setFont(new Font("宋体", Font.BOLD, 18));
                JScrollPane sp = new JScrollPane(ta);
                sp.setBounds(15, 88, 490, 450);
                jp.add(sp);
                jp.repaint();

            }
        });
        jp1.add(jb);
        /*
        以下是添加按钮的设置****不要随意改掉变量名，否则idea会自匹配最近的对象，导致巨大错乱
         */
        JButton jb1 = new JButton();
        jb1.setBounds(30, 124, 100, 50);
        Icon i3 = new ImageIcon("Picture/添加.png");
        jb1.setIcon(i3);
        jl4 = new JLabel("请在下方文本框中输入要添加的单词和中文");
        jl4.setBounds(20, 22, 500, 25);
        jl4.setFont(new Font("宋体", Font.BOLD, 25));

        jl5 = new JLabel("单词:");
        jl5.setBounds(55, 122, 100, 30);
        jl5.setFont(new Font("宋体", Font.BOLD, 30));

        jl6 = new JLabel("中文:");
        jl6.setBounds(55, 199, 100, 30);
        jl6.setFont(new Font("宋体", Font.BOLD, 30));

        jb1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final boolean[] c = new boolean[1];//关于ADD按钮的释放
                final boolean[] d = new boolean[1];
                jp.removeAll();
                //标题
                jp.add(jl4);
                //单词框
                JTextField tf = new JTextField();
                tf1 = tf;
                tf.setBounds(150, 122, 310, 35);
                tf.setFont(new Font("宋体", Font.BOLD, 35));
                tf.requestFocus();
                jp.add(tf);
                jp.add(jl5);
                //中文框
                JTextField tf1 = new JTextField();
                tf2 = tf1;
                tf1.setBounds(150, 199, 310, 35);
                tf1.setFont(new Font("宋体", Font.BOLD, 35));
                jp.add(tf1);
                jp.add(jl6);
                //Add按钮*****将该按钮定义为全局变量会造成巨大错误
                JButton jb = new JButton("Add");
                jb7 = jb;
                jb.setBounds(166, 288, 150, 35);
                jb.setFont(new Font("宋体", Font.BOLD, 35));
                boolean b = false;//按钮锁定，防止载入空值
                jb.setEnabled(b);

                //单词框的键盘监听，当两框同时准备就绪才能释放按钮
                tf.addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {

                    }

                    @Override
                    public void keyPressed(KeyEvent e) {//键盘释放触发，检测单词框是否为空，单词框和中文框均有值才能解锁按钮
                        int a = e.getKeyCode();
                        if (a == 10) {
                            jb.doClick();
                            return;
                        }

                        String s = tf.getText().trim();
                        switch (a) {
                            case 96:
                                a = 48;
                                break;//由于键盘实际录入与提供值不一，但是是唯一的，这是0
                            case 97:
                                a = 49;
                                break;//由于键盘实际录入与提供值不一，但是是唯一的，这是1
                            case 98:
                                a = 50;
                                break;//由于键盘实际录入与提供值不一，但是是唯一的，这是2
                            case 99:
                                a = 51;
                                break;//由于键盘实际录入与提供值不一，但是是唯一的，这是3
                            case 100:
                                a = 52;
                                break;//由于键盘实际录入与提供值不一，但是是唯一的，这是4
                            case 101:
                                a = 53;
                                break;//由于键盘实际录入与提供值不一，但是是唯一的，这是5
                            case 102:
                                a = 54;
                                break;//由于键盘实际录入与提供值不一，但是是唯一的，这是6
                            case 103:
                                a = 55;
                                break;//由于键盘实际录入与提供值不一，但是是唯一的，这是7
                            case 104:
                                a = 56;
                                break;//由于键盘实际录入与提供值不一，但是是唯一的，这是8
                            case 105:
                                a = 57;
                                break;//由于键盘实际录入与提供值不一，但是是唯一的，这是9

                        }
                        boolean b1;//按钮的锁定判断
                        switch (a) {
                            case VK_SPACE://空格键的监听
                            case VK_0://0~9;A~Z的监听
                            case VK_1:
                            case VK_2:
                            case VK_3:
                            case VK_4:
                            case VK_5:
                            case VK_6:
                            case VK_7:
                            case VK_8:
                            case VK_9:
                            case VK_A:
                            case VK_B:
                            case VK_C:
                            case VK_D:
                            case VK_E:
                            case VK_F:
                            case VK_G:
                            case VK_H:
                            case VK_I:
                            case VK_J:
                            case VK_K:
                            case VK_L:
                            case VK_M:
                            case VK_N:
                            case VK_O:
                            case VK_P:
                            case VK_Q:
                            case VK_R:
                            case VK_S:
                            case VK_T:
                            case VK_U:
                            case VK_V:
                            case VK_W:
                            case VK_X:
                            case VK_Y:
                            case VK_Z:
                                if (s == "") {//若单词框为空，则b1为false
                                    b1 = false;
                                    c[0] = false;

                                } else {//若单词框不为空，则b1位true，表示单词框已准备就绪
                                    b1 = true;
                                    c[0] = true;

                                }
                        }//switch
                        //在单词框上做操作时，动作结束，就判断一次
                        if (c[0] == true & d[0] == true) {//若两框都准别就绪，则释放按钮
                            jb.setEnabled(true);
                        } else {//否则锁定
                            jb.setEnabled(false);
                        }
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                });
                //中文框的键盘监听

                tf1.addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {

                    }

                    @Override
                    public void keyPressed(KeyEvent e) {//键盘释放触发，检测单词框是否为空，单词框和中文框均有值才能解锁按钮
                        if (e.getKeyChar() == '\n') {
                            jb.doClick();
                        }
                        int a = e.getExtendedKeyCode();
                        char c1 = e.getKeyChar();
                        String s = tf1.getText().trim();
                        switch (a) {
                            case 96:
                                a = 48;
                                break;//由于键盘实际录入与提供值不一，但是是唯一的，这是0
                            case 97:
                                a = 49;
                                break;//由于键盘实际录入与提供值不一，但是是唯一的，这是1
                            case 98:
                                a = 50;
                                break;//由于键盘实际录入与提供值不一，但是是唯一的，这是2
                            case 99:
                                a = 51;
                                break;//由于键盘实际录入与提供值不一，但是是唯一的，这是3
                            case 100:
                                a = 52;
                                break;//由于键盘实际录入与提供值不一，但是是唯一的，这是4
                            case 101:
                                a = 53;
                                break;//由于键盘实际录入与提供值不一，但是是唯一的，这是5
                            case 102:
                                a = 54;
                                break;//由于键盘实际录入与提供值不一，但是是唯一的，这是6
                            case 103:
                                a = 55;
                                break;//由于键盘实际录入与提供值不一，但是是唯一的，这是7
                            case 104:
                                a = 56;
                                break;//由于键盘实际录入与提供值不一，但是是唯一的，这是8
                            case 105:
                                a = 57;
                                break;//由于键盘实际录入与提供值不一，但是是唯一的，这是9

                        }
                        boolean b2;//按钮的锁定判断
                        switch (a) {

                            case VK_SPACE://空格键的监听
                            case VK_0://0~9;A~Z的监听
                            case VK_1:
                            case VK_2:
                            case VK_3:
                            case VK_4:
                            case VK_5:
                            case VK_6:
                            case VK_7:
                            case VK_8:
                            case VK_9:
                            case VK_A:
                            case VK_B:
                            case VK_C:
                            case VK_D:
                            case VK_E:
                            case VK_F:
                            case VK_G:
                            case VK_H:
                            case VK_I:
                            case VK_J:
                            case VK_K:
                            case VK_L:
                            case VK_M:
                            case VK_N:
                            case VK_O:
                            case VK_P:
                            case VK_Q:
                            case VK_R:
                            case VK_S:
                            case VK_T:
                            case VK_U:
                            case VK_V:
                            case VK_W:
                            case VK_X:
                            case VK_Y:
                            case VK_Z:
                                if (s == "") {//若单词框为空，则b1为false
                                    b2 = false;
                                    d[0] = false;

                                } else {//若单词框不为空，则b1位true，表示单词框已准备就绪
                                    b2 = true;
                                    d[0] = true;
                                }
                        }//switch

                        //在单词框上做操作时，动作结束，就判断一次
                        if (c[0] == true & d[0] == true) {//若两框都准别就绪，则释放按钮
                            jb.setEnabled(true);
                        } else {//否则锁定
                            jb.setEnabled(false);
                        }

                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                });
                jb.addActionListener(new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        boolean b1 = false;//是否添加成功,默认为false（失败），成功后赋予true
                        String s = tf.getText().trim();//获取单词框单词，保存为s
                        String s1 = tf1.getText().trim();//获取中文框中文，保存为s1
                        tf.setText("");
                        tf1.setText("");
                        tf.requestFocus();
                        String url = "jdbc:mysql://127.0.0.1:3306/word";
                        String use = "root";
                        String pw = "123456";
                        Connection co = null;
                        Statement st = null;
                        try {
                            Class.forName("com.mysql.jdbc.Driver");
                            co = DriverManager.getConnection(url, use, pw);//连接数据库
                            st = co.createStatement();
                            st.executeUpdate("INSERT INTO " + zzh + "w VALUES('" + s + "','" + s1 + "')");//将数据保存到数据库,改行出错，词库里已有该值
                            //*****空值判断为有值******
                            i++;
                            ta1.append("\n");
                            ta1.append("#" + i + "\n");
                            ta1.append("添加成功" + " 添加 " + s);
                            b1 = true;
                            ta1.selectAll();
                            ta1.repaint();

                        } catch (SQLException | ClassNotFoundException classNotFoundException) {
                            classNotFoundException.printStackTrace();
                        } finally {
                            if (b1 == false) {//添加失败,finally下必执行
                                i++;
                                ta1.append("\n");
                                ta1.append("#" + i + "\n");
                                ta1.append("添加失败" + "\n" + "请检查网络及是否重复添加");
                                ta1.selectAll();
                                ta1.repaint();

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
                });

                jp.add(jb);

                //重画
                jp.repaint();
            }
        });
        jp1.add(jb1);
        /*
        以下是删除按钮的设置
         */
        JButton jb2 = new JButton("删除");
        jb2.setBounds(30, 203, 100, 50);
        jb2.setFont(new Font("宋体", Font.BOLD, 20));
        jb2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jp.removeAll();
                //标题
                JLabel jl = new JLabel("将要删除的单词写入下面的文本框");
                jl.setBounds(20, 22, 500, 25);
                jl.setFont(new Font("宋体", Font.BOLD, 25));
                jp.add(jl);
                //文本框
                JTextField tf = new JTextField();
                tf.setBounds(150, 122, 310, 35);
                tf.setFont(new Font("宋体", Font.BOLD, 35));
                jp.add(tf);
                tf.requestFocus();//加在载入之后才行
                JLabel jl1 = new JLabel("单词:");
                jl1.setBounds(55, 122, 100, 30);
                jl1.setFont(new Font("宋体", Font.BOLD, 30));
                jp.add(jl1);
                //DELETE按钮
                JButton jb = new JButton("DELETE");
                jb.setBounds(178, 258, 150, 35);
                jb.setFont(new Font("宋体", Font.BOLD, 35));
                jp.add(jb);
                tf.addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {

                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                        if (e.getKeyChar() == '\n') {
                            jb.doClick();
                        }
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {

                    }
                });
                jb.addActionListener(new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        boolean b4 = false;//删除时，是否成功连接数据库,成功后赋予true
                        String s = tf.getText().trim();//获取文本框内容，并保存为s
                        String url = "jdbc:mysql://127.0.0.1:3306/word";
                        String use = "root";
                        String pw = "123456";
                        Connection co = null;
                        Statement st = null;
                        try {
                            Class.forName("com.mysql.jdbc.Driver");
                            co = DriverManager.getConnection(url, use, pw);//连接数据库
                            st = co.createStatement();
                            st.executeUpdate("DELETE FROM " + zzh + "w WHERE word='" + s + "'");
                            b4 = true;
                            i++;
                            ta1.append("\n");
                            ta1.append("#" + i + "\n");
                            ta1.append("删除成功" + " 删除 " + s);
                            ta1.selectAll();
                            ta1.repaint();
                            tf.setText("");
                            tf.requestFocus();
                        } catch (ClassNotFoundException | SQLException classNotFoundException) {
                            classNotFoundException.printStackTrace();
                        } finally {
                            if (b4 == false) {
                                i++;
                                ta1.append("\n");
                                ta1.append("#" + i + "\n");
                                ta1.append("删除失败" + "\n" + "网络错误或词库无该词");
                                ta1.selectAll();
                                ta1.repaint();
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
                });

                jp.repaint();
            }
        });

        jp1.add(jb2);
        /*
        以下是测试按钮的设置
         */
        JButton jb3 = new JButton();
        Icon ic = new ImageIcon("Picture/测试.png");
        jb3.setIcon(ic);
        jb3.setBounds(30, 280, 100, 50);
        jb3.setFont(new Font("宋体", Font.BOLD, 20));
        jb3.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jp.removeAll();
                //选择按钮

                JRadioButton rb = new JRadioButton("单词模式（给中文，写单词）");
                JRadioButton rb1 = new JRadioButton("中文模式（给单词，写中文）");
                rb.setBounds(66, 150, 238, 25);
                rb1.setBounds(66, 200, 238, 25);
                rb.setFont(new Font("宋体", Font.BOLD, 15));
                rb1.setFont(new Font("宋体", Font.BOLD, 15));
                ButtonGroup bg = new ButtonGroup();//按钮组，达到单选结果
                bg.add(rb);
                bg.add(rb1);
                rb.setSelected(true);//默认选中单词模式
                jp.add(rb);
                jp.add(rb1);
                //开始按钮
                JButton jb = new JButton("开始测试");
                jb.setBounds(12, 12, 200, 50);
                jb.setFont(new Font("宋体", Font.BOLD, 25));
                jp.add(jb);
                //“模式选择”
                JLabel jl = new JLabel();
                jl.setBounds(45, 100, 300, 160);
                Icon i1 = new ImageIcon("Picture/模式选择.png");
                jl.setIcon(i1);
                jp.add(jl);
                /**
                 * 连接多个数据库的设置
                 */
                List l = new ArrayList();//放置tip名
                boolean b = false;//数据库查询tip名是否成功，默认为false（失败），成功后赋予true
                String url = "jdbc:mysql://127.0.0.1:3306/tipname";//连接tipname数据库
                String use = "root";
                String pw = "123456";
                String sql = "select * from " + zzh + "t";//在tipname库中查询tip名
                Connection co = null;
                Statement st = null;
                ResultSet rs = null;
                String sg = "";//记录格式化的标签名
                try {
                    co = DriverManager.getConnection(url, use, pw);//连接数据库
                    st = co.createStatement();
                    rs = st.executeQuery(sql);
                    b = true;
                    while (rs.next()) {
                        sg = rs.getString(1);
                        sg = sg.substring(0, sg.length() - 1);
                        sg = sg.substring(zzh.length() + 3, sg.length());
                        l.add("（标签）" + " " + sg);
                    }

                    String sn[] = new String[l.size()];
                    for (int k1 = 0; k1 < l.size(); k1++) {
                        sn[k1] = String.valueOf(l.get(k1));
                    }
                    JList<String> jll = new JList<>(sn);
                    jll1 = jll;
                    JScrollPane sp = new JScrollPane(jll);
                    jll.setBounds(25, 288, 450, 250);
                    sp.setBounds(25, 288, 450, 250);
                    sp.setFont(new Font("宋体", Font.BOLD, 20));
                    jp.add(sp);

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } finally {
                    if (b == false) {
                        JLabel jl1 = new JLabel("查询失败");
                        jl1.setBounds(280, 280, 155, 30);
                        jl1.setFont(new Font("宋体", Font.BOLD, 20));
                        jl1.setForeground(Color.red);
                        jp.add(jl1);
                        jp.repaint();

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

                jb.addActionListener(new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        boolean b7 = true;//是否需要连接词库，默认true，需要,选择标签后改为false
                        boolean b5 = false;//词库是否为空的测试，默认为false（空），有词则赋予true
                        boolean b6 = false;
                        List d = new ArrayList();//单词集合,从数据库中读取并保存到此
                        List C = new ArrayList();//中文集合,从数据库中读取并保存到此 C是大写
                        i++;
                        ta1.append("\n");
                        ta1.append("#" + i + "\n");
                        if (rb.isSelected()) {
                            ta1.append("单词模式（写单词）");
                        }
                        if (rb1.isSelected()) {
                            ta1.append("中文模式（写中文）");

                        }
                        ta1.selectAll();
                        ta1.repaint();
                        /**
                         * 检测需要连接哪些数据库
                         */
                        String fs = "";//记录还原名字的标签名
                        List<String> bn = jll1.getSelectedValuesList();//获取选择的标签名
                        List<String> bn1 = new ArrayList<>();//记录所有还原后的标签名
                        for (String o : bn) {
                            fs = "z" + zzh + "hb" + o + "q";
                            bn1.add(fs);
                        }
                        if (bn1.size() != 0) {//非默认测试词库
                            b7 = false;
                            for (String o1 : bn1) {
                                Connection co = null;
                                Statement st = null;
                                ResultSet rs = null;
                                String url = "jdbc:mysql://127.0.0.1:3306/tip";
                                String use = "root";
                                String pw = "123456";
                                String sql = "select * from " + "z" + zzh + "hb" + o1.substring(zzh.length() + 8, o1.length() - 1) + "q";
                                try {
                                    co = DriverManager.getConnection(url, use, pw);//连接数据库
                                    st = co.createStatement();
                                    rs = st.executeQuery(sql);
                                    while (rs.next()) {
                                        d.add(rs.getString("word"));
                                        C.add(rs.getString("Chinese"));
                                    }
                                    ta1.append("\n测试:" + o1.substring(zzh.length() + 8, o1.length() - 1));
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

                            }
                        }

                        /**
                         * 默认连接词库
                         */
                        if (b7) {
                            Connection co = null;
                            Statement st = null;
                            ResultSet rs = null;
                            String url = "jdbc:mysql://127.0.0.1:3306/word";
                            String use = "root";
                            String pw = "123456";
                            String sql = "select * from " + zzh + "w";
                            try {
                                co = DriverManager.getConnection(url, use, pw);//连接数据库
                                st = co.createStatement();
                                rs = st.executeQuery(sql);
                                b6 = true;
                                while (rs.next()) {
                                    d.add(rs.getString("word"));
                                    C.add(rs.getString("Chinese"));
                                }
                                ta1.append("\n测试:词库");
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            } finally {
                                if (b6 == false) {
                                    jp.removeAll();
                                    JLabel jl1 = new JLabel("网络错误");
                                    jl1.setBounds(150, 200, 388, 30);
                                    jl1.setForeground(Color.red);
                                    jl1.setFont(new Font("宋体", Font.BOLD, 28));
                                    jp.add(jl1);
                                    jp.repaint();
                                    return;
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

                        sl = d.size();
                        jp.removeAll();
                        JLabel jl = new JLabel("题目:XXXXXXXX（请将答案输入下面的文本框中）");//初始化题目
                        jl.setBounds(30, 20, 550, 50);
                        jl.setFont(new Font("宋体", Font.BOLD, 20));
                        jp.add(jl);
                        JTextField tf = new JTextField();//答案框
                        tf.setBounds(20, 118, 200, 35);
                        tf.setFont(new Font("宋体", Font.BOLD, 35));
                        jp.add(tf);
                        jp.repaint();
                        Random r = new Random();//开始测试负责给出第一个题目
                        int c;//单词模式的对应随机数(第一次)
                        int d1;//中文模式的对应随机数(第一次)
                        if (rb.isSelected()) {//选择单词模式
                            if (C.size() == 0) {
                                jp.removeAll();
                                JLabel jl1 = new JLabel("词库或标签为空");
                                jl1.setBounds(150, 200, 388, 30);
                                jl1.setForeground(Color.red);
                                jl1.setFont(new Font("宋体", Font.BOLD, 28));
                                jp.add(jl1);
                                JButton jb = new JButton("去添加！！！");
                                jb.setFont(new Font("宋体", Font.BOLD, 22));
                                jb.setBounds(180, 288, 250, 35);
                                jp.add(jb);
                                jp.repaint();
                                jb.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        jp.removeAll();
                                        jp.add(jl4);
                                        jp.add(jl5);
                                        jp.add(jl6);
                                        jp.add(tf1);
                                        jp.add(tf2);
                                        jp.add(jb7);
                                        tf1.requestFocus();
                                        jp.repaint();
                                    }
                                });
                                return;

                            }
                            c = r.nextInt(C.size());
                            q = c;//将c赋值给全局变量
                            jl.setText("题目:" + C.get(c) + "（请写出该中文对应的单词，并写入下方）");
                            jp.repaint();
                        }
                        if (rb1.isSelected()) {//选择中文模式
                            if (C.size() == 0) {
                                jp.removeAll();
                                JLabel jl1 = new JLabel("词库或标签为空");
                                jl1.setBounds(150, 200, 388, 30);
                                jl1.setForeground(Color.red);
                                jl1.setFont(new Font("宋体", Font.BOLD, 28));
                                jp.add(jl1);
                                JButton jb = new JButton("去添加！！！");
                                jb.setFont(new Font("宋体", Font.BOLD, 22));
                                jb.setBounds(180, 288, 250, 35);
                                jp.add(jb);
                                jp.repaint();
                                jb.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        jp.removeAll();
                                        jp.add(jl4);
                                        jp.add(jl5);
                                        jp.add(jl6);
                                        jp.add(tf1);
                                        jp.add(tf2);
                                        jp.add(jb7);
                                        tf1.requestFocus();
                                        jp.repaint();
                                    }
                                });
                                jp.repaint();
                                return;

                            }
                            d1 = r.nextInt(d.size());
                            w = d1;//将d1赋值给全局变量
                            jl.setText("题目:" + d.get(d1) + "（请写出该单词对应的中文意思，并写入下方）");
                            jp.repaint();

                        }
                        //以下是确定按钮的设置
                        JButton jb = new JButton("确定");
                        jb.setFont(new Font("宋体", Font.BOLD, 30));
                        jb.setBounds(188, 288, 158, 50);
                        jp.add(jb);
                        tf.addKeyListener(new KeyListener() {
                            @Override
                            public void keyTyped(KeyEvent e) {

                            }

                            @Override
                            public void keyPressed(KeyEvent e) {
                                if (e.getKeyChar() == '\n') {
                                    jb.doClick();
                                }

                            }

                            @Override
                            public void keyReleased(KeyEvent e) {

                            }
                        });
                        List cw = new ArrayList();//错误单词集合******不能放在监听事件内，不然每次点确定都会初始化集合
                        List cw1 = new ArrayList();//错误单词中文集合
                        jb.addActionListener(new AbstractAction() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String s = tf.getText().trim();//获取答案，并保存为s
                                boolean b = rb.isSelected();//如果是单词模式。则为true
                                boolean b1 = rb1.isSelected();//如果是中文模式。则为true
                                Random r = new Random();
                                int a;
                                if (b) {//单词模式
                                    if (!C.isEmpty()) {
                                        if (s.equals(d.get(q))) {//
                                            i++;
                                            ta1.append("\n");
                                            ta1.append("#" + i + "\n");
                                            ta1.append("正确");
                                            ta1.selectAll();
                                            C.remove(q);
                                            d.remove(q);
                                            tf.setText("");
                                            tf.requestFocus();
                                            if (!C.isEmpty()) {
                                                a = r.nextInt(C.size());
                                                q = a;
                                                jl.setText("题目:" + C.get(a) + "（请写出该单词对应的中文意思，并写入下方）");
                                                jp.repaint();
                                            } else {//如果是空的
                                                i++;
                                                ta1.append("\n");
                                                ta1.append("#" + i + "\n");
                                                ta1.append("测试完成！");
                                                ta1.append("\n");
                                                ta1.append("本次测试结果:" + "\n" + "共测试" + sl + "个单词,错" + cw.size() + "次");
                                                if (!cw.isEmpty()) {//有错误单词
                                                    for (int i = 0; i < cw.size(); i++) {
                                                        ta1.append("\n");
                                                        ta1.append("（错）" + cw.get(i) + " " + cw1.get(i));
                                                    }
                                                }

                                                jl.setText("测试完成");
                                                ta1.selectAll();
                                                jp.repaint();

                                            }
                                        } else {
                                            i++;
                                            ta1.append("\n");
                                            ta1.append("#" + i + "\n");
                                            ta1.append("错误" + "单词为:" + d.get(q) + " " + C.get(q));
                                            ta1.append("\n" + "你的答案是:" + s);
                                            ta1.selectAll();
                                            String aa = String.valueOf(d.get(q));
                                            String aa1 = String.valueOf(C.get(q));
                                            cw.add(aa);//记录错误单词
                                            cw1.add(aa1);//记录错误中文
                                            tf.setText("");
                                            a = r.nextInt(C.size());
                                            q = a;
                                            jl.setText("题目:" + C.get(a) + "（请写出该单词对应的中文意思，并写入下方）");
                                            jp.repaint();

                                        }

                                    } else {
                                        i++;
                                        ta1.append("\n");
                                        ta1.append("#" + i + "\n");
                                        ta1.append("已完成测试");
                                        ta1.selectAll();
                                    }
                                } else if (b1) {//中文模式
                                    if (!C.isEmpty()) {
                                        if (s.equals(C.get(w))) {//
                                            i++;
                                            ta1.append("\n");
                                            ta1.append("#" + i + "\n");
                                            ta1.append("正确");
                                            ta1.selectAll();
                                            C.remove(w);
                                            d.remove(w);
                                            tf.setText("");
                                            tf.requestFocus();
                                            if (!d.isEmpty()) {
                                                a = r.nextInt(d.size());
                                                w = a;
                                                jl.setText("题目:" + d.get(a) + "（请写出该单词对应的中文意思，并写入下方）");
                                                jp.repaint();
                                            } else {//如果是空的
                                                i++;
                                                ta1.append("\n");
                                                ta1.append("#" + i + "\n");
                                                ta1.append("测试完成！");
                                                ta1.append("\n");
                                                ta1.append("本次测试结果:" + "\n" + "共测试" + sl + "个单词,错" + cw.size() + "次");
                                                if (!cw.isEmpty()) {//有错误单词
                                                    for (int i = 0; i < cw.size(); i++) {
                                                        ta1.append("\n");
                                                        ta1.append("（错）" + cw.get(i) + " " + cw1.get(i));
                                                    }
                                                }
                                                ta1.selectAll();

                                                jl.setText("测试完成");
                                                jp.repaint();

                                            }
                                        } else {
                                            i++;
                                            ta1.append("\n");
                                            ta1.append("#" + i + "\n");
                                            ta1.append("错误" + "单词为:" + d.get(w) + " " + C.get(w));
                                            ta1.append("\n" + "你的答案是:" + s);
                                            ta1.selectAll();
                                            String aa = String.valueOf(C.get(w));
                                            String aa1 = String.valueOf(d.get(w));
                                            cw.add(aa);//记录错误单词
                                            cw1.add(aa1);//记录错误中文
                                            tf.setText("");
                                            a = r.nextInt(d.size());
                                            w = a;
                                            jl.setText("题目:" + d.get(a) + "（请写出该单词对应的中文意思，并写入下方）");
                                            jp.repaint();

                                        }

                                    } else {
                                        i++;
                                        ta1.append("\n");
                                        ta1.append("#" + i + "\n");
                                        ta1.append("已完成测试");
                                        ta1.selectAll();
                                    }

                                }

                            }
                        });
                    }
                });

                jp.repaint();
            }
        });
        jp1.add(jb3);

        /*
        以下是窗体大小限制及图标的设置
         */
        setResizable(false);
        Image i = Toolkit.getDefaultToolkit().getImage("Picture/改版3窗体图标.png");//获得窗口图标
        setIconImage(i);
        setVisible(true);

    }
}