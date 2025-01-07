package foo

import com.alibaba.dashscope.aigc.imagesynthesis.ImageSynthesis
import com.alibaba.dashscope.aigc.imagesynthesis.ImageSynthesisParam

object TryWanxiangPicGen {

    @JvmStatic
    fun main(args: Array<String>) {
//        val prompt = "我需要设计一款枕头套，形状为正方形，面料是亚麻，图形采用印象派艺术风格，莫兰迪色系，主题是“黄昏的巴黎”"
        val prompt = "你是一位专业的服装设计师，出两张T恤的设计图，男女款分别设计，T恤底色从上到下从右到左，为白色到粉红色的渐变效果，男版圆领女版鸡心领，T恤正面无图案，背面印一把羽毛球拍和一只羽毛球，球拍图案上面印字“小猪羽毛球俱乐部”，字体你看着来"
        val param = ImageSynthesisParam.builder()
            .apiKey("sk-todo")
            .model(ImageSynthesis.Models.WANX_V1)
            .prompt(prompt)
            .style("<watercolor>")
            .n(2)
            .size("1024*1024")
            .build()
        val client = ImageSynthesis()
        println("start call")
        val start = System.currentTimeMillis()
        val result = client.call(param)
        println("cost ${System.currentTimeMillis() - start}ms")
        println(result)
    }

}