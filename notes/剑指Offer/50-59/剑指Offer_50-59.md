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
</br>
