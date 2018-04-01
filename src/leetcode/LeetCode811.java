package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode811 {

    public List<String> subdomainVisits(String[] cpdomains) {
        if (cpdomains == null)
            return new ArrayList<String>();

        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String domain : cpdomains) {
            String[] s1 = domain.split(" ");
            int cnt = Integer.valueOf(s1[0]);
            String s2 = s1[1];
            bfs(s2, cnt, map);
        }

        List<String> ret = new ArrayList<String>();
        for (Map.Entry<String, Integer> en : map.entrySet()) {
            ret.add(en.getValue() + " " + en.getKey());
        }
        return ret;
    }

    private void bfs(String domain, int cnt, Map<String, Integer> map) {
        String[] dos = domain.split("\\.");
        StringBuilder sdos = new StringBuilder();
        for (int i=dos.length-1; i>=0; i--) {
            if (i != dos.length-1) {
                sdos.insert(0, ".");
            }
            sdos.insert(0, dos[i]);

            if (map.containsKey(sdos.toString())) {
                map.put(sdos.toString(), map.get(sdos.toString())+cnt);
            } else {
                map.put(sdos.toString(), cnt);
            }

        }
    }

}
