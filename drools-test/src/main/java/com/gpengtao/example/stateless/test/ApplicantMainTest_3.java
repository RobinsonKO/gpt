package com.gpengtao.example.stateless.test;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;

/**
 * Created by pengtao.geng on 2016/11/15.
 */
public class ApplicantMainTest_3 {

    public static void main(String[] args) {

        KieServices kieServices = KieServices.Factory.get();
        KieContainer container = kieServices.newKieClasspathContainer();

        // newKieSession实际会创建stateFull的session
        // 所以这里会抛异常，因为applicant-rules2是stateless的
        KieSession session = container.newKieSession("applicant-rules2");

        System.out.println(session);
    }
}
