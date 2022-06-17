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
    constructor(builder:StateMachineBuilder.Builder<OrderState, OrderAction>) : this(builder.build()) {
    }
    constructor():this(StateMachineBuilder.builder<OrderState?, OrderAction?>().build())
}