# 剑指Offer题解 10-19

## 10-1. <span id="10-1">斐波那契数列</span>

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

## 10-3. <span id="10-3">跳台阶</span>

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

## 10-4. <span id="10-4">变态跳台阶</span>

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

## 11. <span id="11">旋转数组的最小数字</span>

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
