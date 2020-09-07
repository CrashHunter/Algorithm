package org.crashhunter.algorithm

import android.util.MutableInt
import java.util.*
import kotlin.collections.HashMap

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。

 

示例 1:

输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]
示例 2:

输入: nums = [1], k = 1
输出: [1]
 

提示：

你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
你可以按任意顺序返回答案。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/top-k-frequent-elements
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


 */
class Solution {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            var result = topKFrequent(intArrayOf(1, 1, 1, 2, 2, 3), 2)
            println(result.contentToString())
        }


        fun topKFrequent(nums: IntArray, k: Int): IntArray {
            var map = HashMap<Int, Int>()

            nums.forEach {

                map[it] = (map[it] ?: 0) + 1

            }

            //次数由低到高排列
            var top = map.map { it.value }.sorted()

            //前k高最小值，即top列表 第  top.size - k 位数
            var valueK = top[top.size - k]


            var returnArray = mutableListOf<Int>()

            map.forEach {

                if (it.value >= valueK) {
                    returnArray.add(it.key)
                }

            }
            return returnArray.toIntArray()


        }
    }


}