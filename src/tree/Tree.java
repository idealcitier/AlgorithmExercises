public interface Tree<T extends Comparable>{
	// 判断是否为空
	boolean isEmpty();

	// 返回树的结点个数
	int size();

	// 返回二叉树的高度和深度，即结点的最大层数
	int height();

	// 前序遍历
	String proOrder();

	// 中序遍历 
	String inOrder();

	// 后序遍历
	String postOrder();

	// 层次遍历
	String levelOrder();
	
	// 将data插入
	void insert(T data);

	// 删除某个值
	void remove(T data);

	// 查找最大值
	T findMax();

	// 查找最小值
	T findMin();

	// 根据值查找该节点
	BinaryNode findNode(T data);

	// 判断是否包含某个值
	boolean contains(T data) throws Exception;

	// 清空
	void clear();
}
