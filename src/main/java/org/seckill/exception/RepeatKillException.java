package org.seckill.exception;

/**
 * 重复秒杀异常（运行期异常)
 * Created by wenjing on 2017/1/22.
 * spring 只接收运行期异常的事物会馆
 */
public class RepeatKillException extends  SeckillException{
    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
