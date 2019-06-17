# 剑指Offer题解 60-68

## 64. <span id="64">求1+2+…+n</span>

来源：[AcWing](https://www.nowcoder.com/practice/7a0da8fc483247ff8800059e12d7caf1?tpId=13&tqId=11200&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

### 题目描述

求1+2+…+n,要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。

### 样例

```
输入：10

输出：55
```

### 题解

```java
class Solution {
    public int getSum(int n) {
        int sum = n;
        boolean flag = (n > 0) && ((sum += getSum(n - 1)) > 0);
        return sum;
    }
}
```

## 65. <span id="65">不用加减乘除做加法</span>

来源：[NowCoder](https://www.nowcoder.com/practice/59ac416b4b944300b617d4f7f111b215?tpId=13&tqId=11201&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

### 题目描述

写一个函数，求两个整数之和，要求在函数体内不得使用＋、－、×、÷ 四则运算符号。

### 样例

```
输入：num1 = 1 , num2 = 2

输出：3
```

### 题解

```java
class Solution {
    public int add(int num1, int num2) {
        while(num2 != 0) {
            int tmp = num1 ^ num2;
            num2 = (num1 & num2) << 1;
            num1 = tmp;
        }
        return num1;
    }
}
```

## 67. <span id="67">把字符串转换成整数</span>

来源：[NowCoder](https://www.nowcoder.com/practice/1277c681251b4372bdef344468e4f26e?tpId=13&tqId=11202&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

### 题目描述

请你写一个函数StrToInt，实现把字符串转换成整数这个功能。

当然，不能使用atoi或者其他类似的库函数。

### 样例

```
输入："123"

输出：123
```

### 题解

```java
class Solution {
    public int strToInt(String str) {
        if (str == null || str.trim().equals("")) {
            return 0;
        }
        
        // symbol=0,说明该数为正数;symbol=1，该数为负数;start用来区分第一位是否为符号位
        int symbol = 0;
        int start = 0;
        char[] chars = str.trim().toCharArray();
        if (chars[0] == '+') {
            start = 1;
        } else if (chars[0] == '-') {
            start = 1;
            symbol = 1;
        }
        
        int result = 0;
        for (int i = start; i < chars.length; i++) {
            if (chars[i] > '9' || chars[i] < '0') {
                return 0;
            }
            int sum= result * 10 + (int) (chars[i] - '0');
            
            if((sum - (int) (chars[i] - '0')) / 10 != result){
                return 0;
            }
             
            result = result * 10 + (int) (chars[i] - '0');
        }

        result = (int) Math.pow(-1, symbol) * result;
        return result;
    }
}
```
