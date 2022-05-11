package com.example.benchmark

import androidx.benchmark.junit4.BenchmarkRule
import androidx.benchmark.junit4.measureRepeated
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.example.benchmark.DPointRegular
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.math.sqrt

@JvmInline
value class DPointMFVC(val x: Double, val y: Double)

@RunWith(AndroidJUnit4::class)
class ValueClassesGeneration {
    @get:Rule
    val benchmarkRule = BenchmarkRule()

    @Test
    fun generateRegular() {
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
    fun generateMFVC() {
        var x = 0.0
        var y = 2.0
        var point = DPointMFVC(x, y)
        benchmarkRule.measureRepeated {
            point = DPointMFVC(x, y)
            x++
            y++
        }
    }

    private fun escape(point: DPointMFVC) = Unit
    private fun escape(point: DPointRegular) = Unit

    @Test
    fun generateEscapingRegular() {
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
    fun generateEscapingMFVC() {
        var x = 0.0
        var y = 2.0
        var point: DPointMFVC
        benchmarkRule.measureRepeated {
            point = DPointMFVC(x, y)
            x++
            y++
            escape(point)
        }
    }
}

@RunWith(AndroidJUnit4::class)
class ValueClassSearch {
    @get:Rule
    val benchmarkRule = BenchmarkRule()

    private val phi = (1 + sqrt(5.0)) / 2
    private val multiplier = 100.0

    private val p1X = -multiplier
    private val p1Y = -multiplier

    private val p2X = phi * multiplier
    private val p2Y = phi * multiplier

    private fun Double.square() = this * this

    private fun distance(p1: DPointRegular, p2: DPointRegular) =
        sqrt((p1.x - p2.x).square() + (p1.y - p2.y).square())

    private fun distance(p1: DPointMFVC, p2: DPointMFVC) =
        sqrt((p1.x - p2.x).square() + (p1.y - p2.y).square())


    private fun searchRegular(threshold: Double) = benchmarkRule.measureRepeated {
        var p1 = DPointRegular(p1X, p1Y)
        var p2 = DPointRegular(p2X, p2Y)
        while (distance(p1, p2) > threshold) {
            val mid = DPointRegular(p1.x / 2 + p2.x / 2, p1.y / 2 + p2.y / 2)
            if (mid.x > 0 && mid.y > 0) {
                p2 = mid
            } else {
                p1 = mid
            }
        }
    }


    private fun searchMFVC(threshold: Double) = benchmarkRule.measureRepeated {
        var p1 = DPointMFVC(p1X, p1Y)
        var p2 = DPointMFVC(p2X, p2Y)
        while (distance(p1, p2) > threshold) {
            val mid = DPointMFVC(p1.x / 2 + p2.x / 2, p1.y / 2 + p2.y / 2)
            if (mid.x > 0 && mid.y > 0) {
                p2 = mid
            } else {
                p1 = mid
            }
        }
    }

    @Test
    fun `searchMFVC-1e-1`() {
        searchMFVC(1e-1)
    }

    @Test
    fun `searchMFVC-1e-3`() {
        searchMFVC(1e-3)
    }

    @Test
    fun `searchMFVC-1e-5`() {
        searchMFVC(1e-5)
    }

    @Test
    fun `searchRegular-1e-1`() {
        searchRegular(1e-1)
    }

    @Test
    fun `searchRegular-1e-3`() {
        searchRegular(1e-3)
    }

    @Test
    fun `searchRegular-1e-5`() {
        searchRegular(1e-5)
    }
}