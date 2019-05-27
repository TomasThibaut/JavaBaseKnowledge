package servletfilter

import org.junit.Test

/**
 * 责任链模式 仿写 java servlet 的Filter过滤器
 * 输入：request，response对象
 * 输出：处理好的request和response对象， 要求三个filter按顺序处理request，安逆序处理response，并使用Call.doRequest()来处理response

 * Created by 宫成 on 2019/5/22.
 */
class Test {

    @Test
    fun main() {

        val filter = HttpFilter().apply {
            addFilter(OneFilter()).addFilter(TwoFilter()).addFilter(ThreeFilter())
        }
        //request
        var request = Request("request")
        var response = Response("response")

        filter.doFilter(request, response, filter)

        println("request = $request / response = $response")

    }

    class OneFilter : ServletFilter {
        override fun doFilter(request: Request, response: Response, chain: ServletFilter): Boolean {
            request.requestVal += "request1"
            chain.doFilter(request, response, chain)
            response.responseVal += "response1"
            Call.doRequest(request, response)
            return true
        }
    }

    class TwoFilter : ServletFilter {
        override fun doFilter(request: Request, response: Response, chain: ServletFilter): Boolean {
            request.requestVal += "request2"
            chain.doFilter(request, response, chain)
            response.responseVal += "response2"
            Call.doRequest(request, response)
            return true
        }
    }

    class ThreeFilter : ServletFilter {
        override fun doFilter(request: Request, response: Response, chain: ServletFilter): Boolean {
            request.requestVal += "request3"
            chain.doFilter(request, response, chain)
            response.responseVal += "response3"
            Call.doRequest(request, response)
            return true
        }
    }

    class HttpFilter : ServletFilter {

        private val filterList = mutableListOf<ServletFilter>()
        private var index = 0

        fun addFilter(filter: ServletFilter): HttpFilter {
            filterList.add(filter)
            return this
        }

        override fun doFilter(request: Request, response: Response, chain: ServletFilter): Boolean {
            if (index < filterList.size) {
                println("index = $index")
                val filter = filterList[index]
                index++
                if (filter.doFilter(request, response, chain) == false) return false
            }

            return true
        }

    }


}