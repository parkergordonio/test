package example

import scala.collection.mutable
import scala.util.control.Breaks.{breakable, break}

object Hello extends App {
  println("Sum for 7: Should be: 0, 3; " + twoSumNaive(Array(1, 3, 5, 6, 2, 5), 7).mkString(","))
  println("Sum for 8: should be: 1, 3; " + twoSumNaive(Array(4, 2, 5, 6, 2, 5), 8).mkString(","))
  println("Sum for 8: should be: 0, 1; " + twoSumNaive(Array(3, 3), 6).mkString(","))

  def twoSumNaive(nums: Array[Int], target: Int): Array[Int] = {
    var pair: Array[Int] = null
    val rem: mutable.Map[Int, Int] = mutable.Map.empty

    breakable {
      nums.indices.foreach { i =>
        val value = nums(i)
        rem.get(value) match {
          case Some(remMatch) =>
            pair = Array(remMatch, i)
            break()
          case _ =>
        }
        rem += ((target - value) -> i)
      }
    }

    pair
  }
}
