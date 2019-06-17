# 剑指Offer题解 20-29

## 20. <span id="20">表示数值的字符串</span>

来源：[NowCoder](https://www.nowcoder.com/practice/6f8c901d091949a5837e24bb82a731f2?tpId=13&tqId=11206&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

### 题目描述

请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。

例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。

但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。

### 样例

```
1. 小数可以没有整数部分，例如.123等于0.123；
2. 小数点后面可以没有数字，例如233.等于233.0；
3. 小数点前面和后面可以有数字，例如233.666;
4. 当e或E前面没有数字时，整个字符串不能表示数字，例如.e1、e1；
5. 当e或E后面没有整数时，整个字符串不能表示数字，例如12e、12e+5.4;
```

### 题解

```java
class Solution {
    
}
```

## 21. <span id="21">调整数组顺序使奇数位于偶数前面</span>

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

## 22. <span id="22">链表中倒数第k个节点</span>

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

## 23. <span id="23">链表中环的入口结点</span>

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

## 24. <span id="24">反转链表</span>

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

## 25. <span id="25">合并两个排序的链表</span>

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

## 26. <span id="26">树的子结构</span>

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

## 27. <span id="27">二叉树的镜像</span>

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

## 28. <span id="28">对称的二叉树</span>

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

## 29. <span id="29">顺时针打印矩阵</span>

来源：[NowCoder](https://www.nowcoder.com/practice/9b4c81a02cd34f76be2659fa0d54342a?tpId=13&tqId=11172&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

### 题目描述

输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。

### 样例

```
输入：
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]

输出：[1,2,3,4,8,12,11,10,9,5,6,7]
```

### 题解

```java
class Solution {
    
}
```
