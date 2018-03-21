package com.shu.springboot.platform.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.shu.springboot.platform.domain.pojo.PlatformUser;
import com.shu.springboot.platform.domain.vo.PageVo;

/**
 * Created by shudongping on 2018/3/21 0021.
 */
public interface IUserService {
    void saveUser(PlatformUser user);

    PageInfo<PlatformUser> getPage(PageVo pageVo);
}
