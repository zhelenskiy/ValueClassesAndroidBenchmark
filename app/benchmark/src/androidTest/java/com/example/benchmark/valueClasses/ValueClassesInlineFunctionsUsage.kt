package com.example.benchmark.valueClasses

import androidx.benchmark.junit4.BenchmarkRule
import androidx.benchmark.junit4.measureRepeated
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.benchmark.DPointMfvc
import com.example.benchmark.DPointRegular
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ValueClassesInlineFunctionsUsage {
    @get:Rule
    val benchmarkRule = BenchmarkRule()

    @Test
    fun regular() = benchmarkRule.measureRepeated {
        DPointRegular(1.0, 2.0)
            .let { DPointRegular(it.y, it.x) }
            .let { DPointRegular(it.x * 2, it.y * 2) }
            .let { DPointRegular(it.y, it.x) }
            .let { DPointRegular(it.x * 2, it.y * 2) }
            .let { DPointRegular(it.y, it.x) }
    }

    @Test
    fun mfvc() = benchmarkRule.measureRepeated {
        DPointMfvc(1.0, 2.0)
            .let { DPointMfvc(it.y, it.x) }
            .let { DPointMfvc(it.x * 2, it.y * 2) }
            .let { DPointMfvc(it.y, it.x) }
            .let { DPointMfvc(it.x * 2, it.y * 2) }
            .let { DPointMfvc(it.y, it.x) }
    }
}