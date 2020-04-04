package com.geetion.thingsboard;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thingsboard.rest.client.RestClient;
import org.thingsboard.server.common.data.id.DeviceId;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GeetionApplicationTests {

    @Autowired
    private RestClient restClient;

    @Test
    public void contextLoads() throws IOException {
        String json = "{ \"method\" : \"openDoor\"}";
        String deviceId = "73e084a0-3150-11ea-9389-17e860994574";
        JsonNode jsonNode = new ObjectMapper().readValue(json, JsonNode.class);
        restClient.handleOneWayDeviceRPCRequest(DeviceId.fromString(deviceId), jsonNode);
    }

}
