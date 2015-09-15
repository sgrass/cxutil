package org.cx.util;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 常用工具方法
 * @author grass
 * @create date Aug 12, 2010
 */
public class CommonBasic {

	/**
   * 将字符串中相连的空格合并成一个空格
   * @param str 源字符串
   * @return 处理后的字符串
   */
  public static String mergeSpace(String str) {
      boolean flag = false;
      StringBuffer sb = new StringBuffer("");
      for (int i = 0; i < str.length(); i++) {
          char ch = str.charAt(i);
          if (Character.isSpaceChar(ch)) {
              if (!flag) {
                  flag = true;
                  sb.append(ch);
              }
          } else {
              flag = false;
              sb.append(ch);
          }
      }
      return new String(sb);
  }
  
  /**
   * 计算字符串的长度, 一个汉字两个字符
   * @param s 字符串
   * @return 长度
   */
  public static int realLength(String s) {
      return s.replaceAll("[^\\x00-\\xff]", "**").length();
  }
  
  /**
   * 将金额数字转换成大写的中文货币表示
   * @param currency 金额
   * @return 金额, 如果金额超过 9999999999999.99 或异常返回 null;
   */
  //改写自 VB Script
  public static String toChineseCapitalCurrencyStyle(double currency) {
      if (currency == 0) {
          return "零元整";
      }
      currency = Math.abs(currency);
      if (currency > 9999999999999.99d) {
          System.err.println(("超出能表示金额的最大范围"));
          return null;
      }
      String string1 = "零壹贰叁肆伍陆柒捌玖";
      String string2 = "万仟佰拾亿仟佰拾万仟佰拾元角分";
      int nZero = 0;

      currency = ((long) (currency * 100)) / 100.0;
      int j = String.valueOf((long) (currency * 100)).length();
      string2 = string2.substring(string2.length() - j);
      String result = "";

      for (int i = 1; i <= j; i++) {
          String ch1 = "", ch2 = "";
          String string3 = String.valueOf((long) (currency * 100)).substring(
                  i - 1, i);
          if (i != j - 2 && i != j - 6 && i != j - 10 && i != j - 14) {
              if (string3.equals("0")) {
                  nZero++;
              } else if (!string3.equals("0") && nZero != 0) {
                  int pos = Integer.parseInt(string3);
                  ch1 = "零" + string1.substring(pos, pos + 1);
                  ch2 = string2.substring(i - 1, i);
                  nZero = 0;
              } else if (!string3.equals("0") && nZero == 0) {
                  int pos = Integer.parseInt(string3);
                  ch1 = string1.substring(pos, pos + 1);
                  ch2 = string2.substring(i - 1, i);
                  nZero = 0;
              }
          } else {
              if (!string3.equals("0") && nZero != 0) {
                  int pos = Integer.parseInt(string3);
                  ch1 = "零" + string1.substring(pos, pos + 1);
                  ch2 = string2.substring(i - 1, i);
                  nZero = 0;
              } else if (!string3.equals("0") && nZero == 0) {
                  int pos = Integer.parseInt(string3);
                  ch1 = string1.substring(pos, pos + 1);
                  ch2 = string2.substring(i - 1, i);
                  nZero = 0;
              } else if (string3.equals("0") && nZero >= 3) {
                  nZero++;
              } else if (string3.equals("0") && nZero < 3) {
                  ch2 = string2.substring(i - 1, i);
                  nZero++;
              }
              if (i == j - 10 || i == j - 2) {
                  ch2 = string2.substring(i - 1, i);
              }
          }
          result += ch1 + ch2;
          if (i == j && string3.equals("0")) {
              result += "整";
          }
      }
      return result;
  }
  
  /**
   * 判断字符串中是否不存在指定字串中的字符
   * @param str 待校验的字符串
   * @param strPattern 不允许出现的字符列表
   * @return 成功返回 true, 异常或失败返回 false
   */
  public static boolean isWithoutDefinitePatternString(String str,
          String strPattern) {
      if (str != null && strPattern != null) {
          for (int i = 0; i < strPattern.length(); i++) {
              if (str.indexOf(strPattern.charAt(i)) >= 0) {
                  return false;
              }
          }
      }
      return true;
  }
  
  /**
   * 字符串用指定的分隔符分隔成多个字符串
   * @param str 源字符串
   * @param ch 分隔符
   * @return 异常返回 null ,成功返回已分隔完的字符串组成的ArrayList
   */
  public static List<String> split(String str, String ch) {
      if (str == null) {
          return null;
      }
      List<String> al = new ArrayList<String>();
      str += ch;
      int begin = 0;
      int end = str.indexOf(ch, begin);
      while (end >= 0) {
          al.add(str.substring(begin, end));
          begin = end + ch.length();
          end = str.indexOf(ch, begin);
      }
      return al;
  }
  
  /**
   * 格式化数字，不够的位数补0,
   * @param i
   * @return
   */
  public static String formatNumber(int i) {
  	NumberFormat nf = NumberFormat.getInstance();
  	//设置是否分组
		nf.setGroupingUsed(false);
		nf.setMaximumIntegerDigits(8);
		nf.setMinimumIntegerDigits(8);
		return nf.format(i);
  }
  
	public static void main(String[] args) {
		System.out.println(mergeSpace("aa      bb  123"));
		
		System.out.println(toChineseCapitalCurrencyStyle(1001023.32));
		
		System.out.println(split("aa,,,bb,cc,",","));
		
		System.out.println(formatNumber(5));
	}

}
