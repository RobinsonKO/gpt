package com.gpengtao.main;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * Created by gpengtao on 16/9/19.
 */
public class GlobalTest {

    public static void main(String[] args) {
        KieServices services = KieServices.Factory.get();

        KieContainer container = services.getKieClasspathContainer();

        KieSession session = container.newKieSession("ksession-global-test-rules");

        session.insert(new Object());
        session.fireAllRules();

        session.dispose();
    }
}
