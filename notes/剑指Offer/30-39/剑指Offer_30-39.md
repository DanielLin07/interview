# 剑指Offer题解 30-39

## 30. <span id="30">包含min函数的栈</span>

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

## 31. <span id="31">栈的压入、弹出序列</span>

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

## 32-1. <span id="32-1">从上往下打印二叉树</span>

来源：[NowCoder](https://www.nowcoder.com/practice/445c44d982d04483b04a54f298796288?tpId=13&tqId=11213&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

### 题目描述

从上到下按层打印二叉树，同一层的结点按从左到右的顺序打印，每一层打印到一行。

### 样例

```
输入如下图所示二叉树[8, 12, 2, null, null, 6, null, 4, null, null, null]
    8
   / \
  12  2
     /
    6
   /
  4

输出：[8, 12, 2, 6, 4]
```

### 题解

#### 递归实现

```java
class Solution {
    public List<List<Integer>> printFromTopToBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        depth(root, 1, result);
        return result;
    }
    
    public void depth(TreeNode root, int depth, List<List<Integer>> list) {
        if(root == null) {
            return;
        }
        if(depth > list.size()) {
            list.add(new ArrayList<>());
        }
        list.get(depth - 1).add(root.val);
        if(root.left != null) {
            depth(root.left, depth + 1, list);
        }
        if(root.right != null) {
            depth(root.right, depth + 1, list);
        }
    }
}
```

#### 非递归实现

```java
class Solution {
    public List<List<Integer>> printFromTopToBottom(TreeNode root) {
        // result用于记录所有结果
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        
        // layer用于记录当前行的所有节点
        Queue<TreeNode> layer = new LinkedList<>();
        // layerList用于记录当前行的所有节点的值
        List<Integer> layerList = new ArrayList<>();
        // index记录当前行遍历到的节点，count记录当前行的总节点
        int index = 0, count = 1;
        layer.add(root);
        
        while(!layer.isEmpty()) {
            TreeNode node = layer.remove();
            layerList.add(node.val);
            index++;
            if(node.left != null) {
                layer.add(node.left);
            }
            if(node.right != null) {
                layer.add(node.right);
            }
            
            // 当遍历完了，则将记录的值都记录到result当中 
            if(index == count) {
                index = 0;
                count = layer.size();
                result.add(layerList);
                layerList = new ArrayList<>();
            }
        }
        
        return result;
    }
}
```

## 32-2. <span id="32-2">把二叉树打印成多行</span>

来源：[NowCoder](https://www.nowcoder.com/practice/445c44d982d04483b04a54f298796288?tpId=13&tqId=11213&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

### 题目描述

从上到下按层打印二叉树，同一层的结点按从左到右的顺序打印，每一层打印到一行。

### 样例

```
输入如下图所示二叉树[8, 12, 2, null, null, 6, null, 4, null, null, null]
    8
   / \
  12  2
     /
    6
   /
  4

输出：[[8], [12, 2], [6], [4]]
```

### 题解

```java
class Solution {
    List<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(pRoot == null) {
            return result;
        }
        
        Queue<TreeNode> layer = new LinkedList<>();
        ArrayList<Integer> layerList = new ArrayList<>();
        layer.add(pRoot);
        int index = 0, count = 1;
        while(!layer.isEmpty()) {
            TreeNode cur = layer.remove();
            layerList.add(cur.val);
            index++;
            if(cur.left != null) {
                layer.add(cur.left);
            }
            if(cur.right != null) {
                layer.add(cur.right);
            }
            if(index == count) {
                count = layer.size();
                index = 0;
                result.add(layerList);
                layerList = new ArrayList<>();
            }
        }
        
        return result;
    }
}
```

## 32-3. <span id="32-3">之字形打印二叉树</span>

来源：[NowCoder](https://www.nowcoder.com/practice/91b69814117f4e8097390d107d2efbe0?tpId=13&tqId=11212&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

### 题目描述

请实现一个函数按照之字形顺序从上向下打印二叉树。

即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。

### 样例

```
输入如下图所示二叉树[8, 12, 2, null, null, 6, 4, null, null, null, null]
    8
   / \
  12  2
     / \
    6   4
输出：[[8], [2, 12], [6, 4]]
```

### 题解

```java
class Solution {
    public List<List<Integer>> printFromTopToBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        // 用于记录行
        int index = 1;
        // 用于存放奇数行的节点
        Stack<TreeNode> oddStack = new Stack<>();
        // 用于存放偶数行的节点
        Stack<TreeNode> evenStack = new Stack<>();
        oddStack.push(root);
        
        while(!oddStack.empty() || !evenStack.empty()) {
            List<Integer> layerList = new ArrayList<>();
            if(index % 2 != 0) {
                while(!oddStack.empty()) {
                    TreeNode node = oddStack.pop();
                    layerList.add(node.val);
                    pushNode(node.left, evenStack);
                    pushNode(node.right, evenStack);
                }
            }else {
                while(!evenStack.empty()) {
                    TreeNode node = evenStack.pop();
                    layerList.add(node.val);
                    pushNode(node.right, oddStack);
                    pushNode(node.left, oddStack);
                }
            }
            result.add(layerList);
            index++;
        }
        
        return result;
    }
    
    private void pushNode(TreeNode node, Stack<TreeNode> stack) {
        if(node != null) {
            stack.push(node);
        }
    }
}
```

## 34. <span id="47">二叉树中和为某一值的路径</span>

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

## 39. <span id="52">数组中出现次数超过一半的数字</span>

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
