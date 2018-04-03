package com.shu.da.platform.kettle;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author shudongping
 * @date 2018/04/03
 */
@Component
public class KettleInitializing implements InitializingBean {

    @Value("${kettle.datasource.ip}")
    private String ip;
    @Value("${kettle.datasource.database}")
    private String database;
    @Value("${kettle.datasource.port}")
    private String port;
    @Value("${kettle.datasource.username}")
    private String username;
    @Value("${kettle.datasource.password}")
    private String password;

    @Override
    public void afterPropertiesSet() throws Exception {
        KettleUtils.connectKettle("kettle","mysql","jdbc",ip,"kettle",port,username,password,null,"admin","admin");
    }
}
