import java.util.Map;
import java.util.TreeMap;

class TreeMapFactory implements MapFactory {
    @Override
    public Map<String, Pokemon> createMap() {
        return new TreeMap<>();
    }
}