package com.example.benchmark.vArrays

import androidx.benchmark.junit4.measureRepeated
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.benchmark.DPointRegular
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class VArraysRandomAccessBenchmark: VArraysBenchmark() {

    @Suppress("UNUSED_PARAMETER")
    private fun handle(x: Double, y: Double) = Unit
    @Suppress("UNUSED_PARAMETER")
    private fun handle(x: Double, y: Double, z: Double) = Unit

    private fun makeOrder(size: Int): IntArray = IntArray(size) { it }.apply { shuffle() }

    override fun regular2D(size: Int) {
        val array = Array(size) { DPointRegular(it.toDouble(), -it.toDouble()) }
        val order = makeOrder(size)
        benchmarkRule.measureRepeated {
            for (i in order) {
                handle(array[i].x, array[i].y)
            }
        }
    }

    override fun regular3D(size: Int) {
        val array = Array(size) {
            DPointRegular3D(it.toDouble(), -it.toDouble(), it.times(2).toDouble())
        }
        val order = makeOrder(size)
        benchmarkRule.measureRepeated {
            for (i in order) {
                handle(array[i].x, array[i].y, array[i].z)
            }
        }
    }

    override fun dense2D(size: Int) {
        val array = DoubleArray(2 * size).apply {
            for (i in 0 until size) {
                set(2 * i, i.toDouble())
                set(2 * i + 1, -i.toDouble())
            }
        }
        val order = makeOrder(size)
        benchmarkRule.measureRepeated {
            for (i in order) {
                handle(array[2 * i], array[2 * i + 1])
            }
        }
    }

    override fun dense3D(size: Int) {
        val array = DoubleArray(3 * size).apply {
            for (i in 0 until size) {
                set(3 * i, i.toDouble())
                set(3 * i + 1, -i.toDouble())
                set(3 * i + 2, i.times(2).toDouble())
            }
        }
        val order = makeOrder(size)
        benchmarkRule.measureRepeated {
            for (i in order) {
                handle(array[3 * i], array[3 * i + 1], array[3 * i + 2])
            }
        }
    }

    override fun sparse2D(size: Int) {
        val xs = DoubleArray(size)
        val ys = DoubleArray(size)
        for (i in 0 until size) {
            xs[i] = i.toDouble()
            ys[i] = -i.toDouble()
        }
        val order = makeOrder(size)
        benchmarkRule.measureRepeated {
            for (i in order) {
                handle(xs[i], ys[i])
            }
        }
    }

    override fun sparse3D(size: Int) {
        val xs = DoubleArray(size)
        val ys = DoubleArray(size)
        val zs = DoubleArray(size)
        for (i in 0 until size) {
            xs[i] = i.toDouble()
            ys[i] = -i.toDouble()
            zs[i] = i.times(2).toDouble()
        }
        val order = makeOrder(size)
        benchmarkRule.measureRepeated {
            for (i in order) {
                handle(xs[i], ys[i], zs[i])
            }
        }
    }
}