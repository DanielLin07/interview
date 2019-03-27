# 剑指Offer题解

## Introduction

记录自己的剑指Offer题解

## Catlog

\# | 题目 | 难度 
:-: | :-: | :-:
13 | [数组中重复的数字](#13) |`easy`
15 | [二维数组中的查找](#15) |`easy`
16 | [替换空格](#16) |`easy`
17 | [从尾到头打印链表](#17) |`easy`
20 | [用两个栈实现队列](#20) |`easy` 
21 | [斐波那契数列](#21) |`easy`
22 | [旋转数组的最小数字](#22) |`mid`
29 | [删除链表中重复的节点](#29) |`mid`
32 | [调整数组顺序使奇数位于偶数前面](#32) |`easy`
33 | [链表中倒数第k个节点](#33) |`easy`
34 | [链表中环的入口结点](#33) |`easy`
35 | [反转链表](#35) |`easy`
36 | [合并两个排序的链表](#36) |`easy`
37 | [树的子结构](#37) |`easy`
38 | [二叉树的镜像](#38) |`easy`
39 | [对称的二叉树](#39) |`easy`
41 | [包含min函数的栈](#41) |`easy`
42 | [栈的压入、弹出序列](#42) |`easy`
47 | [二叉树中和为某一值的路径](#47) |`mid`
52 | [数组中出现次数超过一半的数字](#52) |`easy`
53 | [最小的k个数](#53) |`easy`
55 | [连续子数组的最大和](#55) |`easy`
58 | [把数组排成最小的数](#58) |`mid`
63 | [字符串中第一个只出现一次的字符](#63) |`easy`
66 | [两个链表的第一个公共结点](#66) |`easy`
67 | [数字在排序数组中出现的次数](#67) |`easy`
71 | [二叉树的深度](#71) |`easy`
72 | [平衡二叉树](#72) |`easy`
73 | [数组中只出现一次的两个数字](#73) |`mid`
75 | [和为S的两个数字](#75) |`easy`
84 | [求1+2+…+n](#84) |`easy`
251 | [跳台阶](#251) |`easy` 
252 | [变态跳台阶](#252) |`easy` 

## Content

## 13. <span id="13">数组中重复的数字</span>

来源：[NowCoder](https://www.nowcoder.com/practice/623a5ac0ea5b4e5f95552655361ae0a8?tpId=13&tqId=11203&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

### 题目描述

在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。

### 样例

```html
给定 nums = [2, 3, 5, 4, 3, 2, 6, 7]。

返回 2 或 3。
```

### 题解

```java
class Solution {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers == null || length <= 0) {
            return false;
        }
        for(int i = 0; i < numbers.length; i++) {
            while(numbers[i] != i) {
                if(numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                }
                swap(numbers, i, numbers[i]);
            }
        }
        return false;
    }
    
    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
```
</br>

## 15. <span id="15">二维数组中的查找</span>

来源：[NowCoder](https://www.nowcoder.com/practice/abc3fe2ce8e146608e868a70efebf62e?tpId=13&tqId=11154&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

### 题目描述

在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

### 样例

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

### 题解

```java
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

## 16. <span id="16">替换空格</span>

来源：[AcWing](https://www.nowcoder.com/practice/4060ac7e3e404ad1a894ef3e17650423?tpId=13&tqId=11155&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

### 题目描述

请实现一个函数，把字符串中的每个空格替换成"%20"。
你可以假定输入字符串的长度最大是1000。
注意输出字符串的长度可能大于1000。

### 样例

```
输入："We are happy."

输出："We%20are%20happy."
```

### 题解

```java
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

## 17. <span id="17">从尾到头打印链表</span>

来源：[NowCoder](https://www.acwing.com/problem/content/18/)

### 题目描述

输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。

### 样例

```
输入：[2, 3, 5]

返回：[5, 3, 2]
```

### 题解

```java
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

## 20. <span id="20">用两个栈实现队列</span>

来源：[NowCoder](https://www.nowcoder.com/practice/54275ddae22f475981afa2244dd448c6?tpId=13&tqId=11158&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

### 题目描述

请用栈实现一个队列，支持如下四种操作：

- push(x) – 将元素x插到队尾；
- pop() – 将队首的元素弹出，并返回该元素；
- peek() – 返回队首元素；
- empty() – 返回队列是否为空；

**注意\:**

- 你只能使用栈的标准操作：push to top，peek/pop from top, size 和 is empty；
- 如果你选择的编程语言没有栈的标准库，你可以使用list或者deque等模拟栈的操作；
- 输入数据保证合法，例如，在队列为空时，不会进行pop或者peek等操作；

### 样例

```
MyQueue queue = new MyQueue();

queue.push(1);
queue.push(2);
queue.peek();  // returns 1
queue.pop();   // returns 1
queue.empty(); // returns false
```

### 题解

```java
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

## 21. <span id="21">斐波那契数列</span>

来源：[NowCoder](https://www.nowcoder.com/practice/c6c7742f5ba7442aada113136ddea0c3?tpId=13&tqId=11160&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

### 题目描述

输入一个整数 n ，求斐波那契数列的第 n 项。
假定从0开始，第0项为0。(n<=39)

### 样例

```
输入整数 n=5 

返回 5
```

### 题解

```java
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

## 22. <span id="22">旋转数组的最小数字</span>

来源：[NowCoder](https://www.nowcoder.com/practice/9f3231a991af4f55b95579b44b7a01ba?tpId=13&tqId=11159&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

### 题目描述

把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。

输入一个升序的数组的一个旋转，输出旋转数组的最小元素。

例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。

数组可能包含重复项。

**注意**：数组内所含元素非负，若数组大小为0，请返回-1。

### 样例

```
输入：nums=[2,2,2,0,1]

输出：0
```
### 题解

```java
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

## 29. <span id="29">删除链表中重复的节点</span>

来源：[NowCoder](https://https://www.nowcoder.com/practice/fc533c45b73a41b0b44ccba763f866ef?tpId=13&tqId=11209&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking.acwing.com/problem/content/20/)

### 题目描述

在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留。

### 样例1

```
输入：1->2->3->3->4->4->5

输出：1->2->5
```

### 样例2

```

输入：1->1->1->2->3

输出：2->3
```

### 题解

```java
class Solution {
    public ListNode deleteDuplication(ListNode pHead) {
        if(pHead == null || pHead.next == null) {
            return pHead;
        }
        
        if(pHead.val == pHead.next.val) {
            ListNode pNode = pHead.next;
            while(pNode != null && pNode.val == pHead.val) {
                pNode = pNode.next;
            }
            return deleteDuplication(pNode);
        }else {
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }
}
```
</br>

## 32. <span id="32">调整数组顺序使奇数位于偶数前面</span>

来源：[NowCoder](https://www.nowcoder.com/practice/beb5aa231adc45b2a5dcc5b62c93f593?tpId=13&tqId=11166&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

### 题目描述

输入一个整数数组，实现一个函数来调整该数组中数字的顺序。

使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分。

### 样例

```
输入：[1,2,3,4,5]

输出: [1,3,5,2,4]
```

### 题解

```java
class Solution {
    public void reOrderArray(int [] array) {
        if(array.length == 0) {
            return;
        }
        
        boolean hasSwapped = false;
        for(int i = 0; i < array.length - 1; i++) {
            for(int j = 0; j < array.length - i - 1; j++) {
                if(array[j] % 2 == 0 && array[j + 1] % 2 != 0) {
                    swap(array, j, j + 1);
                    hasSwapped = true;
                }
            }
            if(!hasSwapped) {
                return;
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
```
</br>

## 33. <span id="33">链表中倒数第k个节点</span>

来源：[NowCoder](https://www.nowcoder.com/practice/529d3ae5a407492994ad2a246518148a?tpId=13&tqId=11167&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

### 题目描述

输入一个链表，输出该链表中倒数第k个结点。

**注意**：
- k >= 0;
- 如果k大于链表长度，则返回 NULL;

### 样例

```
输入：链表：1->2->3->4->5 ，k=2

输出：4
```

### 题解

```java
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

## 34. <span id="34">链表中环的入口结点</span>

来源：[NowCoder](https://www.nowcoder.com/practice/253d2c59ec3e4bc68da16833f79a38e4?tpId=13&tqId=11208&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

### 题目描述

给定一个链表，若其中包含环，则输出环的入口节点。

若其中不包含环，则输出null。

### 样例

![](https://user-gold-cdn.xitu.io/2019/3/19/169969a603ceb371?w=640&h=140&f=png&s=22018)
```
给定如上所示的链表：
[1, 2, 3, 4, 5, 6]
2
注意，这里的2表示编号是2的节点，节点编号从0开始。所以编号是2的节点就是val等于3的节点。

则输出环的入口节点3.
```

### 题解

```java
class Solution {
    public ListNode entryNodeOfLoop(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) {
            return null;
        }
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        
        while(fast != slow) {
            if(fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }else {
                return null;
            }
        }
        
        fast = head;
        while(fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        
        return fast;
    }
}
```
</br>

## 35. <span id="35">反转链表</span>

来源：[NowCoder](https://www.nowcoder.com/practice/75e878df47f24fdc9dc3e400ec6058ca?tpId=13&tqId=11168&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

### 题目描述

定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的头结点。

### 样例

```
输入:1->2->3->4->5->NULL

输出:5->4->3->2->1->NULL
```

### 题解

```java
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

## 36. <span id="36">合并两个排序的链表</span>

来源：[NowCoder](https://www.nowcoder.com/practice/d8b6b4358f774294a89de2a6ac4d9337?tpId=13&tqId=11169&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

### 题目描述

输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的。

### 样例

```
输入：1->3->5 , 2->4->5

输出：1->2->3->4->5->5
```

### 题解

```java
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

## 37. <span id="37">树的子结构</span>

来源：[NowCoder](https://www.nowcoder.com/practice/6e196c44c7004d15b1610b9afca8bd88?tpId=13&tqId=11170&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

### 题目描述

输入两棵二叉树A，B，判断B是不是A的子结构。

我们规定空树不是任何树的子结构。

### 样例

```
树A：

     8
    / \
   8   7
  / \
 9   2
    / \
   4   7
树B：

   8
  / \
 9   2
返回 true ,因为B是A的子结构。
```

### 题解

```java
class Solution {
    public boolean hasSubtree(TreeNode pRoot1, TreeNode pRoot2) {
        boolean result = false;
        if(pRoot1 == null || pRoot2 == null) {
            return result;
        }
        
        if(pRoot1.val == pRoot2.val) {
            result = doesTree1HasTree2(pRoot1, pRoot2);
        }
        if(!result) {
            result = hasSubtree(pRoot1.left, pRoot2);
        }
        if(!result) {
            result = hasSubtree(pRoot1.right, pRoot2);
        }
        
        return result;
    }
    
    public boolean doesTree1HasTree2(TreeNode pRoot1, TreeNode pRoot2) {
        if(pRoot2 == null) {
            return true;
        }
        if(pRoot1 == null) {
            return false;
        }
        if(pRoot1.val != pRoot2.val) {
            return false;
        }
        return doesTree1HasTree2(pRoot1.left, pRoot2.left) && 
            doesTree1HasTree2(pRoot1.right, pRoot2.right);
    }
}
```
</br>

## 38. <span id="38">二叉树的镜像</span>

来源：[NowCoder](https://www.nowcoder.com/practice/564f4c26aa584921bc75623e48ca3011?tpId=13&tqId=11171&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

### 题目描述

输入一个二叉树，将它变换为它的镜像。

### 样例

```
输入树：
      8
     / \
    6  10
   / \ / \
  5  7 9 11

 [8,6,10,5,7,9,11,null,null,null,null,null,null,null,null] 
输出树：
      8
     / \
    10  6
   / \ / \
  11 9 7  5

 [8,10,6,11,9,7,5,null,null,null,null,null,null,null,null]
```

### 题解

```java
class Solution {
    public void mirror(TreeNode root) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            return;
        }
        
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        
        if(root.left != null) {
            mirror(root.left);
        }
        if(root.right != null) {
            mirror(root.right);
        }
    }
}
```
</br>

## 39. <span id="39">对称的二叉树</span>

来源：[NowCoder](https://www.nowcoder.com/practice/ff05d44dfdb04e1d83bdbdab320efbcb?tpId=13&tqId=11211&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

### 题目描述

请实现一个函数，用来判断一棵二叉树是不是对称的。

如果一棵二叉树和它的镜像一样，那么它是对称的。

### 样例

```
如下图所示二叉树[1,2,2,3,4,4,3,null,null,null,null,null,null,null,null]为对称二叉树：
    1
   / \
  2   2
 / \ / \
3  4 4  3

如下图所示二叉树[1,2,2,null,4,4,3,null,null,null,null,null,null]不是对称二叉树：
    1
   / \
  2   2
   \ / \
   4 4  3
```

### 题解

```java
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        
        return check(root.left, root.right);
    }
    
    private boolean check(TreeNode left, TreeNode right) {
        if(left == null) {
            return right == null;
        }else if(right == null) {
            return false;
        }
        
        if(left.val != right.val) {
            return false;
        }
        return check(left.left, right.right) && check(left.right, right.left);
    }
}
```
</br>

## 41. <span id="41">包含min函数的栈</span>

来源：[NowCoder](https://www.nowcoder.com/practice/4c776177d2c04c2494f2555c9fcc1e49?tpId=13&tqId=11173&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

### 题目描述

设计一个支持push，pop，top等操作并且可以在O(1)时间内检索出最小元素的堆栈。

- push(x)–将元素x插入栈中
- pop()–移除栈顶元素
- top()–得到栈顶元素
- getMin()–得到栈中最小元素

### 样例

```
MinStack minStack = new MinStack();
minStack.push(-1);
minStack.push(3);
minStack.push(-4);
minStack.getMin();   --> Returns -4.
minStack.pop();
minStack.top();      --> Returns 3.
minStack.getMin();   --> Returns -1.
```

### 题解

```java
class MinStack {
    
    Stack<Integer> data;
    Stack<Integer> min;

    /** initialize your data structure here. */
    public MinStack() {
        data = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int x) {
        data.push(x);
        if(min.isEmpty()) {
            min.push(x);
        }else if(x <= min.peek()){
            min.push(x);
        }
    }
    
    public void pop() {
        int num = data.pop();
        if(num == min.peek()) {
            min.pop();
        }
    }
    
    public int top() {
        return data.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
```
</br>

## 42. <span id="42">栈的压入、弹出序列</span>

来源：[NowCoder](https://www.nowcoder.com/practice/d77d11405cc7470d82554cb392585106?tpId=13&tqId=11174&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

### 题目描述

输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。

假设压入栈的所有数字均不相等。

例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。

**注意**：若两个序列为空或长度不等则视为并不是一个栈的压入、弹出序列。

### 样例

```
输入：[1,2,3,4,5]
      [4,5,3,2,1]

输出：true
```

### 题解

```java
class Solution {
    public boolean isPopOrder(int [] pushV,int [] popV) {
        if(pushV.length == 0 && popV.length != 0) {
            return false;
        }
        if(pushV.length != 0 && popV.length == 0) {
            return false;
        }
        if(pushV.length != popV.length) {
            return false;
        }
        
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        for(int i = 0; i < pushV.length; i++) {
            stack.push(pushV[i]);
            while(!stack.isEmpty() && stack.peek() == popV[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        
        return stack.isEmpty();
    }
}
```
</br>

## 47. <span id="47">二叉树中和为某一值的路径</span>

来源：[NowCoder](https://www.nowcoder.com/practice/b736e784e3e34731af99065031301bca?tpId=13&tqId=11177&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

### 题目描述

输入一棵二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。

从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。

### 样例

```
给出二叉树如下所示，并给出num=22。
      5
     / \
    4   6
   /   / \
  12  13  6
 /  \    / \
9    1  5   1

输出：[[5,4,12,1],[5,6,6,5]]
```

### 题解

```java
class Solution {
    
    List<List<Integer>> resultList = new ArrayList<>();
    List<Integer> result = new ArrayList<>(); 
    
    public List<List<Integer>> findPath(TreeNode root, int sum) {
        if(root == null) {
            return resultList;
        }
        
        sum -= root.val;
        result.add(root.val);
        if(sum == 0 && root.left == null && root.right == null) {
            resultList.add(new ArrayList<>(result));
        }
        
        findPath(root.left, sum);
        findPath(root.right, sum);
        result.remove(result.size() - 1);
        return resultList;
    }
}
```
</br>

## 52. <span id="52">数组中出现次数超过一半的数字</span>

来源：[NowCoder](https://www.nowcoder.com/practice/e8a1b01a2df14cb2b228b30ee6a92163?tpId=13&tqId=11181&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

### 题目描述

数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。

如果不存在则输出0。

**思考题**：

- 假设要求只能使用 O(n) 的时间和额外 O(1) 的空间，该怎么做呢？

### 样例

```
输入：[1,2,1,1,3]

输出：1
```

### 题解

```java
class Solution {
    public int moreThanHalfNum_Solution(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int num = nums[0];
        int count = 1;
        
        for(int i = 1; i < nums.length; i++) {
            if(num == nums[i]) {
                count++;
            }else {
                count--;
            }
            if(count == 0) {
                num = nums[i];
                count = 1;
            }
        }
        
        count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(num == nums[i]) {
                count++;
            }
        }
        
        return count > nums.length / 2 ? num : 0;
    }
}
```
</br>

## 53. <span id="53">最小的k个数</span>

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
</br>

## 55. <span id="55">连续子数组的最大和</span>

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
</br>

## 58. <span id="58">把数组排成最小的数</span>

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
</br>

## 63. <span id="63">字符串中第一个只出现一次的字符</span>

来源：[NowCoder](https://www.nowcoder.com/practice/1c82e8cf713b4bbeb2a5b31cf5b0417c?tpId=13&tqId=11187&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

### 题目描述

在字符串中找出第一个只出现一次的字符。

如输入"abaccdeff"，则输出b。

如果字符串中不存在只出现一次的字符，返回#字符。

### 样例

```
输入："abaccdeff"

输出：'b'
```

### 题解

```java
class Solution {
    public char firstNotRepeatingChar(String s) {
        if(s.length() == 0) {
            return '#';
        }
        
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i)) != null) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }else {
                map.put(s.charAt(i), 1);
            }
        }
        
        for(int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i)) == 1) {
                return s.charAt(i);
            }
        }
        
        return '#';
    }
}
```
</br>

## 66. <span id="66">两个链表的第一个公共结点</span>

来源：[NowCoder](https://www.nowcoder.com/practice/6ab1d9a29e88450685099d45c9e31e46?tpId=13&tqId=11189&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

### 题目描述

输入两个链表，找出它们的第一个公共结点。

当不存在公共节点时，返回空节点。

如果字符串中不存在只出现一次的字符，返回#字符。

### 样例

```
给出两个链表如下所示：
A：        a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3

输出第一个公共节点c1
```

### 题解

```java
class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        
        while(p1 != p2) {
            p1 = (p1 == null ? pHead2 : p1.next);
            p2 = (p2 == null ? pHead1 : p2.next); 
        }
        
        return p1;
    }
}
```
</br>

## 67. <span id="67">数字在排序数组中出现的次数</span>

来源：[NowCoder](https://www.nowcoder.com/practice/70610bf967994b22bb1c26f9ae901fa2?tpId=13&tqId=11190&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

### 题目描述

统计一个数字在排序数组中出现的次数。

例如输入排序数组[1, 2, 3, 3, 3, 3, 4, 5]和数字3，由于3在这个数组中出现了4次，因此输出4。

### 样例

```
输入：[1, 2, 3, 3, 3, 3, 4, 5] ,  3

输出：4
```

### 题解

```java
class Solution {
    public int getNumberOfK(int[] nums, int k) {
        return binarySearch(nums, k + 0.5) - binarySearch(nums, k - 0.5);
    }
    
    public int binarySearch(int[] nums, double target) {
        int low = 0, high = nums.length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] > target) {
                high = mid - 1;
            }else if(nums[mid] < target) {
                low = mid + 1;
            }
        }
        return low;
    }
}
```
</br>

## 71. <span id="71">二叉树的深度</span>

来源：[NowCoder](https://www.nowcoder.com/practice/435fb86331474282a3499955f0a41e8b?tpId=13&tqId=11191&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

### 题目描述

输入一棵二叉树的根结点，求该树的深度。

从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。

### 样例

```
输入：二叉树[8, 12, 2, null, null, 6, 4, null, null, null, null]如下图所示：
    8
   / \
  12  2
     / \
    6   4

输出：3
```

### 题解

#### 递归实现

```java
class Solution {
    public int treeDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int left =  treeDepth(root.left);
        int right = treeDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
```

#### 非递归实现

```java
class Solution {
    public int treeDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // 当前层遍历的节点数
        int count = 0;
        // 下一层的节点总数
        int nextCount = 1;
        // 深度
        int depth = 0;
        
        while(queue.size() != 0) {
            TreeNode node = queue.poll();
            count++;
            if(node.left != null) {
                queue.add(node.left);
            }
            if(node.right != null) {
                queue.add(node.right);
            }
            if(count == nextCount) {
                count = 0;
                nextCount = queue.size();
                depth++;
            }
        }
        
        return depth;
    }
}
```
</br>

## 72. <span id="72">平衡二叉树</span>

来源：[NowCoder](https://www.nowcoder.com/practice/8b3b95850edb4115918ecebdf1b4d222?tpId=13&tqId=11192&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

### 题目描述

输入一棵二叉树的根结点，判断该树是不是平衡二叉树。

如果某二叉树中任意结点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。

**注意**：

- 规定空树也是一棵平衡二叉树。

### 样例

```
输入：二叉树[5,7,11,null,null,12,9,null,null,null,null]如下所示，
    5
   / \
  7  11
    /  \
   12   9

输出：true
```

### 题解

#### 解法一

```java
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1 &&
            isBalanced(root.left) && isBalanced(root.right);
    }
    
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
```

#### 解法二

```java
class Solution {
    public boolean isBalanced(TreeNode root) {
        return getDepth(root) != -1;
    }
    
    public int getDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int left = getDepth(root.left);
        if(left == -1) {
            return -1;
        }
        int right = getDepth(root.right);
        if(right == -1) {
            return -1;
        }
        
        return Math.abs(left - right) > 1 ? -1 : Math.max(left, right) + 1;
    }
}
```
</br>

## 73. <span id="73">数组中只出现一次的两个数字</span>

来源：[NowCoder](https://www.nowcoder.com/practice/e02fdb54d7524710a7d664d082bb7811?tpId=13&tqId=11193&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

### 题目描述

一个整型数组里除了两个数字之外，其他的数字都出现了两次。

请写程序找出这两个只出现一次的数字。

你可以假设这两个数字一定存在。

### 样例

```
输入：[1,2,3,3,4,4]

输出：[1,2]
```

### 题解

```java
class Solution {
    public int[] findNumsAppearOnce(int[] nums) {
        if(nums == null || nums.length < 2) {
            return null;
        }
        
        int[] result = new int[2];
        int num = 0;
        for(int i = 0; i < nums.length; i++) {
            num ^= nums[i];
        }
        
        int indexOf1 = findFirstIndex(num);
        for(int i = 0; i < nums.length; i++) {
            if(isBit(nums[i], indexOf1)) {
                result[0] ^= nums[i];
            }else {
                result[1] ^= nums[i];
            }
        }
        
        return result;
    }
    
    public int findFirstIndex(int num) {
        int indexBit = 0;
        while(((num & 1) == 0) && indexBit < 8 * 4) {
            num = num >> 1;
            indexBit++;
        }
        return indexBit;
    }
    
    public boolean isBit(int num, int indexBit) {
        num = num >> indexBit;
        return (num & 1) == 1; 
    }
    
    
}
```
</br>

## 75. <span id="75">和为S的两个数字</span>

来源：[NowCoder](https://www.nowcoder.com/practice/390da4f7a00f44bea7c2f3d19491311b?tpId=13&tqId=11195&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

### 题目描述

输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。

### 样例

```
输入：[1,2,3,4] , sum=7

输出：[3,4]
```

### 题解

```java
class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        if(array == null || array.length == 0) {
            return result;
        }
        
        int low = 0, high = array.length - 1;
        while(low < high) {
            if(array[low] + array[high] == sum){
                result.add(array[low]);
                result.add(array[high]);
                return result;
            }else if(array[low] + array[high] < sum) {
                low++;
            }else {
                high--;
            }
        }
        
        return result;
    }
}
```
</br>

## 84. <span id="84">求1+2+…+n</span>

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
</br>

## 251. <span id="251">跳台阶</span>

来源：[NowCoder](https://www.nowcoder.com/practice/8c82a5b80378478f9484d87d1c5f12a4?tpId=13&tqId=11161&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

### 题目描述

一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。

### 样例

```
输入整数 n=3 

返回 3
```

### 题解

```java
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

## 252. <span id="252">变态跳台阶</span>

来源：[NowCoder](https://www.nowcoder.com/practice/22243d016f6b47f2a6928b4313c85387?tpId=13&tqId=11162&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

### 题目描述

一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。

### 样例

```
输入整数 n=3 

返回 4
```

### 题解

```java
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
