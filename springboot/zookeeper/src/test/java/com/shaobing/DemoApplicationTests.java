package com.shaobing;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() throws IOException {
        ZooKeeper zClient = new ZooKeeper("106.13.144.143:2181", 40000, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
            }
        });
    }

}
