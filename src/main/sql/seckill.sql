#秒杀执行存储过程
DELIMITER $$ #Cconsole; 转换为$$

CREATE PROCEDURE `seckill`.`execute_seckill`
  (in v_seckill_id bigint, in v_phone bigint, in v_kill_time TIMESTAMP , out r_result int)

  BEGIN
    DECLARE insert_count int DEFAULT 0;
    START TRANSACTION ;
    INSERT ignore INTO success_killed
    (seckill_id, user_phone, create_time)
    VALUES (v_seckill_id ,v_phone, v_kill_time);
    SELECT ROW_COUNT () into insert_count;
    IF(insert_count <0) THEN
      ROLLBACK ;
      set r_result = -1;
    ELSEIF(insert_count < 0 )THEN
      ROLLBACK ;
      set r_result = -2;
    ELSE
      UPDATE seckill
      SET number = number - 1
      WHERE seckill_id = v_seckill_id AND end_time > v_kill_time AND seckill.start_time < v_kill_time
            AND seckill.number > 0 ;
      SELECT row_count() into insert_count;
      IF (insert_count = 0) THEN
        ROLLBACK;
        set r_result = 0;
      ELSEIF (insert_count <0) THEN
        ROLLBACK ;
        SET r_result = -2;
      ELSE
        COMMIT ;
        SET r_result = 1;

      END IF;
    END IF;
  END ;
$$

DELIMITER ;
set @r_result = -3;
CALL execute_seckill(1001,13728349494,now(),@r_result);
SELECT @r_result;
#存储过程
#1。存储过程优化：事物行级锁持有时间
#2。不要过渡依赖存储过程
#3。 间的的逻辑可以用存储过程