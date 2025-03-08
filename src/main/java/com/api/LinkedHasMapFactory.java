import java.util.LinkedHashMap;
import java.util.Map;

class LinkedHashMapFactory implements MapFactory {
    @Override
    public Map<String, Pokemon> createMap() {
        return new LinkedHashMap<>();
    }
}