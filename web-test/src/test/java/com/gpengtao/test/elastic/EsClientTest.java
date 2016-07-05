package com.gpengtao.test.elastic;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.elasticsearch.action.ActionFuture;
import org.elasticsearch.action.WriteConsistencyLevel;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.cluster.node.DiscoveryNode;
import org.elasticsearch.common.collect.ImmutableList;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.unit.TimeValue;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * Created by pengtao.geng on 2015/9/22.
 */
public class EsClientTest {

    private final Logger logger = LoggerFactory.getLogger("es");

    private TransportClient client;

    @Before
    public void init_client() {
        ImmutableSettings.Builder builder = ImmutableSettings.settingsBuilder();
        builder.put("cluster.name", "gpengtao_es");
        builder.put("client.transport.ping_timeout", 10000);
        builder.put("discovery.zen.ping.multicast.enabled", "false");
        builder.put("timeout", 1);

        Settings settings = builder.build();

        client = new TransportClient(settings);

        client.addTransportAddress(new InetSocketTransportAddress("10.86.36.12", 9300));
        client.addTransportAddress(new InetSocketTransportAddress("10.86.36.15", 9300));
        client.addTransportAddress(new InetSocketTransportAddress("10.86.37.7", 9300));
    }

    @Test
    public void test_index_api() throws ExecutionException, InterruptedException {
        ImmutableList<DiscoveryNode> nodes = client.listedNodes();
        for (DiscoveryNode node : nodes) {
            logger.info("node : {}", node);
        }

        printConnectedNode(client);

        int i = 1;
        while (true) {

            System.out.println("====================");

            printConnectedNode(client);

            GetRequest getRequest = new GetRequest("gptapp", "user", "1");
            ActionFuture<GetResponse> future = client.get(getRequest);
            GetResponse response = future.get();
            Map<String, Object> map = response.getSourceAsMap();
            logger.info("count {} get result: {}", i++, map);

            Thread.sleep(1000);
        }
    }

    private void printConnectedNode(TransportClient client) {
        ImmutableList<DiscoveryNode> connectedNodes = client.connectedNodes();
        for (DiscoveryNode node : connectedNodes) {
            logger.info("connected node : {}", node);
        }
    }

    @Test
    public void index_and_update() throws ExecutionException, InterruptedException {
        String indexName = "xxx_order";
        String type = "order";

        // index
        Map<String, Object> passenger1 = Maps.newHashMap();
        passenger1.put("id", 111);
        passenger1.put("name", "gpengtao");

        Map<String, Object> passenger2 = Maps.newHashMap();
        passenger2.put("id", 222);
        passenger2.put("name", "gpengtao");

        Map<String, Object> docMap = Maps.newHashMap();
        docMap.put("id", 123);
        docMap.put("order_no", "xxx");
        docMap.put("i_passenger_ref", Lists.newArrayList(passenger1, passenger2));

        IndexRequestBuilder indexRequestBuilder = client.prepareIndex(indexName, type, "hello$1");
        indexRequestBuilder.setSource(docMap);
        indexRequestBuilder.setConsistencyLevel(WriteConsistencyLevel.QUORUM);
        indexRequestBuilder.setTimeout(TimeValue.timeValueMinutes(1));

        ActionFuture<IndexResponse> indexFuture = client.index(indexRequestBuilder.request());
        IndexResponse indexResponse = indexFuture.get();
        logger.info("index result : {}", indexResponse);

        // update
        UpdateRequest updateRequest = new UpdateRequest(indexName, type, "hello$1");
        updateRequest.doc(docMap);

        ActionFuture<UpdateResponse> responseActionFuture = client.update(updateRequest);
        UpdateResponse updateResponse = responseActionFuture.get();
        logger.info("update result : {}", updateResponse);
    }
}
