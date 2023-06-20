package io.xccit.store.user.controller;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.xccit.store.common.auth.AuthContextHolder;
import io.xccit.store.common.constant.RedisConst;
import io.xccit.store.common.exception.StoreException;
import io.xccit.store.common.result.AjaxResult;
import io.xccit.store.common.result.ResultCodeEnum;
import io.xccit.store.common.utils.JwtHelper;
import io.xccit.store.enums.UserType;
import io.xccit.store.model.user.User;
import io.xccit.store.user.service.IUserService;
import io.xccit.store.user.utils.ConstantPropertiesUtil;
import io.xccit.store.user.utils.HttpClientUtil;
import io.xccit.store.vo.user.LeaderAddressVo;
import io.xccit.store.vo.user.UserLoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author CH_ywx
 * @date 2023-06-20
 * @description 微信请求接口
 */
@Api(tags = "微信请求接口")
@RestController
@RequestMapping("/api/user/weixin")
public class WeChatApiController {

    @Autowired
    private IUserService userService;
    @Resource
    private RedisTemplate<String,Object> redisTemplate;
    @ApiOperation("微信用户登录获取OPENID")
    @GetMapping("/wxLogin/{code}")
    public AjaxResult<Map<String,Object>> wxLogin(@ApiParam("临时身份票据") @PathVariable String code){
        if (StringUtils.isEmpty(code)){
            throw new StoreException(ResultCodeEnum.ILLEGAL_CALLBACK_REQUEST_ERROR);
        }
        //使用HttpClient带着code+appID+appSecret请求微信官方登录接口
        String wxOpenAppId = ConstantPropertiesUtil.WX_OPEN_APP_ID;
        String wxOpenAppSecret = ConstantPropertiesUtil.WX_OPEN_APP_SECRET;
        //拼接请求url
        StringBuffer url = new StringBuffer();
        url.append("https://api.weixin.qq.com/sns/jscode2session")
                .append("?appid=%s")
                .append("&secret=%s")
                .append("&js_code=%s")
                .append("&grant_type=authorization_code");
        String requestUrl = String.format(url.toString(), wxOpenAppId, wxOpenAppSecret, code); //格式化url中的参数占位符
        String result = null;
        try {
            result = HttpClientUtil.get(requestUrl);
        } catch (Exception e) {
            throw new StoreException(ResultCodeEnum.FETCH_ACCESSTOKEN_FAILD);
        }
        //解析官方接口返回的openID(微信号唯一标识)和sessionKey
        JSONObject jsonObject = JSONObject.parseObject(result);
        String sessionKey = (String) jsonObject.get("session_key");
        String openId = (String) jsonObject.get("openid");
        //根据openID判断用户是否是第一次登录? 添加到数据库 : 更新数据库信息
        User user = userService.getUserInfoByOpenID(openId);
        if (user == null){
            user = new User();
            user.setOpenId(openId);
            user.setNickName(openId);
            user.setUserType(UserType.USER);
            user.setPhotoUrl("");
            user.setIsNew(0);
            userService.save(user);
        }
        //根据用户信息生成token
        String token = JwtHelper.createToken(user.getId(), user.getNickName());
        //根据用户ID查询提货点信息和团长信息
        LeaderAddressVo leaderAddressVo = userService.getLeaderAddressByUserID(user.getId());
        //获取详细用户信息(当前登录用户)并封装,存到redis,设置有效时间
        UserLoginVo userLoginVo = userService.getUserLoginVoByID(user.getId());
        redisTemplate.opsForValue()
                .set(RedisConst.USER_LOGIN_KEY_PREFIX+user.getId(),
                        userLoginVo,
                        RedisConst.USERKEY_TIMEOUT,
                        TimeUnit.DAYS); //过期时间为7天
        //封装数据到map并返回
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("user",user);
        resultMap.put("token",token);
        resultMap.put("leaderAddressVo",leaderAddressVo);
        return AjaxResult.ok(resultMap);
    }

    @ApiOperation("更新用户信息")
    @PostMapping("/auth/updateUser")
    public AjaxResult<String> updateUser(@RequestBody User user){
        // 当前登录用户
        User loginUser = userService.getById(AuthContextHolder.getUserID());
        loginUser.setNickName(user.getNickName());
        loginUser.setPhotoUrl(user.getPhotoUrl());
        loginUser.setSex(user.getSex());
        userService.updateById(loginUser);
        return AjaxResult.ok("修改成功");
    }
}
