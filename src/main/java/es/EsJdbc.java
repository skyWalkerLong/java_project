package es;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.ElasticSearchDruidDataSourceFactory;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author longchao
 * @date 2018/7/25.
 */
public class EsJdbc {

    @Test
    public void testJDBC() throws Exception {
        Properties properties = new Properties();
        properties.put("url", "jdbc:elasticsearch://116.196.81.252:9300/test_es");
        DruidDataSource dds = (DruidDataSource) ElasticSearchDruidDataSourceFactory.createDataSource(properties);
        Connection connection = dds.getConnection();
        PreparedStatement ps = connection.prepareStatement("SELECT  message from test_es");
        ResultSet resultSet = ps.executeQuery();
        List<String> result = new ArrayList<String>();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("message"));
        }
        ps.close();
        connection.close();
        dds.close();
    }
}
