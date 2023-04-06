package com.example.benchmark.valueClasses

import androidx.benchmark.junit4.BenchmarkRule
import androidx.benchmark.junit4.measureRepeated
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.benchmark.DPointMfvc
import com.example.benchmark.DPointRegular
import com.example.benchmark.valueClasses.ValueClassesBoxUsage.Box.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ValueClassesBoxUsage {
    @get:Rule
    val benchmarkRule = BenchmarkRule()
    private val count = 10

    enum class Box { NotUsingLocally, UsingLocally, UsingPassed, NotUsingPassed }

    private fun regular(box: Box) {
        when (box) {
            NotUsingLocally -> benchmarkRule.measureRepeated {
                val point = DPointRegular(1.0, 2.0)
                repeat(count) {
                    double1 = point.x
                    double2 = point.y
                }
            }
            UsingLocally -> benchmarkRule.measureRepeated {
                val point = DPointRegular(1.0, 2.0)
                repeat(count) {
                    any = point
                    double1 = point.x
                    double2 = point.y
                }
            }
            UsingPassed -> benchmarkRule.measureRepeated {
                val point = DPointRegular(1.0, 2.0)
                repeat(count) { usePassedBox(point) }
            }
            NotUsingPassed -> benchmarkRule.measureRepeated {
                val point = DPointRegular(1.0, 2.0)
                repeat(count) { doNotUsePassedBox(point) }
            }
        }
    }

    @Test
    fun regularUsingLocally() = regular(UsingLocally)

    @Test
    fun regularNotUsingLocally() = regular(NotUsingLocally)

    @Test
    fun regularUsingPassed() = regular(UsingPassed)

    @Test
    fun regularNotUsingPassed() = regular(NotUsingPassed)

    private fun mfvc(box: Box) {
        when (box) {
            NotUsingLocally -> benchmarkRule.measureRepeated {
                val point = DPointMfvc(1.0, 2.0)
                repeat(count) {
                    double1 = point.x
                    double2 = point.y
                }
            }
            UsingLocally -> benchmarkRule.measureRepeated {
                val point = DPointMfvc(1.0, 2.0)
                repeat(count) {
                    any = point
                    double1 = point.x
                    double2 = point.y
                }
            }
            UsingPassed -> benchmarkRule.measureRepeated {
                val point = DPointMfvc(1.0, 2.0)
                repeat(count) { usePassedBox(point) }
            }
            NotUsingPassed -> benchmarkRule.measureRepeated {
                val point = DPointMfvc(1.0, 2.0)
                repeat(count) { doNotUsePassedBox(point) }
            }
        }
    }

    @Test
    fun mfvcUsingLocally() = mfvc(UsingLocally)

    @Test
    fun mfvcNotUsingLocally() = mfvc(NotUsingLocally)

    @Test
    fun mfvcUsingPassed() = mfvc(UsingPassed)

    @Test
    fun mfvcNotUsingPassed() = mfvc(NotUsingPassed)

    private fun mfvcSmart(box: Box) {
        when (box) {
            NotUsingLocally -> benchmarkRule.measureRepeated {
                val point = DPointMfvc(1.0, 2.0)
                val boxOrNull = point as DPointMfvc?
                repeat(count) {
                    double1 = point.x
                    double2 = point.y
                }
            }
            UsingLocally -> benchmarkRule.measureRepeated {
                val point = DPointMfvc(1.0, 2.0)
                val boxOrNull = point as DPointMfvc?
                repeat(count) {
                    any = boxOrNull ?: point
                    double1 = point.x
                    double2 = point.y
                }
            }
            UsingPassed -> benchmarkRule.measureRepeated {
                val point = DPointMfvc(1.0, 2.0)
                val boxOrNull = point as DPointMfvc?
                repeat(count) { usePassedBox(boxOrNull, point) }
            }
            NotUsingPassed -> benchmarkRule.measureRepeated {
                val point = DPointMfvc(1.0, 2.0)
                val boxOrNull = point as DPointMfvc?
                repeat(count) { doNotUsePassedBox(boxOrNull, point) }
            }
        }
    }

    @Test
    fun mfvcSmartUsingLocally() = mfvcSmart(UsingLocally)

    @Test
    fun mfvcSmartNotUsingLocally() = mfvcSmart(NotUsingLocally)

    @Test
    fun mfvcSmartUsingPassed() = mfvcSmart(UsingPassed)

    @Test
    fun mfvcSmartNotUsingPassed() = mfvcSmart(NotUsingPassed)

    private fun usePassedBox(box: DPointMfvc?, point: DPointMfvc) {
        any = box ?: point
        double1 = point.x
        double2 = point.y
    }

    private fun doNotUsePassedBox(box: DPointMfvc?, point: DPointMfvc) {
        double1 = point.x
        double2 = point.y
    }

    private fun usePassedBox(point: DPointMfvc) {
        any = point
        double1 = point.x
        double2 = point.y
    }

    private fun doNotUsePassedBox(point: DPointMfvc) {
        double1 = point.x
        double2 = point.y
    }

    private fun usePassedBox(point: DPointRegular) {
        any = point
        double1 = point.x
        double2 = point.y
    }

    private fun doNotUsePassedBox(point: DPointRegular) {
        double1 = point.x
        double2 = point.y
    }

    private var double1 = 0.0
    private var double2 = 0.0
    private var any: Any? = null
}
