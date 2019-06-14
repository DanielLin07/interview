# 剑指Offer题解 10-19

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

## 19. <span id="19">二叉树的下一个节点</span>

来源：[NowCoder](https://www.nowcoder.com/practice/9023a0c988684a53960365b889ceaf5e?tpId=13&tqId=11210&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

### 题目描述

给定一棵二叉树的其中一个节点，请找出中序遍历序列的下一个节点。

**注意**：

- 如果给定的节点是中序遍历序列的最后一个，则返回空节点;
- 二叉树一定不为空，且给定的节点一定不是空节点；

### 样例

```
假定二叉树是：[2, 1, 3, null, null, null, null]， 给出的是值等于2的节点。

则应返回值等于3的节点。

解释：该二叉树的结构如下，2的后继节点是3。
  2
 / \
1   3
```

### 题解

```java
class Solution {
    public TreeNode inorderSuccessor(TreeNode pNode) {
        if(pNode == null) {
            return null;
        }
        
        // 如果右子树不为空，则找右子树的最左节点
        if(pNode.right != null) {
            pNode = pNode.right;
            while(pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }
        
        // 如果右子树为空，则找第一个当前节点为其父节点的左子树的节点
        while(pNode.father != null) {
            if(pNode.father.left == pNode) {
                return pNode.father;
            }
            pNode = pNode.father;
        }
        
        return null;
    }
}
```
