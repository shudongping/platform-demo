package com.shu.springboot.platform.service;

import com.github.pagehelper.PageInfo;
import com.shu.springboot.platform.domain.pojo.PlatformUser;
import com.shu.springboot.platform.domain.vo.PageVo;

/**
 * @author shudongping
 * @date 2018/03/21
 */
public interface IUserService {
    void saveUser(PlatformUser user);

    PageInfo<PlatformUser> getPage(PageVo pageVo);

    void sendUserEvent() throws Exception;
}
