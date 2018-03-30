import org.specs2.Specification
import printTree.{TreeNode, asciiDisplay}

class printTreeTest extends  Specification{
    def is =
        s2"""
          Here is sbt "inspect tree compile:compile"
            asciiDisplay                                $asciiDisplayTest

        """
    def asciiDisplayTest ={
        asciiDisplay(TreeNode("Root",
            children = List(
                TreeNode("level1-1", children = TreeNode("level2-1", children = TreeNode("level3-1") :: Nil) :: Nil),
                TreeNode("level1-2"),
                TreeNode("level1-3")))).foreach(println)
        ok
    }


    def asciiDisplayMoreChildrenTest = {
        val child4_1 =  List(TreeNode("level5-1"))
        val child3_1 = List(TreeNode("level4-1", child4_1 :::child4_1))
        val child2_1 = List(TreeNode("level3-1", child3_1 :::child4_1))
        val child1_1 = List(TreeNode("level2-1", child2_1),TreeNode("level2-1"),TreeNode("level2-1"))
        val child1_2 = List(TreeNode("level2-1"))
        val child = List(TreeNode("level1-1", child1_1), TreeNode("level1-2" , child1_2) , TreeNode("level1-3"))
        val tree = TreeNode("Root" , child)
        asciiDisplay(tree).foreach(println)

        ok
    }


}
