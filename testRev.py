a = input()
# a.reverse()
# print(a[::-1])
l = a.split()
nums = []
for i in l:
    nums.append(int(i))

print("min = ",min(nums))
