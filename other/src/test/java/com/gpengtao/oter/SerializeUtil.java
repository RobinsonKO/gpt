package com.gpengtao.oter;

import com.google.common.base.Splitter;
import com.tdunning.math.stats.AVLTreeDigest;
import com.tdunning.math.stats.Centroid;
import com.tdunning.math.stats.TDigest;

import java.util.Iterator;

/**
 * Created by pengtao.geng on 2017/4/7.
 */
public class SerializeUtil {

    private static final Splitter splitter = Splitter.on("~");

    public static String serializeAvl(TDigest digest) {
        StringBuilder strBuf = new StringBuilder();
        strBuf.append(AVLTreeDigest.VERBOSE_ENCODING).append("~");
        strBuf.append(digest.compression()).append("~");
        strBuf.append(digest.centroids().size()).append("~");
        for (Centroid centroid : digest.centroids()) {
            strBuf.append(centroid.mean()).append("~");
        }
        for (Centroid centroid : digest.centroids()) {
            strBuf.append(centroid.count()).append("~");
        }
        return strBuf.toString();
    }

    public static AVLTreeDigest parseAvlFromString(String digestString) {
        Iterator<String> iterator = splitter.split(digestString).iterator();

        int encoding = Integer.parseInt(iterator.next());
        double compression = Double.parseDouble(iterator.next());

        if (encoding != AVLTreeDigest.VERBOSE_ENCODING) {
            throw new IllegalStateException("Invalid format for serialized histogram");
        }

        AVLTreeDigest result = new AVLTreeDigest(compression);

        int size = Integer.parseInt(iterator.next());

        double[] means = new double[size];
        for (int i = 0; i < size; i++) {
            means[i] = Double.valueOf(iterator.next());
        }
        for (int i = 0; i < size; i++) {
            result.add(means[i], Integer.valueOf(iterator.next()));
        }

        return result;

    }
}
