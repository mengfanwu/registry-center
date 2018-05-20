package mengfw.registry_center;


public class RegistryWrapper implements Registry{
    private Registry proxy;
    private RegistryListener listener;

    public void register(Class clz,Host host) {
        proxy.register(clz,host);
    }

    public void unregister(Class clz) {
        proxy.unregister(clz);
    }

    public void subscribe(Class clz) {
        proxy.subscribe(clz);
    }

    public void unsubscribe(Class clz) {
        proxy.unsubscribe(clz);
    }

    public static Builder builder(){
        return new Builder();
    }
    public static class Builder{
        private Connector connector;
        private RegistryListener listener;

        private Builder() {
        }

        public Builder connect(Connector connector){
            this.connector = connector;
            return this;
        }
        public Builder listener(RegistryListener listener){
            this.listener = listener;
            return this;
        }
        public RegistryWrapper build(){
            RegistryWrapper registry = new RegistryWrapper();
            registry.listener = this.listener;
            registry.proxy = connector.connect();
            return registry;
        }
    }
}
