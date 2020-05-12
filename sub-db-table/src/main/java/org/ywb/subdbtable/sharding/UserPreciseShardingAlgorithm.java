package org.ywb.subdbtable.sharding;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

/**
 * @author tea
 * email: wenbo_Y@126.com
 * github: https://github.com/xiao-ren-wu
 * @version v1.0.0
 * <p>
 * </p>
 * @since 2020/5/12 8:19 上午
 */
public class UserPreciseShardingAlgorithm implements PreciseShardingAlgorithm<String> {

    @Override
    public String doSharding(Collection<String> tableNames, PreciseShardingValue<String> shardingValue) {
        return tableNames.stream()
                .filter(table -> {
                    String data = shardingValue.getValue();
                    String endWord = data.substring(data.length() - 1);
                    return table.endsWith(Integer.parseInt(endWord) % 2 + "");
                })
                .findAny()
                .orElseThrow(UnsupportedOperationException::new);
    }

}
