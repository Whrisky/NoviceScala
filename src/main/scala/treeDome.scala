import scala.collection.mutable.ArrayBuffer

object treeDome {
    val  arr : ArrayBuffer[NodeInfo]  = new ArrayBuffer()
    case class TreeNode[T] (data : T ,children : Seq[TreeNode[T]] = Nil)

    case class NodeInfo(name: String,  parent : NodeInfo , high : Int , var siblings : Int = 0 ,var last : Boolean = false )

    def asciiDisplay(root : TreeNode[String]) : Seq[String]= {
//        val strArr = new ArrayBuffer[String]()
        accessNode(root, null, 0, 0)
        val strArr= arr.map{x =>
                if(x.name == "|"){
                    visitNode(s"${x.name}", x)
                }else{
                    visitNode(s"+-${x.name}", x)
                }

        }
        strArr
    }

    def visitNode(str: String, node : NodeInfo) : String = {
        if(node.parent == null){
            s"$str"
        }else{
            if(node.parent.siblings == 1 && (!node.parent.last)){
                visitNode(s"| $str", node.parent)
            }else{
                visitNode(s"  $str", node.parent)
            }

        }
    }

    def accessNode(root : TreeNode[String], parent : NodeInfo , high : Int , siblings : Int , last : Boolean = true): Unit ={
        val aNode = NodeInfo(root.data, parent, high)
        aNode.last = last
        arr.append(aNode)
        root.children match {
            case Seq() =>
            case _ =>
                val kids = root.children
                for(i <- 1 to  kids.length){
                    if(i == kids.length){
                        accessNode(kids(i-1), aNode, high +1, 1, true)
                    }
                    else{
                        accessNode(kids(i-1), aNode, high +1, 1, false)
                    }

                }
                if(!last && (root.children.length!=0)){
                    val nilNode  = new NodeInfo("|", parent, high, 1, true)
                    arr.append(nilNode)
                }

        }
        aNode.siblings = siblings
    }
    asciiDisplay(TreeNode("Root",
        children = List(
            TreeNode("level1-1", children = TreeNode("level2-1", children = TreeNode("level3-1") :: Nil) :: Nil),
            TreeNode("level1-2"),
            TreeNode("level1-3")))).foreach(println)

}
