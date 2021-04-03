
import word_Frame.Frame;
import word_Frame.Frame1;

import java.time.Year;

/*
程序接口，程序由此开始
 */
public class Start {
    public static void Start() {
        new Frame();
        //   new Frame1();
    }

    public static void main(String[] args) {
        Start();
        /**
         * @关于数据库在本项目的使用
         * ku:tip、tipname、user、word
         * tip:以账号建立对应表名为最大操作单位（一个及多个）,表用来存储被标记的单词
         * tipname:以账号建立对应表名为最大操作单位（只有一个）,表用来存储该账号下的所有标签名字
         * user:以插入新用户为最大操作单位
         * word:以账号建立对应表名为最大操作单位（只有一个），是词库
         */

    }

}


