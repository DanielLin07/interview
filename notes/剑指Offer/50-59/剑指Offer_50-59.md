# 剑指Offer题解 50-59

## 50. <span id="50">第一个只出现一次的字符</span>

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

## 52. <span id="52">两个链表的第一个公共结点</span>

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

## 53. <span id="53">数字在排序数组中出现的次数</span>

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

## 55-1. <span id="55-1">二叉树的深度</span>

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

## 55-2. <span id="55-2">平衡二叉树</span>

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

## 56. <span id="56">数组中只出现一次的数字</span>

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

## 57-1. <span id="57-1">和为S的两个数字</span>

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

## 57-2. <span id="57-2">和为S的连续正数序列</span>

来源：[NowCoder](https://www.nowcoder.com/practice/c451a3fd84b64cb19485dad758a55ebe?tpId=13&tqId=11194&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

### 题目描述

输入一个正数s，打印出所有和为s的连续正数序列（至少含有两个数）。

例如输入15，由于1+2+3+4+5=4+5+6=7+8=15，所以结果打印出3个连续序列1～5、4～6和7～8。

### 样例

```
输入：15

输出：[[1,2,3,4,5],[4,5,6],[7,8]]
```

### 题解

```java
class Solution {
    public List<List<Integer>> findContinuousSequence(int sum) {
        // 用于记录结果
        List<List<Integer>> result = new ArrayList<>();
        // 双指针指定窗口
        int pLow = 0, pHigh = 1;
        while(pLow < pHigh) {
            // 计算连续正数序列的和：S =（a0 + an）* n / 2
            int cur = (pLow + pHigh) * (pHigh - pLow + 1) / 2;
            // 如果窗口内的和刚好相等，就将窗口范围的所有数添加进结果集
            if(cur == sum) {
                List<Integer> subResult = new ArrayList<>();
                for(int i = pLow; i <= pHigh; i++) {
                    subResult.add(i);
                }
                result.add(subResult);
                pLow++;
            // 如果当前窗口内的值之和小于sum，那么右边窗口右移一下
            }else if(cur < sum) {
                pHigh++;
            // 如果当前窗口内的值之和大于sum，那么左边窗口右移一下
            }else {
                pLow++;
            }
        }
        return result;
    }
}
```
</br>

## 58-2. <span id="58-2">左旋转字符串</span>

来源：[NowCoder](https://www.nowcoder.com/practice/12d959b108cb42b1ab72cef4d36af5ec?tpId=13&tqId=11196&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking)

### 题目描述

字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。

请定义一个函数实现字符串左旋转操作的功能。

比如输入字符串"abcdefg"和数字2，该函数将返回左旋转2位得到的结果"cdefgab"。

**注意**：

- 数据保证n小于等于输入字符串的长度。

### 样例

```
输入："abcdefg" , n=2

输出："cdefgab"
```

### 题解

```java
class Solution {
    public String leftRotateString(String str,int n) {
        if(str == null || str.length() == 0) {
            return "";
        }
        int length = str.length();
        // 取余使得左旋位数一定小于字符串长度
        n = n % length;
        // 构建两倍长的重复字符串
        str += str;
        return str.substring(n, length + n);
    }
}
```
</br>
