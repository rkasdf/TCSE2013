package iscas.leetcode.hty.validpalindrome;

import javax.sound.midi.Soundbank;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by hty on 2015/1/16.
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * For the purpose of this problem, we define empty string as valid palindrome.
 */
public class Solution {

//    private Map<Object, Object> rules = new HashMap<Object, Object>();
//    setter & getter ----> from properties

//    public String rexHty(String s) {
//        return _s.replaceAll(getter(rules.key),getter(rules.value));
//    }
//==========================================================================
//    public boolean isPalindrome(String s) {
//        int length = _s.length();
//        for (int i = 0; i < (length / 2); i++) {
//            if (_s.charAt(i) != _s.charAt(length - 1 - i)) {
//                return false;
//            }
//        }
//        return true;
//    }
//============================================================================
//    继承自同一个抽象类，比如StringHty，给出构造方法，所以，先处理字符串这种方法不好
//    isPalindrome(toLowerAlpAndNumber(s));

    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        int length = s.length();
        for (int i = 0; i < (length / 2); i++) {
            if (s.charAt(i) != s.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        /**
         * 1.字符串常量，创建后就不会改变，改变字符串常量，是系统新创建的对象
         */
        String str1 = "A man";
        str1 += " a plan";
        str1 += " a canal";
        //这个时候系统创建了三个对象,以前的两个对象就被回收了,这样效率很低，建议使用
        StringBuffer sb = new StringBuffer("A man");
        sb.append(" a plan");
        //str1 = "A man " + "a plan " + "a canal"；????

        /**
         * 2.常量池：在编译期被确定，并被保存在已编译的.class文件中的
         * 一些数据。它包括了关于类、方法、接口等中的常量，也包括字符串常量。
         *
         * 用new String() 创建的字符串不是常量，不能在编译期就确定，所以new String()
         * 创建的字符串不放入常量池中，它们有自己的地址空间。
         */
        String constant = "A man a plan";
        String obj = new String("A man a plan");
        System.out.println(constant == obj);
        //创建constant的时候，会先去常量池中查找，如果有，则返回该串的引用，
        //如果没有则在常量池中新添加一个
        //创建obj的时候，也会先去常量池中，查找该串，如果没有则创建，并会在heap中再创建一个
        //这就是为什么平时说new String会创建两个对象的原因

        /**
         * 3.intern()方法，返回与常量池中关联的字符串
         */
        String object = new String("A man a plan a canal");
        String intern = object.intern();
        String constant_intern = "A man a plan a canal";
        System.out.println(intern.equals(constant_intern));

        /**
         * 4. String 的equals() & ==
         * equals()方法是判断常量池中，这个字符串是不是完全相等，即转化为一个Unicode码相等的判断
         * == 是判断地址空间是否相同
         */

        /**
         * 5.String是一个不变类，String类中的所有方法都不会改变这个类的状态，
         * 所有返回类型为String的方法，返回的都是一个新对象。
         */
    }
}
