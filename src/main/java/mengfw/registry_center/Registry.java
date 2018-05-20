package mengfw.registry_center;

/**
 *
 * Created by mengfw on 2018/5/16.
 */
public interface Registry {
    void register(Class clz,Host host);
    void unregister(Class clz);
    void subscribe(Class clz);
    void unsubscribe(Class clz);
}
