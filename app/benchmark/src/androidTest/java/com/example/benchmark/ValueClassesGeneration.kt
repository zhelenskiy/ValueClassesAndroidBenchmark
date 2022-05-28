package com.example.benchmark

import androidx.benchmark.junit4.BenchmarkRule
import androidx.benchmark.junit4.measureRepeated
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ValueClassesGeneration {

    private fun escape(point: DPointMFVC) = Unit
    private fun escape(point: DPointRegular) = Unit

    private fun escape(point: IPointMFVC) = Unit
    private fun escape(point: IPointRegular) = Unit

    private fun escape(point: BIPointMFVC) = Unit
    private fun escape(point: BIPointRegular) = Unit
    
    @get:Rule
    val benchmarkRule = BenchmarkRule()

    @Test
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
    fun generateDPointsMFVC() {
        var x = 0.0
        var y = 2.0
        var point = DPointMFVC(x, y)
        benchmarkRule.measureRepeated {
            point = DPointMFVC(x, y)
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
        var point: DPointMFVC
        benchmarkRule.measureRepeated {
            point = DPointMFVC(x, y)
            x++
            y++
            escape(point)
        }
    }

    @Test
    fun generateIPointsRegular() {
        var x = 0
        var y = 2
        var point = IPointRegular(x, y)
        benchmarkRule.measureRepeated {
            point = IPointRegular(x, y)
            x++
            y++
        }
    }

    @Test
    fun generateIPointsMFVC() {
        var x = 0
        var y = 2
        var point = IPointMFVC(x, y)
        benchmarkRule.measureRepeated {
            point = IPointMFVC(x, y)
            x++
            y++
        }
    }

    @Test
    fun generateIPointsEscapingRegular() {
        var x = 0
        var y = 2
        var point: IPointRegular
        benchmarkRule.measureRepeated {
            point = IPointRegular(x, y)
            x++
            y++
            escape(point)
        }
    }

    @Test
    fun generateIPointsEscapingMFVC() {
        var x = 0
        var y = 2
        var point: IPointMFVC
        benchmarkRule.measureRepeated {
            point = IPointMFVC(x, y)
            x++
            y++
            escape(point)
        }
    }
    private val bigIntsSize = (1 shl 10)

    private val bigInts = (1..bigIntsSize).map { it.toBigInteger() }.toTypedArray()
    
    @Suppress("NOTHING_TO_INLINE")
    private inline fun bigIntOf(n: Int) = bigInts[n and (bigIntsSize - 1)]
    

    @Test
    fun generateBIPointsRegular() {
        var x = 0
        var y = 2
        var point = BIPointRegular(bigIntOf(x), bigIntOf(y))
        benchmarkRule.measureRepeated {
            point = BIPointRegular(bigIntOf(x), bigIntOf(y))
            x++
            y++
        }
    }

    @Test
    fun generateBIPointsMFVC() {
        var x = 0
        var y = 2
        var point = BIPointMFVC(bigIntOf(x), bigIntOf(y))
        benchmarkRule.measureRepeated {
            point = BIPointMFVC(bigIntOf(x), bigIntOf(y))
            x++
            y++
        }
    }

    @Test
    fun generateBIPointsEscapingRegular() {
        var x = 0
        var y = 2
        var point: BIPointRegular
        benchmarkRule.measureRepeated {
            point = BIPointRegular(bigIntOf(x), bigIntOf(y))
            x++
            y++
            escape(point)
        }
    }

    @Test
    fun generateBIPointsEscapingMFVC() {
        var x = 0
        var y = 2
        var point: BIPointMFVC
        benchmarkRule.measureRepeated {
            point = BIPointMFVC(bigIntOf(x), bigIntOf(y))
            x++
            y++
            escape(point)
        }
    }

    private fun escapeOuter(point: OuterDPointMFVC) = Unit
    private fun escapeOuter(point: OuterDPointRegular) = Unit

    private fun escapeOuter(point: OuterIPointMFVC) = Unit
    private fun escapeOuter(point: OuterIPointRegular) = Unit

    private fun escapeOuter(point: OuterBIPointMFVC) = Unit
    private fun escapeOuter(point: OuterBIPointRegular) = Unit

    @Test
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
    fun generateOuterDPointsMFVC() {
        var x = 0.0
        var y = 2.0
        var point = OuterDPointMFVC(DPointMFVC(x, y))
        benchmarkRule.measureRepeated {
            point = OuterDPointMFVC(DPointMFVC(x, y))
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
        var point: OuterDPointMFVC
        benchmarkRule.measureRepeated {
            point = OuterDPointMFVC(DPointMFVC(x, y))
            x++
            y++
            escapeOuter(point)
        }
    }

    @Test
    fun generateOuterIPointsRegular() {
        var x = 0
        var y = 2
        var point = OuterIPointRegular(IPointRegular(x, y))
        benchmarkRule.measureRepeated {
            point = OuterIPointRegular(IPointRegular(x, y))
            x++
            y++
        }
    }

    @Test
    fun generateOuterIPointsMFVC() {
        var x = 0
        var y = 2
        var point = OuterIPointMFVC(IPointMFVC(x, y))
        benchmarkRule.measureRepeated {
            point = OuterIPointMFVC(IPointMFVC(x, y))
            x++
            y++
        }
    }

    @Test
    fun generateOuterIPointsEscapingRegular() {
        var x = 0
        var y = 2
        var point: OuterIPointRegular
        benchmarkRule.measureRepeated {
            point = OuterIPointRegular(IPointRegular(x, y))
            x++
            y++
            escapeOuter(point)
        }
    }

    @Test
    fun generateOuterIPointsEscapingMFVC() {
        var x = 0
        var y = 2
        var point: OuterIPointMFVC
        benchmarkRule.measureRepeated {
            point = OuterIPointMFVC(IPointMFVC(x, y))
            x++
            y++
            escapeOuter(point)
        }
    }


    @Test
    fun generateOuterBIPointsRegular() {
        var x = 0
        var y = 2
        var point = OuterBIPointRegular(BIPointRegular(bigIntOf(x), bigIntOf(y)))
        benchmarkRule.measureRepeated {
            point = OuterBIPointRegular(BIPointRegular(bigIntOf(x), bigIntOf(y)))
            x++
            y++
        }
    }

    @Test
    fun generateOuterBIPointsMFVC() {
        var x = 0
        var y = 2
        var point = OuterBIPointMFVC(BIPointMFVC(bigIntOf(x), bigIntOf(y)))
        benchmarkRule.measureRepeated {
            point = OuterBIPointMFVC(BIPointMFVC(bigIntOf(x), bigIntOf(y)))
            x++
            y++
        }
    }

    @Test
    fun generateOuterBIPointsEscapingRegular() {
        var x = 0
        var y = 2
        var point: OuterBIPointRegular
        benchmarkRule.measureRepeated {
            point = OuterBIPointRegular(BIPointRegular(bigIntOf(x), bigIntOf(y)))
            x++
            y++
            escapeOuter(point)
        }
    }

    @Test
    fun generateOuterBIPointsEscapingMFVC() {
        var x = 0
        var y = 2
        var point: OuterBIPointMFVC
        benchmarkRule.measureRepeated {
            point = OuterBIPointMFVC(BIPointMFVC(bigIntOf(x), bigIntOf(y)))
            x++
            y++
            escapeOuter(point)
        }
    }
}