package mengfw.registry_center;


public class RegisterCenterTest {
    public static void main(String[] args) {
        Registry registry = RegistryWrapper.builder().connect(new ZKConnector(new Host("127.0.0.1",2181))).build();
        registry.register(TestService.class,new Host("127.0.0.1",1111));

        System.out.println();
    }
}
