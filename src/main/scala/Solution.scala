object Solution  {
    def intersection(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
        var map = scala.collection.mutable.Map[Int, Int]()
        var res : Array[Int] = Array.empty
        nums1.map(x => map += (x -> 0))
        for(num <- nums1) map(num)= map(num)+1
        for(num <- nums2) {
            if(map.contains(num)) res +:= num
        }
        res.distinct
    }
    def intersect2(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
        var map = scala.collection.mutable.Map[Int, Int]()
        var res : Array[Int] = Array.empty
        nums1.map(x => map += (x -> 0))
        for(num <- nums1) map(num) += 1
        for(num <- nums2){
            if(map.contains(num) && map(num)> 0){
                res +:= num
                map(num) -= 1

            }
        }
        res
    }

    val num1 = Array(1,2,2,1)
    val num2 = Array(2,2)
    intersection(num1, num2).map(print(_))
    println()
    intersect2(num1, num2).map(print(_))
}
