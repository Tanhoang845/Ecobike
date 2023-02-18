package utils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @Project: Capstone
 * @Author: sonle
 * @Date: 05/02/2023
 * @Time: 17:47
 * @Teacher: GV.Nguyen Thi Thu Trang
 */
public class ENV {
    private static final Map<String, String> envMap = new HashMap<>();

    static {
        try {
            FileInputStream fis = new FileInputStream(".env");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] kv = line.split(" *= *");
                envMap.put(kv[0], kv.length == 2 ? kv[1] : "");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private ENV() {
    }


    public static String getenv(String key) {
        return envMap.get(key);
    }
}
