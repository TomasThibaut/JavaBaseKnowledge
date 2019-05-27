package servletfilter

/**
 * Created by 宫成 on 2019/5/22.
 */
interface ServletFilter {
    fun doFilter(request: Request, response: Response, chain: ServletFilter): Boolean
}