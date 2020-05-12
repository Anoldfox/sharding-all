package org.ywb.readwritesplit.config;

import org.apache.shardingsphere.shardingjdbc.api.yaml.YamlMasterSlaveDataSourceFactory;
import org.apache.shardingsphere.shardingjdbc.api.yaml.YamlShardingDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author tea
 * email: wenbo_Y@126.com
 * github: https://github.com/xiao-ren-wu
 * @version v1.0.0
 * <p>
 * </p>
 * @since 2020/5/12 8:22 上午
 */
@Configuration
public class DataSourceConfiguration {

    @Resource
    private ShardingDataSourceYamlConfig shardingDataSourceYamlConfig;

    @Bean
    @Primary
    public DataSource dataSource() throws IOException, SQLException {
        return YamlMasterSlaveDataSourceFactory.createDataSource(shardingDataSourceYamlConfig.getShardingFileByProfileActive());
    }
}
