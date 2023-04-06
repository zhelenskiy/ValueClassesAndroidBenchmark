package com.example.benchmark.vArrays

import androidx.benchmark.junit4.BenchmarkRule
import org.junit.Rule
import org.junit.Test

abstract class VArraysBenchmark {
    @get:Rule
    val benchmarkRule = BenchmarkRule()
    protected data class DPointRegular3D(val x: Double, val y: Double, val z: Double)


    protected abstract fun regular2D(size: Int)
    protected abstract fun regular3D(size: Int)
    protected abstract fun dense2D(size: Int)
    protected abstract fun dense3D(size: Int)
    protected abstract fun sparse2D(size: Int)
    protected abstract fun sparse3D(size: Int)

    @Test
    fun regular2D_10() = regular2D(10)
    @Test
    fun regular2D_1000() = regular2D(1000)
    @Test
    fun regular2D_100000() = regular2D(100000)

    @Test
    fun dense2D_10() = dense2D(10)
    @Test
    fun dense2D_1000() = dense2D(1000)
    @Test
    fun dense2D_100000() = dense2D(100000)

    @Test
    fun sparse2D_10() = sparse2D(10)
    @Test
    fun sparse2D_1000() = sparse2D(1000)
    @Test
    fun sparse2D_100000() = sparse2D(100000)

    @Test
    fun regular3D_10() = regular3D(10)
    @Test
    fun regular3D_1000() = regular3D(1000)
    @Test
    fun regular3D_100000() = regular3D(100000)

    @Test
    fun dense3D_10() = dense3D(10)
    @Test
    fun dense3D_1000() = dense3D(1000)
    @Test
    fun dense3D_100000() = dense3D(100000)

    @Test
    fun sparse3D_10() = sparse3D(10)
    @Test
    fun sparse3D_1000() = sparse3D(1000)
    @Test
    fun sparse3D_100000() = sparse3D(100000)
}
