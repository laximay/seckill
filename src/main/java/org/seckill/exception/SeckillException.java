package org.seckill.exception;

/**
 * Created by wenjing on 2017/1/22.
 * 秒杀异常
 */
public class SeckillException extends RuntimeException{

    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
