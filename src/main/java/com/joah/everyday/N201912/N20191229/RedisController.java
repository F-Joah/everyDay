package com.joah.everyday.N201912.N20191229;

import com.joah.everyday.N201912.N20191229.util.RedisConstants;
import com.joah.everyday.N201912.N20191229.util.RedisUtil;
import com.joah.everyday.N201912.N20191229.util.StateParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping(value="/redis")
public class RedisController extends BaseController{

    @Autowired
    RedisUtil redisUtil;

    @ResponseBody
    @RequestMapping(value = "getRedis",method = RequestMethod.POST)
    public ModelMap getRedis(){
        logger.info("进入.....");
        redisUtil.set("20182018","这是一条测试数据", RedisConstants.datebase1);
        logger.info("赋值.....");

        //设置key过期时间
        Long resExpire = redisUtil.expire("20182018", 600000, RedisConstants.datebase1);
        logger.info("过期时间.....");

        logger.info("resExpire="+resExpire);
        String res = redisUtil.get("20182018", RedisConstants.datebase1);
        return getModelMap(StateParameter.SUCCESS, res, "执行成功");
    }
}
