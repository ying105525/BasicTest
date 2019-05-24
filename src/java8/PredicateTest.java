package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * desc: XXXX
 *
 * @author Ying
 * Date: 2019/3/29
 * @version 1.0.0
 */
public class PredicateTest {

    public static void main(String[] args) {
        int i =1;
        String  a = "aa"+i;
        System.out.println(a);
        List<Person> list = new ArrayList<>();
        for(int k = 0;k<3;k++){
            String idx = k+"aa";
            Person person = new Person();
            person.setName(idx);
            list.add(person);
        }
        Predicate<Integer> predicateInt = x -> x > 10 && x<30;
        Predicate<String> predicateStr = r -> r.length() > 10;
        System.out.println("第一个Predicate的测试，测试数值是否大于10，结果为：" + predicateInt.test(11));
        System.out.println("第二个Predicate的测试，测试字符串的长度是否大于10，结果为：" + predicateStr.test("test"));
        System.out.println("第一个Predicate的【negate方法】测试，测试数值是否大于10，结果为：" + predicateInt.negate().test(11));
        System.out.println("第二个Predicate的【negate方法】测试，测试字符串的长度是否大于10，结果为：" + predicateStr.negate().test("test"));
        System.out.println("第一个Predicate的【and方法】测试，测试数值是否大于10小于20，结果为：" + predicateInt.and(x->x<20).test(11));
        System.out.println("第一个Predicate的【or方法】测试，测试数值是否大于10或小于5，结果为：" + predicateInt.or(x->x<5).test(4));
        System.out.println(Predicate.isEqual(11).test(12));
    }
}
