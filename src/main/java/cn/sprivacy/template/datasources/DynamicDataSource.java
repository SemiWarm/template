package cn.sprivacy.template.datasources;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.Map;

/**
 * @author fanglang
 * @date 2018-05-29 16:24
 * @desc 动态数据源
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    private static final ThreadLocal<String> CONTEXTHOLDER = new ThreadLocal<>();

    public DynamicDataSource(DataSource defaultTargetDataSource, Map<Object, Object> targetDataSources) {
        super.setDefaultTargetDataSource(defaultTargetDataSource);
        super.setTargetDataSources(targetDataSources);
        super.afterPropertiesSet();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return getDataSource();
    }

    public static void setDataSource(String dataSource) {
        CONTEXTHOLDER.set(dataSource);
    }

    public static String getDataSource() {
        return CONTEXTHOLDER.get();
    }

    public static void clearDataSource() {
        CONTEXTHOLDER.remove();
    }
}
