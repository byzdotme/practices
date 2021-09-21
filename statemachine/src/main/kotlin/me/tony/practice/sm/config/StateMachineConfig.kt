package me.tony.practice.sm.config

import me.tony.practice.sm.event.OrderAction
import me.tony.practice.sm.state.OrderState
import org.springframework.context.annotation.Configuration
import org.springframework.statemachine.config.AbstractStateMachineConfigurerAdapter
import org.springframework.statemachine.config.builders.StateMachineConfigBuilder
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer

/**
 * @author tony.zhuby
 * @date 2020/12/23
 */
@Configuration
class StateMachineConfig : AbstractStateMachineConfigurerAdapter<OrderState, OrderAction>() {

    override fun configure(transitions: StateMachineTransitionConfigurer<OrderState, OrderAction>?) {
        transitions?.let {

        }
    }
}