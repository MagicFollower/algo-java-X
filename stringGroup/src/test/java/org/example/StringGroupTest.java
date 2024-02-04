package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class StringGroupTest {
    @Test
    public void test_StringGroupTest_1707055066858() {
        String str = StringUtils.repeat("hello", 4);
        int count = 3;
        int gc = str.length() % count == 0 ? str.length() / count : str.length() / count + 1;
        String[] strGroupedArr = new String[gc];
        for (int i = 0, j = 0; i < gc; i++, j = i * count) {
            strGroupedArr[i] = str.substring(j, Math.min(j + count, str.length()));
        }
        Gson gson = new GsonBuilder().create();
        // ["hel","loh","ell","ohe","llo","hel","lo"]
        System.out.println(gson.toJson(strGroupedArr));
    }
}
