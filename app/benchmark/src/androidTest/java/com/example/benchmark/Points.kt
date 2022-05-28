package com.example.benchmark

import java.math.BigInteger


@JvmInline
value class DPointMFVC(val x: Double, val y: Double)

data class DPointRegular(val x: Double, val y: Double)

@JvmInline
value class IPointMFVC(val x: Int, val y: Int)

data class IPointRegular(val x: Int, val y: Int)

@JvmInline
value class BIPointMFVC(val x: BigInteger, val y: BigInteger)

data class BIPointRegular(val x: BigInteger, val y: BigInteger)

val Int.b
    get() = toBigInteger()

@JvmInline
value class OuterDPointMFVC(val value: DPointMFVC)

data class OuterDPointRegular(val value: DPointRegular)

@JvmInline
value class OuterIPointMFVC(val value: IPointMFVC)

data class OuterIPointRegular(val value: IPointRegular)

@JvmInline
value class OuterBIPointMFVC(val value: BIPointMFVC)

data class OuterBIPointRegular(val value: BIPointRegular)