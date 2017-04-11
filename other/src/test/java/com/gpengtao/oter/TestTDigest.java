package com.gpengtao.oter;

import com.google.common.collect.Lists;
import com.google.common.io.Files;
import com.tdunning.math.stats.AVLTreeDigest;
import com.tdunning.math.stats.TDigest;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;

/**
 * Created by pengtao.geng on 2017/4/6.
 */
public class TestTDigest {

    @Test
    public void test_serialize() {
        TDigest digest = TDigest.createAvlTreeDigest(10);

        for (int i = 0; i < 5; i++) {
            digest.add(i);
        }

        double quantile = digest.quantile(0.9);

        System.out.println("quantile: " + quantile);

        System.out.println("centroids: " + digest.centroids().size());

        String serializeAvl = SerializeUtil.serializeAvl(digest);
        System.out.println(serializeAvl);

        AVLTreeDigest digest2 = SerializeUtil.parseAvlFromString(serializeAvl);

        System.out.println(digest2.quantile(0.9));
    }

    @Test
    public void test_two_digest_add() {
        TDigest digest1 = TDigest.createAvlTreeDigest(10);
        for (int i = 0; i < 10000; i++) {
            digest1.add(i);
        }

        TDigest digest2 = TDigest.createAvlTreeDigest(10);
        for (int i = 10000; i < 20000; i++) {
            digest2.add(i);
        }

        digest1.add(digest2);
        System.out.println(digest1.quantile(0.9));

        TDigest digest3 = TDigest.createAvlTreeDigest(10);
        for (int i = 0; i < 20000; i++) {
            digest3.add(i);
        }
        System.out.println(digest3.quantile(0.9));
    }

    @Test
    public void test_by_real_data() throws IOException {
        TDigest digest1 = TDigest.createAvlTreeDigest(10);

        List<String> lines = Files.readLines(new File("C:\\Users\\pengtao.geng\\Desktop\\detail.txt"), Charset.defaultCharset());

        System.out.println(lines.size());

        for (String line : lines) {
            digest1.add(Double.valueOf(line.split(",")[3]));
        }

        System.out.println(SerializeUtil.serializeAvl(digest1));

        List<Integer> list = Lists.newArrayList();
        for (String line : lines) {
            list.add(Integer.parseInt(line.split(",")[3]));
        }

        Collections.sort(list);

        System.out.println(list.get((int) (list.size() * 0.9)));
    }

}
