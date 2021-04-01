# TwoSum
- 목차

[내코드](./TwoSum.js)

[내가 푼 방법](내가-푼-방법-Brute-Force)

[그외 방법](그외-방법)
	[Two-pass Hash Table](Two-pass-Hash-Table)
	[One-pass Hash Table](One-pass-Hash-Table_)



## 내가 푼 방법 : `Brute Force`
- 이중 포문을 이용함

![1DD58450-E6D3-4889-B022-15E737F09CE8](https://user-images.githubusercontent.com/46446434/113300051-82646000-9338-11eb-96b7-7aa6f9ab612d.png)


## 그외 방법
### Two-pass Hash Table
```javascript

```
### One-pass Hash Table

```javascript

var twoSum = function(nums, target) {
    let map = new Map;
    for (var i = 0; i < nums.length; i++) {
        let complement = target - nums[i];
        if (map.has(complement)) {
            return [map.get(complement), i]
        }
        map.set(nums[i], i);
    }
}

```
