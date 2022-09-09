package github.luthfipun.springrestapi.common.util

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class Md5EncodeTest {

    @Test
    fun md5EncoderTest() {

        val value = "test"
        val expectedValue = "098f6bcd4621d373cade4e832627b4f6"

        val encoder = Md5Encode().encode(value = value)
        assertEquals(encoder, expectedValue)
    }
}