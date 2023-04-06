package com.example.benchmark.valueClasses

import androidx.benchmark.junit4.BenchmarkRule
import androidx.benchmark.junit4.measureRepeated
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.random.Random

@RunWith(AndroidJUnit4::class)
class LongPackBenchmark {
    private var f1: Float = 0.0f
    private var f2: Float = 0.0f
    @get:Rule
    val benchmarkRule = BenchmarkRule()
    private var float1 = 0.0f
    private var float2 = 0.0f

    private data class FloatPair(val f1: Float, val f2: Float)
    private data class Wrapper(var l1: Long, var l2: Long, var l3: Long, var l4: Long)
    private val wrapper = Wrapper(0, 0, 0, 0)

    private fun longPacked(): Long = float1.toRawBits().toLong().shl(32).or(float2.toRawBits().toLong())
    private fun boxPacked(): FloatPair = FloatPair(float1, float2)
    private fun wrapperPacked(wrapper: Wrapper) {
        wrapper.l1 = float1.toRawBits().toLong()
        wrapper.l2 = float2.toRawBits().toLong()
    }

    private fun setup() {
        float1 = Random.nextFloat()
        float2 = Random.nextFloat()
    }

    @Test
    fun long() {
        setup()
        benchmarkRule.measureRepeated {
            val long = longPacked()
            f1 = Float.fromBits(long.shr(32).toInt())
            f2 = Float.fromBits(long.toInt())
        }
    }

    @Test
    fun box() {
        setup()
        benchmarkRule.measureRepeated {
            val box = boxPacked()
            f1 = box.f1
            f2 = box.f2
        }
    }

    @Test
    fun existingWrapper() {
        setup()
        benchmarkRule.measureRepeated {
            val w = wrapper
            wrapperPacked(w)
            f1 = Float.fromBits(w.l1.toInt())
            f2 = Float.fromBits(w.l2.toInt())
        }
    }
}
