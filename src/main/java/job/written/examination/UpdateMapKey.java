package job.written.examination;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class UpdateMapKey {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();

        for(Integer index = 0; index < 10; index ++) {
            map.put("index: " + index,  "result: " + index );
        }

        Set<String> keySet = map.keySet();
        Set<String> removeSet = new HashSet<>();
        for(String key : keySet) {
            if(key.contains("7")) {
                removeSet.add(key);
            }
        }

        Set<String> removeSets =  map.keySet().stream().filter(key -> key.contains("7")).collect(Collectors.toSet());

        System.out.println(JSON.toJSONString(removeSets));
    }
}
