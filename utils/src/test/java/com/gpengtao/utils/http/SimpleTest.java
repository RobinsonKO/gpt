package com.gpengtao.utils.http;

import org.apache.http.HttpClientConnection;
import org.apache.http.HttpHost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ConnectionRequest;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by pengtao.geng on 2016/11/30.
 */
public class SimpleTest {

    @Test
    public void test_connection_manager() throws InterruptedException, ExecutionException, IOException {

        HttpClientContext context = HttpClientContext.create();

        BasicHttpClientConnectionManager manager = new BasicHttpClientConnectionManager();

        HttpRoute httpRoute = new HttpRoute(new HttpHost("www.baidu.com"));

        ConnectionRequest connectionRequest = manager.requestConnection(httpRoute, null);

        HttpClientConnection connection = connectionRequest.get(10, TimeUnit.SECONDS);

        manager.connect(connection, httpRoute, 1000, context);


    }
}
