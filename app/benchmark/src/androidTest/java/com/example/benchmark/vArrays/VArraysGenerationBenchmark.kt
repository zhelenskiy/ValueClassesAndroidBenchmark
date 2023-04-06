package com.example.benchmark.vArrays

import androidx.benchmark.junit4.measureRepeated
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.benchmark.DPointRegular
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class VArraysGenerationBenchmark: VArraysBenchmark() {

    override fun regular2D(size: Int) {
        benchmarkRule.measureRepeated {
            Array(size) { DPointRegular(it.toDouble(), -it.toDouble()) }
        }
    }

    override fun regular3D(size: Int) {
        benchmarkRule.measureRepeated {
            Array(size) { DPointRegular3D(it.toDouble(), -it.toDouble(), it.times(2).toDouble()) }
        }
    }

    override fun dense2D(size: Int) {
        benchmarkRule.measureRepeated {
            DoubleArray(2 * size).apply {
                for (i in 0 until size) {
                    set(2 * i, i.toDouble())
                    set(2 * i + 1, -i.toDouble())
                }
            }
        }
    }

    override fun dense3D(size: Int) {
        benchmarkRule.measureRepeated {
            DoubleArray(3 * size).apply {
                for (i in 0 until size) {
                    set(3 * i, i.toDouble())
                    set(3 * i + 1, -i.toDouble())
                    set(3 * i + 2, i.times(2).toDouble())
                }
            }
        }
    }

    override fun sparse2D(size: Int) {
        benchmarkRule.measureRepeated {
            val xs = DoubleArray(size)
            val ys = DoubleArray(size)
            for (i in 0 until size) {
                xs[i] = i.toDouble()
                ys[i] = -i.toDouble()
            }
        }
    }

    override fun sparse3D(size: Int) {
        benchmarkRule.measureRepeated {
            val xs = DoubleArray(size)
            val ys = DoubleArray(size)
            val zs = DoubleArray(size)
            for (i in 0 until size) {
                xs[i] = i.toDouble()
                ys[i] = -i.toDouble()
                zs[i] = i.times(2).toDouble()
            }
        }
    }
}