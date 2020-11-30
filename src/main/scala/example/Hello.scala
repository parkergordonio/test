package example

import scala.util.control.Breaks._

object Hello extends App {
  println("Sum for 7: Should be: 0, 3; " + twoSumNaive(Array(1, 3, 5, 6, 2, 5), 7).mkString(","))
  println("Sum for 8: should be: 1, 3; " + twoSumNaive(Array(4, 2, 5, 6, 2, 5), 8).mkString(","))
  println("Sum for 8: should be: 0, 1; " + twoSumNaive(Array(3, 3), 6).mkString(","))

  def twoSumNaive(nums: Array[Int], target: Int): Array[Int] = {
    var pair: Array[Int] = null
    var rem: Map[Int, Int] = Map.empty

    breakable {
      nums.zipWithIndex.foreach { case (value, index) =>
        rem.get(value) match {
          case Some(remMatch) =>
            pair = Array(remMatch, index)
            break()
          case _ =>
        }
        rem = rem + ((target - value) -> index)
      }
    }

    pair
  }
}
