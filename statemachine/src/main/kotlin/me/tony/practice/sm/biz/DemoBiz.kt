package me.tony.practice.sm.biz

import me.tony.practice.sm.event.OrderAction
import me.tony.practice.sm.state.OrderState
import org.springframework.statemachine.StateMachine
import org.springframework.statemachine.config.StateMachineBuilder
import org.springframework.stereotype.Service

/**
 * @author tony.zhuby
 * @date 2020/12/23
 */
@Service
class DemoBiz(val sm: StateMachine<OrderState, OrderAction>) {
    init {
        StateMachineBuilder
    }
}