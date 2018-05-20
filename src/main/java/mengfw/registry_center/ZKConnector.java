package mengfw.registry_center;


import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class ZKConnector implements Connector {
    private static int DEFAULT_SESSION_TIMEOUT = 5000;
    private static int DEFAULT_CONNECTION_TIMEOUT = 5000;
    private static RetryPolicy DEFAULT_RETRY_POLICY = new ExponentialBackoffRetry(1000, 3);
    private Host host;
    private int sessionTimeout;
    private int connectionTimeout;
    private RetryPolicy retryPolicy;
    public Registry connect() {
        CuratorFramework client = CuratorFrameworkFactory.builder().connectString(host.toString())
                .sessionTimeoutMs(sessionTimeout)//会话超时时间
                .connectionTimeoutMs(connectionTimeout)//连接超时时间
                .retryPolicy(retryPolicy)
                .build();

        client.start();
        ZKRegistry zk = new ZKRegistry();
        zk.setClient(client);
        return zk;
    }

    public ZKConnector(Host host) {
        this(host,DEFAULT_SESSION_TIMEOUT,DEFAULT_CONNECTION_TIMEOUT,DEFAULT_RETRY_POLICY);
    }

    public ZKConnector(Host host, int sessionTimeout, int connectionTimeout, RetryPolicy retryPolicy) {
        this.host = host;
        this.sessionTimeout = sessionTimeout;
        this.connectionTimeout = connectionTimeout;
        this.retryPolicy = retryPolicy;
    }
}

