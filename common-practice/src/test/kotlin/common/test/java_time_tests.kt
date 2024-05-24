package common.test

import java.time.LocalDateTime
import java.time.OffsetDateTime
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.ZonedDateTime
import kotlin.test.Test

class Tests {

    @Test
    fun testOffset() {
        val local = LocalDateTime.now()
        val offset = local.atOffset(ZoneOffset.ofHours(8))
        println(local.toString())
        println(offset.toString())
        val offset2 = offset.withOffsetSameLocal(ZoneOffset.ofHours(-8))
        println(offset2.toString())
        val offset3 = offset.withOffsetSameInstant(ZoneOffset.ofHours(-8))
        println(offset3.toString())
    }

    @Test
    fun testZoned() {
        val local = LocalDateTime.now()
        val offset = OffsetDateTime.now()
        println(local)
        println(offset)
        val zone = local.atZone(ZoneId.of("GMT+8"))
        println(zone)
        val zone2 = offset.atZoneSimilarLocal(ZoneId.of("GMT+8"))
        val zone3 = offset.atZoneSameInstant(ZoneId.of("Asia/Tokyo"))
        println(zone2)
        println(zone3)
    }

    @Test
    fun testZoned2() {
        val now = ZonedDateTime.now()
    }
}