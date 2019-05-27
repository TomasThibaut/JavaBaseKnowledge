package servletfilter

/**
 * Created by 宫成 on 2019/5/22.
 */
object Call {
    fun doRequest(request: Request, response: Response) {
        response.responseVal = "${response.responseVal}"
    }
}