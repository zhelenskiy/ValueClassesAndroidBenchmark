package com.example.benchmark


@JvmInline
value class DPointMfvc(val x: Double, val y: Double)

data class DPointRegular(val x: Double, val y: Double)

@JvmInline
value class OuterDPointMfvc(val value: DPointMfvc)

data class OuterDPointRegular(val value: DPointRegular)
