package org.eclipse.digitaltwin.basyx.aasdiscoveryservice.client;

import org.eclipse.digitaltwin.basyx.aasdiscoveryservice.client.internal.AasDiscoveryServiceApi;
import org.eclipse.digitaltwin.basyx.aasdiscoveryservice.core.AasDiscoveryService;
import org.eclipse.digitaltwin.basyx.aasdiscoveryservice.core.AasDiscoveryServiceSuite;
import org.junit.BeforeClass;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

public class TestConnectedAasDiscoveryService extends AasDiscoveryServiceSuite {

    private static ConfigurableApplicationContext appContext;
    private final static String BASEPATH = "http://localhost:8080";

    @BeforeClass
    public static void startAASRepo() throws Exception {
        appContext = new SpringApplicationBuilder(DummyAasDiscoveryServiceComponent.class).profiles("clienttest").run(new String[] {});
    }

    @Override
    protected AasDiscoveryService getAasDiscoveryService() {
        return new ConnectedAasDiscoveryService(new AasDiscoveryServiceApi(BASEPATH));
    }
}
