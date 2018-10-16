# 提取字符串中数字

strInput = input()
# strInput = 'rew2r3gsd5f8h'
temp = filter(str.isdigit, strInput)

print(''.join(list(temp)))

