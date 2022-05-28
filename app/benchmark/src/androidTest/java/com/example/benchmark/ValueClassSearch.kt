package com.example.benchmark

import androidx.benchmark.junit4.BenchmarkRule
import androidx.benchmark.junit4.measureRepeated
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.math.BigInteger
import kotlin.math.sqrt

@RunWith(AndroidJUnit4::class)
class ValueClassSearch {
    @get:Rule
    val benchmarkRule = BenchmarkRule()

    private fun searchDPointsMFVC(n: Double) = benchmarkRule.measureRepeated {
        var p = DPointMFVC(n, n)
        while (p.x != 1.0 && p.y != 1.0) {
            p = DPointMFVC(
                if (p.x % 2 == 0.0) p.x / 2 else 3 * p.x + 1,
                if (p.y % 2 == 0.0) p.y / 2 else 3 * p.y + 1,
            )
        }
    }

    private fun searchDPointsRegular(n: Double) = benchmarkRule.measureRepeated {
        var p = DPointRegular(n, n)
        while (p.x != 1.0 && p.y != 1.0) {
            p = DPointRegular(
                if (p.x % 2 == 0.0) p.x / 2 else 3 * p.x + 1,
                if (p.y % 2 == 0.0) p.y / 2 else 3 * p.y + 1,
            )
        }
    }

    private fun searchIPointsMFVC(n: Int) = benchmarkRule.measureRepeated {
        var p = IPointMFVC(n, n)
        while (p.x != 1 && p.y != 1) {
            p = IPointMFVC(
                if (p.x % 2 == 0) p.x / 2 else 3 * p.x + 1,
                if (p.y % 2 == 0) p.y / 2 else 3 * p.y + 1,
            )
        }
    }

    private fun searchIPointsRegular(n: Int) = benchmarkRule.measureRepeated {
        var p = IPointRegular(n, n)
        while (p.x != 1 && p.y != 1) {
            p = IPointRegular(
                if (p.x % 2 == 0) p.x / 2 else 3 * p.x + 1,
                if (p.y % 2 == 0) p.y / 2 else 3 * p.y + 1,
            )
        }
    }

    private fun searchBIPointsMFVC(n: BigInteger) = benchmarkRule.measureRepeated {
        var p = BIPointMFVC(n, n)
        while (p.x != 1.b && p.y != 1.b) {
            p = BIPointMFVC(
                if (p.x % 2.b == 0.b) p.x / 2.b else 3.b * p.x + 1.b,
                if (p.y % 2.b == 0.b) p.y / 2.b else 3.b * p.y + 1.b,
            )
        }
    }

    private fun searchBIPointsRegular(n: BigInteger) = benchmarkRule.measureRepeated {
        var p = BIPointRegular(n, n)
        while (p.x != 1.b && p.y != 1.b) {
            p = BIPointRegular(
                if (p.x % 2.b == 0.b) p.x / 2.b else 3.b * p.x + 1.b,
                if (p.y % 2.b == 0.b) p.y / 2.b else 3.b * p.y + 1.b,
            )
        }
    }

    private fun searchDPointsMFVCOuter(n: Double) = benchmarkRule.measureRepeated {
        var p = OuterDPointMFVC(DPointMFVC(n, n))
        while (p.value.x != 1.0 && p.value.y != 1.0) {
            p = OuterDPointMFVC(
                DPointMFVC(
                    if (p.value.x % 2 == 0.0) p.value.x / 2 else 3 * p.value.x + 1,
                    if (p.value.y % 2 == 0.0) p.value.y / 2 else 3 * p.value.y + 1,
                )
            )
        }
    }

    private fun searchDPointsRegularOuter(n: Double) = benchmarkRule.measureRepeated {
        var p = OuterDPointRegular(DPointRegular(n, n))
        while (p.value.x != 1.0 && p.value.y != 1.0) {
            p = OuterDPointRegular(
                DPointRegular(
                    if (p.value.x % 2 == 0.0) p.value.x / 2 else 3 * p.value.x + 1,
                    if (p.value.y % 2 == 0.0) p.value.y / 2 else 3 * p.value.y + 1,
                )
            )
        }
    }

    private fun searchIPointsMFVCOuter(n: Int) = benchmarkRule.measureRepeated {
        var p = OuterIPointMFVC(IPointMFVC(n, n))
        while (p.value.x != 1 && p.value.y != 1) {
            p = OuterIPointMFVC(
                IPointMFVC(
                    if (p.value.x % 2 == 0) p.value.x / 2 else 3 * p.value.x + 1,
                    if (p.value.y % 2 == 0) p.value.y / 2 else 3 * p.value.y + 1,
                )
            )
        }
    }

    private fun searchIPointsRegularOuter(n: Int) = benchmarkRule.measureRepeated {
        var p = OuterIPointRegular(IPointRegular(n, n))
        while (p.value.x != 1 && p.value.y != 1) {
            p = OuterIPointRegular(
                IPointRegular(
                    if (p.value.x % 2 == 0) p.value.x / 2 else 3 * p.value.x + 1,
                    if (p.value.y % 2 == 0) p.value.y / 2 else 3 * p.value.y + 1,
                )
            )
        }
    }

    private fun searchBIPointsMFVCOuter(n: BigInteger) = benchmarkRule.measureRepeated {
        var p = OuterBIPointMFVC(BIPointMFVC(n, n))
        while (p.value.x != 1.b && p.value.y != 1.b) {
            p = OuterBIPointMFVC(
                BIPointMFVC(
                    if (p.value.x % 2.b == 0.b) p.value.x / 2.b else 3.b * p.value.x + 1.b,
                    if (p.value.y % 2.b == 0.b) p.value.y / 2.b else 3.b * p.value.y + 1.b,
                )
            )
        }
    }

    private fun searchBIPointsRegularOuter(n: BigInteger) = benchmarkRule.measureRepeated {
        var p = OuterBIPointRegular(BIPointRegular(n, n))
        while (p.value.x != 1.b && p.value.y != 1.b) {
            p = OuterBIPointRegular(
                BIPointRegular(
                    if (p.value.x % 2.b == 0.b) p.value.x / 2.b else 3.b * p.value.x + 1.b,
                    if (p.value.y % 2.b == 0.b) p.value.y / 2.b else 3.b * p.value.y + 1.b,
                )
            )
        }
    }

    @Test
    fun searchDPointsMFVC10() {
        searchDPointsMFVC(10.0)
    }

    @Test
    fun searchDPointsRegular10() {
        searchDPointsRegular(10.0)
    }

    @Test
    fun searchDPointsMFVC100() {
        searchDPointsMFVC(100.0)
    }

    @Test
    fun searchDPointsRegular100() {
        searchDPointsRegular(100.0)
    }

    @Test
    fun searchDPointsMFVC1000() {
        searchDPointsMFVC(1000.0)
    }

    @Test
    fun searchDPointsRegular1000() {
        searchDPointsRegular(1000.0)
    }

    @Test
    fun searchIPointsMFVC10() {
        searchIPointsMFVC(10)
    }

    @Test
    fun searchIPointsRegular10() {
        searchIPointsRegular(10)
    }

    @Test
    fun searchIPointsMFVC100() {
        searchIPointsMFVC(100)
    }

    @Test
    fun searchIPointsRegular100() {
        searchIPointsRegular(100)
    }

    @Test
    fun searchIPointsMFVC1000() {
        searchIPointsMFVC(1000)
    }

    @Test
    fun searchIPointsRegular1000() {
        searchIPointsRegular(1000)
    }

    @Test
    fun searchBIPointsMFVC10() {
        searchBIPointsMFVC(10.b)
    }

    @Test
    fun searchBIPointsRegular10() {
        searchBIPointsRegular(10.b)
    }

    @Test
    fun searchBIPointsMFVC100() {
        searchBIPointsMFVC(100.b)
    }

    @Test
    fun searchBIPointsRegular100() {
        searchBIPointsRegular(100.b)
    }

    @Test
    fun searchBIPointsMFVC1000() {
        searchBIPointsMFVC(1000.b)
    }

    @Test
    fun searchBIPointsRegular1000() {
        searchBIPointsRegular(1000.b)
    }

    @Test
    fun searchDPointsMFVCOuter10() {
        searchDPointsMFVCOuter(10.0)
    }

    @Test
    fun searchDPointsRegularOuter10() {
        searchDPointsRegularOuter(10.0)
    }

    @Test
    fun searchDPointsMFVCOuter100() {
        searchDPointsMFVCOuter(100.0)
    }

    @Test
    fun searchDPointsRegularOuter100() {
        searchDPointsRegularOuter(100.0)
    }

    @Test
    fun searchDPointsMFVCOuter1000() {
        searchDPointsMFVCOuter(1000.0)
    }

    @Test
    fun searchDPointsRegularOuter1000() {
        searchDPointsRegularOuter(1000.0)
    }

    @Test
    fun searchIPointsMFVCOuter10() {
        searchIPointsMFVCOuter(10)
    }

    @Test
    fun searchIPointsRegularOuter10() {
        searchIPointsRegularOuter(10)
    }

    @Test
    fun searchIPointsMFVCOuter100() {
        searchIPointsMFVCOuter(100)
    }

    @Test
    fun searchIPointsRegularOuter100() {
        searchIPointsRegularOuter(100)
    }

    @Test
    fun searchIPointsMFVCOuter1000() {
        searchIPointsMFVCOuter(1000)
    }

    @Test
    fun searchIPointsRegularOuter1000() {
        searchIPointsRegularOuter(1000)
    }

    @Test
    fun searchBIPointsMFVCOuter10() {
        searchBIPointsMFVCOuter(10.b)
    }

    @Test
    fun searchBIPointsRegularOuter10() {
        searchBIPointsRegularOuter(10.b)
    }

    @Test
    fun searchBIPointsMFVCOuter100() {
        searchBIPointsMFVCOuter(100.b)
    }

    @Test
    fun searchBIPointsRegularOuter100() {
        searchBIPointsRegularOuter(100.b)
    }

    @Test
    fun searchBIPointsMFVCOuter1000() {
        searchBIPointsMFVCOuter(1000.b)
    }

    @Test
    fun searchBIPointsRegularOuter1000() {
        searchBIPointsRegularOuter(1000.b)
    }
}