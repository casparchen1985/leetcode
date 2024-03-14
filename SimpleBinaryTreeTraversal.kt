
fun main() {
    // prepare data
    val treeNode7 = MyTreeNode(7)
    val treeNode6 = MyTreeNode(6)
    val treeNode3 = MyTreeNode(3, treeNode6, treeNode7)
    val treeNode5 = MyTreeNode(5)
    val treeNode4 = MyTreeNode(4)
    val treeNode2 = MyTreeNode(2, treeNode4, treeNode5)
    val treeNode1 = MyTreeNode(1, treeNode2, treeNode3)
    
    // execute
//    val ans = preorder(treeNode1)
//    val ans = postorder(treeNode1)
    val ans = inorder(treeNode1)
    
    // check
    println("$ans")
}

// recursive function
fun preorder(root: MyTreeNode?): List<Int> {
    if (root == null) return emptyList()
    val output = mutableListOf(root.key)    
    output += preorder(root.left)
    output += preorder(root.right)
    return output
}

fun postorder(root: MyTreeNode?): List<Int> {
    if (root == null) return emptyList()
    val ans = mutableListOf<Int>()
    ans += postorder(root.left)
    ans += postorder(root.right)
    ans.add(root.key)
    return ans
}

fun inorder(root: MyTreeNode?): List<Int> {
    if (root == null) return emptyList()
    val record = mutableListOf<Int>()
    record += inorder(root.left)
    record.add(root.key)
    record += inorder(root.right)
    return record
}


// data structure
class MyTreeNode {
    var key: Int
    var left: MyTreeNode?
    var right: MyTreeNode?
    
    constructor(){
        this.key = 0
        left = null
        right = null
    }
    
    constructor(key: Int) {
        this.key = key
        left = null
        right = null
    }
    
    constructor(key: Int, left: MyTreeNode?, right: MyTreeNode?){
        this.key = key
        this.left = left
        this.right = right
    }
}