# 剑指Offer题解
- - -

## Introduction
记录自己的剑指Offer题解

## Content

### 15. 二维数组中的查找
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

### 16. 替换空格
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

### 17. 从尾到头打印链表
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

