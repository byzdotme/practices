package foo

import com.alibaba.dashscope.aigc.imagesynthesis.ImageSynthesis
import com.alibaba.dashscope.aigc.imagesynthesis.ImageSynthesisParam

object TryWanxiangPicGen {

    @JvmStatic
    fun main(args: Array<String>) {
        val prompt = "我需要设计一款枕头套，形状为正方形，面料是亚麻，图形采用印象派艺术风格，莫兰迪色系，主题是“黄昏的巴黎”"
        val param = ImageSynthesisParam.builder()
            .apiKey("sk-todo")
            .model(ImageSynthesis.Models.WANX_V1)
            .prompt(prompt)
            .style("<watercolor>")
            .n(1)
            .size("1024*1024")
            .build()
        val client = ImageSynthesis()
        val start = System.currentTimeMillis()
        val result = client.call(param)
        println("cost ${System.currentTimeMillis() - start}ms")
        println(result)
    }

}