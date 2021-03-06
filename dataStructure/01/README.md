## 复杂度的表示方法

时间复杂度的表示方法：
- 大O复杂表示法
粗略的估算代码运行的时间，从CPU的角度来看，每一行代码都执行类似的操作：读数据->运算->写数据。实际上每一行代码对于CPU执行的时间和个数是不一样，粗略的估计就假设每一行代码运行都是用相同的时间成为一个单位时间，unit_time。

对于下面的代码
```C
int cal(int n) {
int sum = 0;
int i = 1;
for (; i <= n; ++i) {
sum = sum + i;
}
return sum;
}
```
从 CPU 的角度来看，这段代码的每一行都执行着类似的操作：读数据-运算-写数据。尽管每行代码对应的 CPU 执行的个数、执行的时间都不一样，但是，我们这里只是粗略估计，所以可以假设每行代码执行的时间都一样，为 unit_time。在这个假设的基础之上，这段代码的总执行时间是多少呢？
第 2、3 行代码分别需要 1 个 unit_time 的执行时间，第 4、5行都运行了n遍，所以需要2n*unit_time 的执行时间，所以这段代码总的执行时间就是 (2n+2)*unit_time。可以看出来，所有代码的执行时间 T(n)与每行代码的执行次数成正比。

对于下面的代码
```c
int cal(int n) {
    int sum = 0;
    int i = 1;
    int j = 1;
    for (; i <= n; ++i) {
        j = 1;
        for (; j <= n; ++j) {
            sum = sum + i * j;
        }
    }
}
```
我们依旧假设每个语句的执行时间是 unit_time。那这段代码的总执行时间 T(n) 是多少呢？第 2、3、4 行代码，每行都需要 1 个 unit_time 的执行时间，第 5、6 行代码循环执行了 n 遍，需要2n*unit_time 的执行时间，第 7、8 行代码循环执行了 n 遍，所以需要 2n * unit_time 的执行时间。所以，整段代码总的执行时间 T(n) = (2n +2n+3)*unit_time。尽管我们不知道 unit_time 的具体值，但是通过这两段代码执行时间的推导过程，我们可以得到一个非常重要的规律，那就是，所有代码的执行时间T(n) 与每行代码的执行次数 n 成正比。
```math
T(n) = O(f(n))
```
，T(n) 我们已经讲过了，它表示代码执行的时间；n 表示数据规模的大小；f(n) 表示每行代码执行的次数总和。因为这是一个公式，所以用 f(n) 来表示。公式中的O，表示代码的执行时间 T(n) 与 f(n) 表达式成正比。

所以，第一个例子中的 T(n) = O(2n+2)，第二个例子中的 T(n) = O(2n^2 +2n+3)。这就是大 O 时间复杂度表示法。大 O 时间复杂度实际上并不具体表示代码真正的执行时间，而是表示代码执行时间随数据规模增长的变化趋势，所以，也叫作渐进时间复杂度（asymptotic time complexity），简称时间复杂度。

当 n 很大时，你可以把它想象成 10000、100000。而公式中的低阶、常量、系数三部分并不左右增长趋势，所以都可以忽略。我们只需要记录一个最大量级就可以了，如果用大 O 表示法表示刚讲的那两段代码的时间复杂度，就可以记为：
```math
T(n) = O(n)
```
```math
T(n) = O(n^2)
```

## 时间复杂度的分析方法

- 只需要关注执行次数最多的一段代码

大O这种复杂度表示方法只是表示一种变化趋势。我们通常会忽略掉公式中的常量、低阶、系数，只需要记录一个最大阶的量级就可以了。所以，我们在分析一个算法、一段代码的时间复杂度的时候，也只关注循环执行次数最多的那一段代码就可以了。这段核心代码执行次数的n的量级，就是整段要分析代码的时间复杂度。

```c
int cal(int n) {
    int sum = 0;
    int i = 1;
    for (; i <= n; ++i) {
        sum = sum + i;
    }
    return sum;
}
```
其中第 2、3 行代码都是常量级的执行时间，与 n 的大小无关，所以对于复杂度并没有影响。循环执行次数最多的是第 4、5 行代码，所以这块代码要重点分析。前面我们也讲过，这两行代码被执行了 n 次，所以总的时间复杂度就是 O(n)。

- 总复杂度等于量化级最大的那一段代码的复杂度(加法原则)

- 嵌套代码的复杂度等于嵌套内外代码复杂度的乘积
如果 T1(n)=O(f(n))，T2(n)=O(g(n))；那么 T(n)=T1(n)*T2(n)=O(f(n))*O(g(n))=O(f(n)*g(n)).
也就是说，假设 T1(n) = O(n)，T2(n) = O(n^2)，则 T1(n) * T2(n) = O(n^3)。

```c
int cal(int n) {
    int ret = 0;
    int i = 1;
    for (; i < n; ++i) {
        ret = ret + f(i);
    }
}

int f(int n) {
    int sum = 0;
    int i = 1;
    for (; i < n; ++i) {
        sum = sum + i;
    }
    return sum;
}
```
单独看 cal() 函数。假设 f() 只是一个普通的操作，那第 4～6 行的时间复杂度就是，T1(n) =
O(n)。但 f() 函数本身不是一个简单的操作，它的时间复杂度是 T2(n) = O(n)，所以，整个 cal() 函数
的时间复杂度就是，T(n) = T1(n) * T2(n) = O(n*n) = O(n^2)。

## 几种常见时间复杂度实例分析

### 常量阶O(1)
O(1) 只是常量级时间复杂度的一种表示方法，并不是指只执行了一行代码。比如这段代码，即便有 3 行，它的时间复杂度也是 O(1），而不是 O(3)。
```
int i = 8;
int j = 12;
int sum = i + j;
```
只要代码的执行时间不随 n 的增大而增长，这样代码的时间复杂度我们都记作O(1)。或者说，一般情况下，只要算法中不存在循环语句、递归语句，即使有成千上万行的代码，其时间复杂度也是Ο(1)。

### 对数阶O(logn) & 线性对数阶O(nlogn)

这两种时间复杂度是十分的难分析的
```c
i=1;
while (i <= n) {
    i = i * 2;
}
```
第三行代码是循环执行次数最多的。所以，我们只要能计算出这行代码被执行了多少次，就能知道整段代码的时间复杂度。
从代码中可以看出，变量 i 的值从 1 开始取，每循环一次就乘以 2。当大于 n 时，循环结束。还记得我们高中学过的等比数列吗？实际上，变量 i 的取值就是一个等比数列。如果我把它一个一个列出来，就应该是这个样子的：
```
2^0 2^1 2^2 ... 2 ^x=n
```
只要知道 x 值是多少，就知道这行代码执行的次数了。通过 2^x =n 求解 x 这个问题我们想
高中应该就学过了，我就不多说了。x=log n，所以，这段代码的时间复杂度就是 O(log2n)。

```c
i=1;
while (i <= n) {
    i = i * 3;
}
```
很简单就能看出来，这段代码的时间复杂度为 O(log_3n)。

对数之间是可以互相转换的，log3n 就等于 log_3 2 * log_2n，所以 O(log3n) = O(C *log2n)，其中 C=log 2 是一个常量。基于我们前面的一个理论：在采用大 O 标记复杂度的时候，可以忽略系数，即 O(Cf(n)) = O(f(n))。所以，O(log n) 就等于 O(log n)。因此，在对数阶时间复杂度的表示方法里，我们忽略对数的“底”，统一表示为 O(logn)。

如果一段代码的时间复杂度是 O(logn)，我们循环执行 n 遍，时间复杂度就是 O(nlogn) 了。而且，O(nlogn) 也是一种非常常见的算法时间复杂度。比如，归并排序、快速排序的时间复杂度都是
O(nlogn)。

### O(m+n)、O(m*n)
```
int cal(int m, int n) {
    int sum_1 = 0;
    int i = 1;
    for (; i < m; ++i) {
        sum_1 = sum_1 + i;
    }
    int sum_2 = 0;
    int j = 1;
    for (; j < n; ++j) {
        sum_2 = sum_2 + j;
    }
    return sum_1 + sum_2;`
}
```
m 和 n 是表示两个数据规模。我们无法事先评估 m 和 n 谁的量级大，所以我们在表示复杂度的时候，就不能简单地利用加法法则，省略掉其中一个。所以，上面代码的时间复杂度就是 O(m+n)。
针对这种情况，原来的加法法则就不正确了，我们需要将加法规则改为：T1(m) + T2(n) = O(f(m) +g(n))。但是乘法法则继续有效：T1(m)*T2(n) = O(f(m) * f(n))。

## 空间复杂度

时间复杂度的全称是渐进时间复杂度，表示算法的执行时间与数据规模之间的增长关系。类比一下，空间复杂度全称就是渐进空间复杂度（asymptotic space complexity），表示算法的存储空间与数据规模之间的增长关系。

## 分析复杂度
- 最好情况时间复杂度（best case time complexity）
- 最坏情况时间复杂度（worst case time complexity）
- 平均情况时间复杂度（average case time complexity）
- 均摊时间复杂度（amortized time complexity）

### 最好情况时间复杂度（best case time complexity）
最好情况时间复杂度就是，在最理想的情况下，执行这段代码的时间复杂度。例如在查找一个数组元素的时候，从头按个查找的时候，在最理想的情况下，要查找的变量 x 正好是数组的第一个元素，这个时候对应的时间复杂度就是最好情况时间复杂度。

### 最坏情况时间复杂度（worst case time complexity）
最坏情况时间复杂度就是，在最糟糕的情况下，执行这段代码的时间复杂度。例如在查找一个数组元素的时候，从头按个查找的时候，如果数组中没有要查找的变量 x，我们需要把整个数组都遍历一遍才行，所以这种最糟糕情况下对应的时间复杂度就是最坏情况时间复杂度。

### 平均情况时间复杂度（average case time complexity）

最好情况时间复杂度和最坏情况时间复杂度对应的都是极端情况下的代码复杂度，发生的概率其实并不大。
各个可能出现情况乘这个情况的概率的和就是平均情况时间复杂度