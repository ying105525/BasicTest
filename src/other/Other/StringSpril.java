package other.Other;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * desc: XXXX
 *
 * @author Ying
 * Date: 2019/4/23
 * @version 1.0.0
 */
public class StringSpril {
//    static final  String  sas = null;
    public static void main(String[] args) {
//        String s = "中国建设银行/山东省/枣庄市/鲁南化肥厂分理处&157/中国建设银行-1014/1225-鲁南化肥厂分理处";
//        String[] ss = s.split("&");
//        String s1 = ss[0].replaceAll("/\\S+/", "");
//        System.out.println(s1);
//        Talk talk = null;
//        talk.speak();

//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        String sb = Arrays.toString(list.toArray());
//        String sb2 = list.toString();
//        System.out.println(sb);
//        System.out.println(sb2);


//        Long id = 123L;
//        String str = String.format("%06d",id);
//        System.out.println(str);
//        Long s = System.currentTimeMillis();
//        System.out.println(s);
//        Long s2 = System.currentTimeMillis();
//        int flag = new Random().nextInt(999999);
//        for(int i=0;i<50;i++){
//            String str1 = String.format("%06d",new Random().nextInt(999999));
//            System.out.println(str1);
//        }
//        SimpleDateFormat sdf=new SimpleDateFormat("MMddhhmmss");
//        System.out.println(sdf.format(new Date()));
//        System.out.println(s2);
//        System.out.println(flag);

        String ip = "10.67.11.1, 127.2.0.0";
        ip = ip.split(",")[0];
        System.out.println(ip);
    }
}
