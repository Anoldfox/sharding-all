package org.ywb.readwritesplit.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileAlreadyExistsException;
import java.util.Objects;

/**
 * @author tea
 * email: wenbo_Y@126.com
 * github: https://github.com/xiao-ren-wu
 * @version v1.0.0
 * <p>
 * </p>
 * @since 2020/5/12 8:21 上午
 */
@Configuration
public class ShardingDataSourceYamlConfig {

    private static final String SHARDING_FILE_NAME = "sharding/dataSource";

    private static final String SUFFIX = ".yml";

    private static final String WORD_SPLIT = "-";

    @Resource
    private ConfigurableEnvironment configurableEnvironment;


    /**
     * 根据spring-profile-active找到合适的sharding-jdbc配置文件
     *
     * @return sharding-jdbc config File
     * @throws FileNotFoundException      FileNotFoundException
     * @throws FileAlreadyExistsException FileAlreadyExistsException
     */
    public File getShardingFileByProfileActive() throws FileNotFoundException, FileAlreadyExistsException {
        // 获取classpath
        String classPath = Objects.requireNonNull(ClassLoader.getSystemClassLoader().getResource("")).getPath();
        // 获取所有环境
        String[] profiles = configurableEnvironment.getActiveProfiles();
        if (profiles.length == 0) {
            // default profile
            String shardingConfigFileName = String.format("%s%s%s", classPath, SHARDING_FILE_NAME, SUFFIX);
            File defaultShardingFile = new File(shardingConfigFileName);
            if (!defaultShardingFile.exists()) {
                throw new FileNotFoundException(shardingConfigFileName);
            }
            return defaultShardingFile;
        } else {
            // 如果存在多个符合的配置文件，因为他没有上下级的关系，所以无法进行归并，这里采用报错的形式返回
            File profileShardingFile = null;
            for (String profile : profiles) {
                // 构建文件地址
                String shardingConfigFileName = String.format("%s%s%s%s%s", classPath, SHARDING_FILE_NAME, WORD_SPLIT, profile, SUFFIX);
                File file = new File(shardingConfigFileName);
                if (file.exists()) {
                    if (Objects.isNull(profileShardingFile)) {
                        profileShardingFile = file;
                    } else {
                        // 出现多个符合条件的配置文件，抛异常
                        throw new FileAlreadyExistsException("Sharding-jdbc配置文件找到多个");
                    }
                }
            }
            if (Objects.isNull(profileShardingFile)) {
                throw new FileNotFoundException("没有找到Sharding-jdbc配置文件");
            }
            return profileShardingFile;
        }
    }
}

