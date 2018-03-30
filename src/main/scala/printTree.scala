import scala.collection.mutable.ArrayBuffer

object printTree {

    case class TreeNode[T](data: T, children: Seq[TreeNode[T]] = Nil)

    def asciiDisplay(root: TreeNode[String]): Seq[String] = {
        val res = new ArrayBuffer[String]()

        def visitNode(node: TreeNode[String], prefix: String, isLast: Boolean): Unit = {
            if(node == null){
            }else{
                res.append(s"$prefix+-${node.data}")
                //[1 , n-1)
                if (!isLast && (node.children != Nil)) {
                    val newPrefix = prefix + "| "
                    for (i <- 0 until (node.children.size - 1)) {
                        visitNode(node.children(i), newPrefix, false)
                    }
                    visitNode(node.children.last, newPrefix, true)
                    res.append(newPrefix)
                } else if (isLast && (node.children != Nil)) {
                    val newPrefix = prefix + "  "
                    for (i <- 0 until (node.children.size - 1)) {
                        visitNode(node.children(i), newPrefix, false)
                    }
                    visitNode(node.children.last, newPrefix, true)

                }
            }
        }

        visitNode(root , "" , true)
        res
    }




}
