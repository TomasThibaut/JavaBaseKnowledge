package 多线程.线程基础

import org.junit.Test

/**
 * 线程重要方法
 * Created by 宫成 on 2019/5/27.
 */
class ImportantFunction {

    @Test
    fun test() {
        /**
         * 阻塞
         * 出让cpu不释放对象锁
         * 指定时间结束后，不一定立刻被CPU调度，因此休眠时间 >= 参数值
         * 被中断会抛出 InterruptedException
         *
         */
        Thread.sleep(2000)

        /**
         * 出让CPU，释放对象锁
         * 调用前需要拥有对象锁，所以一般在sync同步块中使用
         * 是该线程进入该对象监视器的等待队列
         */
        Object().wait()
    }
}