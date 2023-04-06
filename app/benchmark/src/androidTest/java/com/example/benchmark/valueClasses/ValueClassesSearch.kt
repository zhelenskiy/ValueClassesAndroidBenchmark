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
class ValueClassesSearch {
    @get:Rule
    val benchmarkRule = BenchmarkRule()

    private fun searchDPointsMFVC(n: Double) = benchmarkRule.measureRepeated {
        var p = DPointMfvc(n, n)
        while (p.x != 1.0 && p.y != 1.0) {
            p = DPointMfvc(
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

    private fun searchDPointsMFVCOuter(n: Double) = benchmarkRule.measureRepeated {
        var p = OuterDPointMfvc(DPointMfvc(n, n))
        while (p.value.x != 1.0 && p.value.y != 1.0) {
            p = OuterDPointMfvc(
                DPointMfvc(
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
}