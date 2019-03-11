# 输入一个矩阵（行列相等的二维数组，按照从外向内以顺时针的
# 顺序依次打印出每一个数字，以逗号隔开）
# -----------------
# 输入描述
# 二维数组对应的字符串
# 输出描述
# 二维数组对应的一串数字
# ----------------
# 输入
# [[2,3,6],[5,5,9],[3,6,9]]
# 输出
# 2,3,6,9,9,6,3,5,5



matrix = [[2,3,6],[5,5,9],[3,6,9]]
# matrix = input()
row=len(matrix)
column=len(matrix[0])
left=0
right=column-1
top=0
boom=row-1
res=[]
while right>left and top<boom:
    #从左到右
    for i in range(left,right+1):
        res.append(matrix[top][i])
    #从上到下
    for i in range(top+1,boom+1):
        res.append(matrix[i][right])
    #从右到左
    for i in range(right-1,left-1,-1):
        res.append(matrix[boom][i])
    #从下到上
    for i in range(boom-1,top,-1):
        res.append(matrix[i][left])
    left+=1
    right-=1
    top+=1
    boom-=1
#剩下一行
if boom==top and left<right:
    for i in range(left,right+1):
        res.append(matrix[boom][i])
#剩下一列
if left==right and boom>top:
    for i in range(top,boom+1):
        res.append(matrix[i][left])
#剩下一个
if boom==top and left==right:
    res.append(matrix[left][top])

print(res)