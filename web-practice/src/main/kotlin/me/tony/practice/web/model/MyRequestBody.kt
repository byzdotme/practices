package me.tony.practice.web.model

import jakarta.validation.constraints.NotBlank
import org.hibernate.validator.constraints.Length

/**
 * @author tony.zhuby
 * @date 2020/12/8
 */
data class MyRequestBody(
    @field:NotBlank.List(
        value = [
            NotBlank(message = "title not blank default"),
            NotBlank(groups = [GroupB::class], message = "title not blank groupb")
        ]
    )
    var title: String?,
    @field:Length.List(
        value = [
            Length(min = 10, groups = [GroupA::class], message = "content length groupa"),
            Length(min = 20, groups = [GroupB::class], message = "content length groupb")
        ]
    )
    var content: String?
)

interface GroupA

interface GroupB