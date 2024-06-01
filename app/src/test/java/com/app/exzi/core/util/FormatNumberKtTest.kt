package com.app.exzi.core.util

import org.junit.Assert
import org.junit.Test

class FormatNumberKtTest {
    @Test
    fun testWithDifferentNumbers() {
        Assert.assertEquals("0.333", formatNumber(0.33333, 3))
        Assert.assertEquals("3,333.333", formatNumber(3333.33333, 3))
        Assert.assertEquals("33.333", formatNumber(33.33333000000, 3))
        Assert.assertEquals("33.000", formatNumber(33.0, 3))
        Assert.assertEquals("33", formatNumber(33.1232132, 0))
        Assert.assertEquals("33.1", formatNumber(33.1232132, 1))
        Assert.assertEquals("33.120000000", formatNumber(33.12, 9))
        Assert.assertEquals("33", formatNumber(33.12, -2))
    }
}