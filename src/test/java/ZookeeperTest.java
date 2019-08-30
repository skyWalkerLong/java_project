import org.apache.zookeeper.*;

/**
 * TODO some word
 *
 * @author Long Chao
 * @version 1.0
 * @date 2019-04-13
 */
public class ZookeeperTest {
    public static void main(String[] args) throws Exception{
        // 创建连接
        ZooKeeper zk = new ZooKeeper("39.96.11.146:2181", 30000, new Watcher(){
            // 监听的事件发生变化时, 调用该函数
            public void process(WatchedEvent event) {
                System.out.println("Event emit -> " + event.getType());
            }
        });

        System.out.println(zk);
        // 查看根目录, ls /
        System.out.println("[line: 29]command: ls / -> " + zk.getChildren("/", true));

        // 创建数据节点config
        if(zk.exists("/config", true) == null) {
            zk.create("/config", "db.properties".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);

            System.out.println("创建数据节点config成功.");

            // 查看数据节点数据
            System.out.println("[line: 38]command get /config: " + new String(zk.getData("/config", true, null)));

            // 查看根目录, ls /
            System.out.println("[line: 41]command: ls / -> " + zk.getChildren("/", true));
        }

        // 修改数据节点
        if(zk.exists("/config", true) != null) {
            zk.setData("/config", "db2.properteis".getBytes(), -1);
            // 查看数据节点数据
            System.out.println("[line: 48]command get /config: " + new String(zk.getData("/config", true, null)));
            // 查看根目录, ls /
            System.out.println("[line: 50]command: ls / -> " + zk.getChildren("/", true));
        }

        // 删除数据节点
        if(zk.exists("/config", true) != null) {
            zk.delete("/config", -1);
            // 查看根目录, ls /
            System.out.println("[line: 57]command: ls / -> " + zk.getChildren("/", true));
        }

        // 关闭连接
        zk.close();
    }
}
