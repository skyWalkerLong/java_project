package es;

import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author longchao
 * @date 2018/5/8.
 */
public class MyTransportClient {
    public static void main(String[] args) throws UnknownHostException {
        // 配置信息
        Settings esSetting = Settings.builder()
                .put("cluster.name", "skywalker")
                .build();

        TransportClient transportClient = new PreBuiltTransportClient(esSetting);

       transportClient.addTransportAddress(new TransportAddress(InetAddress.getByName("116.196.81.252"), 9300));

        createIndex("test_creatindex",transportClient);
    }

    /**
     * 创建一个索引
     * @param indexName 索引名
     */
    public static void createIndex(String indexName,TransportClient client) {
        try {
            CreateIndexResponse indexResponse = client
                    .admin()
                    .indices()
                    .prepareCreate(indexName)
                    .get();

            System.out.println(indexResponse.isAcknowledged()); // true表示创建成功
        } catch (ElasticsearchException e) {
            e.printStackTrace();
        }
    }
}
