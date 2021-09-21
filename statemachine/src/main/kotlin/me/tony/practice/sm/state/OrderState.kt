package me.tony.practice.sm.state

/**
 * @author tony.zhuby
 * @date 2020/12/23
 */
enum class OrderState {

    CREATE,
    UNPAID,
    CANCELED,
    PAID,
    SENT,
    RECEIVED
}