# 剑指Offer题解 40-49

## 40. <span id="40">最小的k个数</span>

来源：[NowCoder](https://www.nowcoder.com/practice/6a296eb82cf844ca8539b57c23e6e9bf?tpId=13&tqId=11182&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

### 题目描述

输入n个整数，找出其中最小的k个数。

**注意**：
- 数据保证k一定小于等于输入数组的长度;
- 输出数组内元素请按从小到大顺序排序;

### 样例

```
输入：[1,2,3,4,5,6,7,8] , k=4

输出：[1,2,3,4]
```

### 题解

```java
class Solution {
    public List<Integer> getLeastNumbers_Solution(int [] input, int k) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            for(int j = input.length - 1; j > 0; j--) {
                if(input[j] < input[j - 1]) {
                    swap(input, j, j - 1);
                }
            }
            list.add(input[i]);
        }
        
        return list;
    }
    
    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
```

## 41-2. <span id="41-2">字符流中第一个只出现一次的字符</span>

来源：[NowCoder](https://www.nowcoder.com/practice/00de97733b8e4f97a3fb5c680ee10720?tpId=13&tqId=11207&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

### 题目描述

请实现一个函数用来找出字符流中第一个只出现一次的字符。

例如，当从字符流中只读出前两个字符”go”时，第一个只出现一次的字符是’g’。

当从该字符流中读出前六个字符”google”时，第一个只出现一次的字符是’l’。

如果当前字符流没有存在出现一次的字符，返回#字符。

### 样例

```
输入："google"

输出："ggg#ll"

解释：每当字符流读入一个字符，就进行一次判断并输出当前的第一个只出现一次的字符。
```

### 题解

```java
class Solution {
    
    private int[] hashtable = new int[128];
    private StringBuilder data = new StringBuilder();
    
    //Insert one char from stringstream
    public void Insert(char ch) {
        data.append(ch);
        ++hashtable[ch];
    }
  //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        char[] charArray = data.toString().toCharArray();
        for(int i = 0; i < charArray.length; i++) {
            if(hashtable[charArray[i]] == 1) {
                return charArray[i];
            }
        }
        return '#';
    }
}
```

## 42. <span id="42">连续子数组的最大和</span>

来源：[NowCoder](https://www.nowcoder.com/practice/459bd355da1549fa8a49e350bf3df484?tpId=13&tqId=11183&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

### 题目描述

输入一个 非空 整型数组，数组里的数可能为正，也可能为负。

数组中一个或连续的多个整数组成一个子数组。

求所有子数组的和的最大值。

要求时间复杂度为O(n)。

### 样例

```
输入：[1, -2, 3, 10, -4, 7, 2, -5]

输出：18
```

### 题解

```java
class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        
        int count = nums[0];
        int maxSum = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(count >= 0) {
                count += nums[i];
            }else {
                count = nums[i];
            }
            if(count > maxSum) {
                maxSum = count;
            }
        }
        
        return maxSum;
    }
}
```

## 43. <span id="43">从1到n整数中1出现的次数</span>

来源：[NowCoder](https://www.nowcoder.com/practice/bd7f978302044eee894445e244c7eee6?tpId=13&tqId=11184&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

### 题目描述

输入一个整数n，求从1到n这n个整数的十进制表示中1出现的次数。

例如输入12，从1到12这些整数中包含“1”的数字有1，10，11和12，其中“1”一共出现了5次。

### 样例

```
输入： 12

输出： 5
```

### 题解

```java
class Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        StringBuilder str = new StringBuilder();
        for(int i = 1; i <= n; i++){
             str.append(i);
        }
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '1') {
                count++;   
            }
        }
        return count;
    }
}
```

## 45. <span id="45">把数组排成最小的数</span>

来源：[NowCoder](https://www.nowcoder.com/practice/8fecd3f8ba334add803bf2a06af1b993?tpId=13&tqId=11185&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

### 题目描述

输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。

例如输入数组[3, 32, 321]，则打印出这3个数字能排成的最小数字321323。

### 样例

```
输入：[3, 32, 321]

输出：321323
```

### 题解

```java
class Solution {
    public String printMinNumber(int[] nums) {
        if(nums == null || nums.length == 0) {
            return "";
        }
        
        for(int i = 0; i < nums.length - 1; i++) {
            boolean hasSwapped = false;
            for(int j = 0; j < nums.length - 1 - i; j++) {
                long a = Long.valueOf(nums[j] + "" + nums[j + 1]);
                long b = Long.valueOf(nums[j + 1] + "" + nums[j]);
                if(a > b) {
                   swap(nums, j, j + 1);
                   hasSwapped = true;
                }
            }
            if(!hasSwapped) {
                break;
            }
        }
        
        StringBuilder sb = new StringBuilder(nums[0] + "");
        for(int i = 1; i < nums.length; i++) {
            sb.append(nums[i]);
        }
        return sb.toString();
    }
    
    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
```
