#Fisher–Yates Shuffle
'''
 1. 从还没处理的数组（假如还剩k个）中，随机产生一个[0, k]之间的数字p（假设数组从0开始）；
 2. 从剩下的k个数中把第p个数取出；
 3. 重复步骤2和3直到数字全部取完；
 4. 从步骤3取出的数字序列便是一个打乱了的数列。
'''
import random

def shuffle(lis):
    result = []
    while lis:
        p = random.randrange(0, len(lis))
        result.append(lis[p])
        lis.pop(p)
    return result

r = shuffle([1, 2, 2, 3, 3, 4, 5, 10])
print(r)