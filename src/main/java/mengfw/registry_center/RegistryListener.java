package mengfw.registry_center;

public interface RegistryListener {
    void providersChanged(Host... hosts);
}
