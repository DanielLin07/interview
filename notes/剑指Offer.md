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
22 | [旋转数组的最小数字](#22) |`mid`
32 | [调整数组顺序使奇数位于偶数前面](#32) |`easy`
33 | [链表中倒数第k个节点](#33) |`easy`
35 | [反转链表](#35) |`easy`
36 | [合并两个排序的链表](#36) |`easy`
251 | [跳台阶](#251) |`easy` 
252 | [变态跳台阶](#252) |`easy` 

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
class MyQueue {
    
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        
        return stack2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        
        return stack2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
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

### 22. <span id="22">旋转数组的最小数字</span>
来源：[AcWing](https://www.acwing.com/problem/content/20/)
#### 题目描述
把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。

输入一个升序的数组的一个旋转，输出旋转数组的最小元素。

例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。

数组可能包含重复项。

**注意**：数组内所含元素非负，若数组大小为0，请返回-1。
#### 样例

```
输入：nums=[2,2,2,0,1]

输出：0
```
#### 题解

```
class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 0) {
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        
        while(low < high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] > nums[high]) {
                low = mid + 1;
            }else if(nums[mid] == nums[high]) {
                high = high - 1;
            }else {
                high = mid;
            }
        }
        
        return nums[low];
    }
}
```
</br>

### 32. <span id="32">调整数组顺序使奇数位于偶数前面</span>
来源：[AcWing](https://www.acwing.com/problem/content/30/)
#### 题目描述
输入一个整数数组，实现一个函数来调整该数组中数字的顺序。

使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分。
#### 样例

```
输入：[1,2,3,4,5]

输出: [1,3,5,2,4]
```
#### 题解

```
class Solution {
    public void reOrderArray(int [] array) {
        if(array.length == 0) {
            return;
        }
        
        boolean hasSwapped = false;
        for(int i = 0; i < array.length - 1; i++) {
            for(int j = 0; j < array.length - i - 1; j++) {
                if(array[j] % 2 == 0 && array[j + 1] % 2 != 0) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    hasSwapped = true;
                }
            }
            if(!hasSwapped) {
                return;
            }
        }
    }
}
```
</br>

### 33. <span id="33">链表中倒数第k个节点</span>
来源：[AcWing](https://www.acwing.com/problem/content/32/)
#### 题目描述
输入一个链表，输出该链表中倒数第k个结点。

**注意**：
- k >= 0;
- 如果k大于链表长度，则返回 NULL;

#### 样例

```
输入：链表：1->2->3->4->5 ，k=2

输出：4
```
#### 题解

```
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode findKthToTail(ListNode pListHead, int k) {
        if(pListHead == null) {
            return null;
        }
        ListNode pre = pListHead;
        ListNode after = pListHead;
        
        for(int i = 1; i < k; i++) {
            if(pre.next != null) {
                pre = pre.next;
            }else {
                return null;
            }
        }
        
        while(pre.next != null) {
            pre = pre.next;
            after = after.next;
        }
        
        return after;
    }
}
```
</br>

### 35. <span id="35">反转链表</span>
来源：[AcWing](https://www.acwing.com/problem/content/33/)
#### 题目描述
定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的头结点。
#### 样例

```
输入:1->2->3->4->5->NULL

输出:5->4->3->2->1->NULL
```
#### 题解

```
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return null;
        }
        
        ListNode pre = null;
        ListNode next = null;
        
        while(head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        
        return pre;
    }
}
```
</br>

### 36. <span id="36">合并两个排序的链表</span>
来源：[AcWing](https://www.acwing.com/problem/content/34/)
#### 题目描述
输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的。。
#### 样例

```
输入：1->3->5 , 2->4->5

输出：1->2->3->4->5->5
```
#### 题解

```
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode merge(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        
        if(l1.val <= l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        }else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
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

### 252. <span id="252">变态跳台阶</span>
来源：[NowCoder](https://www.nowcoder.com/practice/22243d016f6b47f2a6928b4313c85387?tpId=13&tqId=11162&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)
#### 题目描述
一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
#### 样例

```
输入整数 n=3 

返回 4
```
#### 题解

```
class Solution {
    public int JumpFloorII(int target) {
        int f = 1;
        int fn = 1;
        
        for(int i = 1; i < target; i++) {
            fn = 2 * f;
            f = fn;
        }
        
        return fn;
    }
}
```
</br>
