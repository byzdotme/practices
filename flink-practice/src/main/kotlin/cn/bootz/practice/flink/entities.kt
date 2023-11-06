package cn.bootz.practice.flink

data class RequestEntity(val id: String, val timestamp: Long, val amount: Double)

data class ResponseEntity(val id: String)