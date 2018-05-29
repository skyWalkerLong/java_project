package es;

import com.alibaba.fastjson.JSONObject;
import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.cluster.node.DiscoveryNode;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Before;
import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;

/**
 * @author longchao
 * @date 2018/5/8.
 */
public class MyTransportClient {

    private TransportClient transportClient;

    @Before
    public void connection() throws UnknownHostException {
        // 配置信息
        Settings esSetting = Settings.builder()
                .put("cluster.name", "skywalker")
                .build();
        transportClient = new PreBuiltTransportClient(esSetting);

        transportClient.addTransportAddress(new TransportAddress(InetAddress.getByName("116.196.81.252"), 9300));

    }

    /**
     * 查询集群信息
     */
    @Test
    public void testInfo() {
        List<DiscoveryNode> nodes = transportClient.connectedNodes();
        for (DiscoveryNode node : nodes) {
            System.out.println(node.getHostAddress());
        }
    }

    /**
     * 创建一个索引
     *
     * @param indexName 索引名
     */
    @Test
    public void createIndex() {

        String indexName = "test_create_index_2";
        try {
            CreateIndexResponse indexResponse = transportClient
                    .admin()
                    .indices()
                    .prepareCreate(indexName)
                    .get();

            System.out.println(indexResponse.isAcknowledged()); // true表示创建成功
        } catch (ElasticsearchException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建json数据
     */
    public JSONObject createJson() {
        JSONObject json = new JSONObject();
        json.put("user", "kimchy");
        json.put("postDate", new Date());
        json.put("message", "trying out elasticsearch");
        return json;
    }

    /**
     * 数据插入es
     * @throws Exception
     */
    @Test
    public void testInsert() throws Exception {
        // 存json入索引中
        IndexResponse response = transportClient.prepareIndex("test_es", "insert", "1").setSource(createJson()).get();
//        // 结果获取
        String index = response.getIndex();
        String type = response.getType();
        String id = response.getId();
        long version = response.getVersion();
        boolean created = response.isFragment();
        System.out.println(index + " : " + type + ": " + id + ": " + version + ": " + created);
    }

    /**
     * get API 获取指定文档信息
     */
    @Test
    public void testGet() {
        GetResponse response = transportClient.prepareGet("test_es", "insert", "1")
                .get();
        System.out.println(response.getSourceAsString());
    }
}
