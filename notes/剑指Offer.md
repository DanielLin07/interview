# 剑指Offer题解

## Introduction
记录自己的剑指Offer题解

## Catlog

\# | 题目 | 难度 
:-: | :-: | :-:
15 | [二维数组中的查找](#15) |`easy`
16 | [替换空格](#16) |`easy`
17 | [从尾到头打印链表](#17) |`easy`
20 | [用两个栈实现队列](#20) |`easy` 
21 | [斐波那契数列](#21) |`easy`
251 | [跳台阶](#251) |`easy` 

## Content

### 15. <span id="15">二维数组中的查找</span>
来源：[AcWing](https://www.acwing.com/problem/content/16/)
#### 题目描述
在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
#### 样例

```
输入数组：
[
  [1,2,8,9]，
  [2,4,9,12]，
  [4,7,10,13]，
  [6,8,11,15]
]

如果输入查找数值为7，则返回true，
如果输入查找数值为5，则返回false。
```
#### 题解

```
class Solution {
    public boolean searchArray(int[][] array, int target) {
        int rowNum = array.length;
        if(rowNum == 0) {
            return false;
        }
        
        int colNum = array[0].length;
        int i = rowNum - 1;
        int j = 0;
        
        while(i >= 0 && j < colNum) {
            if(target < array[i][j]) {
                i--;
            }else if(target > array[i][j]) {
                j++;
            }else {
                return true;
            }
        }
        
        return false;
    }
}
```
</br>

### 16. <span id="16">替换空格</span>
来源：[AcWing](https://www.acwing.com/problem/content/17/)
#### 题目描述
请实现一个函数，把字符串中的每个空格替换成"%20"。
你可以假定输入字符串的长度最大是1000。
注意输出字符串的长度可能大于1000。
#### 样例

```
输入："We are happy."

输出："We%20are%20happy."
```
#### 题解

```
class Solution {
    public String replaceSpaces(StringBuffer str) {
        char[] strArray = str.toString().toCharArray();
        StringBuffer newStr = new StringBuffer();
        
        for(int i = 0; i < strArray.length; i++) {
            if(' ' == strArray[i]) {
                newStr.append("%20");
            }else {
                newStr.append(strArray[i]);
            }
        }
        
        return newStr.toString();
    }
}
```
</br>

### 17. <span id="17">从尾到头打印链表</span>
来源：[AcWing](https://www.acwing.com/problem/content/18/)
#### 题目描述
输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
#### 样例

```
输入：[2, 3, 5]

返回：[5, 3, 2]
```
#### 题解

```
/**
*    public class ListNode {
*        int val;
*        ListNode next = null;
*
*        ListNode(int val) {
*            this.val = val;
*        }
*    }
*
*/

import java.util.ArrayList;

class Solution {
    public ArrayList<Integer> list = new ArrayList<>();
    
    public List<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode != null) {
            this.printListFromTailToHead(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }
}
```
</br>

### 20. <span id="20">用两个栈实现队列</span>
来源：[AcWing](https://www.acwing.com/problem/content/36/)
#### 题目描述
请用栈实现一个队列，支持如下四种操作：

- push(x) – 将元素x插到队尾；
- pop() – 将队首的元素弹出，并返回该元素；
- peek() – 返回队首元素；
- empty() – 返回队列是否为空；

注意：

- 你只能使用栈的标准操作：push to top，peek/pop from top, size 和 is empty；
- 如果你选择的编程语言没有栈的标准库，你可以使用list或者deque等模拟栈的操作；
- 输入数据保证合法，例如，在队列为空时，不会进行pop或者peek等操作；
#### 样例

```
MyQueue queue = new MyQueue();

queue.push(1);
queue.push(2);
queue.peek();  // returns 1
queue.pop();   // returns 1
queue.empty(); // returns false
```
#### 题解

```
class Solution {
    public int Fibonacci(int n) {
        int preNum = 1;
        int prePreNum = 0;
        
        if(n == 0) {
            return prePreNum;
        }else if(n == 1) {
            return preNum;
        }
        
        int index = 1;
        int curNum = 0;
        while(index < n) {
            curNum = preNum + prePreNum;
            prePreNum = preNum;
            preNum = curNum;
            index++;
        }
        
        return curNum;
    }
}
```
</br>

### 21. <span id="21">斐波那契数列</span>
来源：[AcWing](https://www.acwing.com/problem/content/18/)
#### 题目描述
输入一个整数 n ，求斐波那契数列的第 n 项。
假定从0开始，第0项为0。(n<=39)
#### 样例

```
输入整数 n=5 

返回 5
```
#### 题解

```
class Solution {
    public int Fibonacci(int n) {
        int preNum = 1;
        int prePreNum = 0;
        
        if(n == 0) {
            return prePreNum;
        }else if(n == 1) {
            return preNum;
        }
        
        int index = 1;
        int curNum = 0;
        while(index < n) {
            curNum = preNum + prePreNum;
            prePreNum = preNum;
            preNum = curNum;
            index++;
        }
        
        return curNum;
    }
}
```
</br>

### 251. <span id="251">跳台阶</span>
来源：[NowCoder](https://www.nowcoder.com/practice/8c82a5b80378478f9484d87d1c5f12a4?tpId=13&tqId=11161&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)
#### 题目描述
一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
#### 样例

```
输入整数 n=3 

返回 3
```
#### 题解

```
class Solution {
    public int JumpFloor(int target) {
        if(target <= 2) {
            return target;
        }
        
        int f1 = 1;
        int f2 = 2;
        
        int index = 2;
        int count = 0;
        while(index < target) {
            count = f1 + f2;
            f1 = f2;
            f2 = count;
            index++;
        }
        
        return count;
    }
}
```
</br>
