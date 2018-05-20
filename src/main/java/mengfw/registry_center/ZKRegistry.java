package mengfw.registry_center;

import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.CreateMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by mengfw on 2018/5/16.
 */
public class ZKRegistry implements Registry {
    private static Logger LOGGER = LoggerFactory.getLogger(ZKRegistry.class);
    private static String ROOT_PATH = "/register_center";
    private CuratorFramework client;

    public void register(Class clz, Host host) {
        try {
            client.create()
                    .creatingParentsIfNeeded()//若创建节点的父节点不存在会先创建父节点再创建子节点
                    .withMode(CreateMode.EPHEMERAL)
                    .forPath(generateUrl(generateProviderPath(generateServicePath(clz.getName())),host.toString()));
        } catch (Exception e) {
            LOGGER.error("zk register center register error! message = {}",e.getMessage(),e);
        }
    }

    public void unregister(Class clz) {

    }

    public void subscribe(Class clz) {

    }

    public void unsubscribe(Class clz) {

    }

    public void setClient(CuratorFramework client) {
        this.client = client;
    }


    private String generateServicePath(String serviceName){
        return ROOT_PATH + "/" + serviceName;
    }

    private String generateProviderPath(String servicePath){
        return servicePath + "/provider";
    }

    private String generateConsumerPath(String servicePath){
        return servicePath + "/consumer";
    }

    public String generateUrl(String path,String value){
        return path + "/" + value;
    }
}
