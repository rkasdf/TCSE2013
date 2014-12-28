class Solution:
    def twoSum(self, num, target):
        i = 1
        numbersmap = {}
        for numbers in num:
            numbersmap[numbers] = i
            i += 1
        index1 = 1
        index2 = 0
        for numbers in num:
            yushu  = target - numbers
            if(numbersmap.has_key(yushu)):
                index2 =  numbersmap.get(yushu)
                if  (index1 != index2):
                    break
            index1 += 1
        if(index1 > index2):
            return (index2, index1)
        else:
            return (index1, index2)

numbers = [4, 2, 3, 15]
target = 6
a = Solution()
b = a.twoSum(numbers, target)
print b
