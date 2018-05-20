package mengfw.registry_center;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Host {
    private String ip;
    private int port;
    public String toString(){
        return ip+":"+port;
    }
}
