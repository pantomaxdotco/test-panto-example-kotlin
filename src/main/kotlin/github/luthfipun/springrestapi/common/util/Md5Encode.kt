package github.luthfipun.springrestapi.common.util

import org.springframework.stereotype.Component
import java.math.BigInteger
import java.security.MessageDigest

@Component
class Md5Encode {
    fun encode(value: String) : String {
        val md = MessageDigest.getInstance("md5")
        return BigInteger(1, md.digest(value.toByteArray())).toString(16).padStart(32, '0')
    }
}