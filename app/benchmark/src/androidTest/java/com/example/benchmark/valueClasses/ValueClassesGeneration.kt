package com.example.benchmark.valueClasses

import androidx.benchmark.junit4.BenchmarkRule
import androidx.benchmark.junit4.measureRepeated
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.benchmark.DPointMfvc
import com.example.benchmark.DPointRegular
import com.example.benchmark.OuterDPointMfvc
import com.example.benchmark.OuterDPointRegular
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ValueClassesGeneration {

    @Suppress("UNUSED_PARAMETER")
    private fun escape(point: DPointMfvc) = Unit
    @Suppress("UNUSED_PARAMETER")
    private fun escape(point: DPointRegular) = Unit
    
    @get:Rule
    val benchmarkRule = BenchmarkRule()

    @Test
    @Suppress("ASSIGNED_BUT_NEVER_ACCESSED_VARIABLE")
    fun generateDPointsRegular() {
        var x = 0.0
        var y = 2.0
        var point = DPointRegular(x, y)
        benchmarkRule.measureRepeated {
            point = DPointRegular(x, y)
            x++
            y++
        }
    }

    @Test
    @Suppress("ASSIGNED_BUT_NEVER_ACCESSED_VARIABLE")
    fun generateDPointsMFVC() {
        var x = 0.0
        var y = 2.0
        var point = DPointMfvc(x, y)
        benchmarkRule.measureRepeated {
            point = DPointMfvc(x, y)
            x++
            y++
        }
    }

    @Test
    fun generateDPointsEscapingRegular() {
        var x = 0.0
        var y = 2.0
        var point: DPointRegular
        benchmarkRule.measureRepeated {
            point = DPointRegular(x, y)
            x++
            y++
            escape(point)
        }
    }

    @Test
    fun generateDPointsEscapingMFVC() {
        var x = 0.0
        var y = 2.0
        var point: DPointMfvc
        benchmarkRule.measureRepeated {
            point = DPointMfvc(x, y)
            x++
            y++
            escape(point)
        }
    }


    @Suppress("UNUSED_PARAMETER")
    private fun escapeOuter(point: OuterDPointMfvc) = Unit
    @Suppress("UNUSED_PARAMETER")
    private fun escapeOuter(point: OuterDPointRegular) = Unit

    @Test
    @Suppress("ASSIGNED_BUT_NEVER_ACCESSED_VARIABLE")
    fun generateOuterDPointsRegular() {
        var x = 0.0
        var y = 2.0
        var point = OuterDPointRegular(DPointRegular(x, y))
        benchmarkRule.measureRepeated {
            point = OuterDPointRegular(DPointRegular(x, y))
            x++
            y++
        }
    }

    @Test
    @Suppress("ASSIGNED_BUT_NEVER_ACCESSED_VARIABLE")
    fun generateOuterDPointsMFVC() {
        var x = 0.0
        var y = 2.0
        var point = OuterDPointMfvc(DPointMfvc(x, y))
        benchmarkRule.measureRepeated {
            point = OuterDPointMfvc(DPointMfvc(x, y))
            x++
            y++
        }
    }

    @Test
    fun generateOuterDPointsEscapingRegular() {
        var x = 0.0
        var y = 2.0
        var point: OuterDPointRegular
        benchmarkRule.measureRepeated {
            point = OuterDPointRegular(DPointRegular(x, y))
            x++
            y++
            escapeOuter(point)
        }
    }

    @Test
    fun generateOuterDPointsEscapingMFVC() {
        var x = 0.0
        var y = 2.0
        var point: OuterDPointMfvc
        benchmarkRule.measureRepeated {
            point = OuterDPointMfvc(DPointMfvc(x, y))
            x++
            y++
            escapeOuter(point)
        }
    }
}