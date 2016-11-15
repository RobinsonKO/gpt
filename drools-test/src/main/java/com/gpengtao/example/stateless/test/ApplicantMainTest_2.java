package com.gpengtao.example.stateless.test;

import com.gpengtao.example.stateless.model.Applicant;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;

/**
 * 修改后的，指定sessionName
 * <p>
 * Created by pengtao.geng on 2016/11/15.
 */
public class ApplicantMainTest_2 {

    public static void main(String[] args) {

        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.newKieClasspathContainer();

        // session实现类是：StatelessKnowledgeSessionImpl
        StatelessKieSession session = kieContainer.newStatelessKieSession("applicant-rules2");

        Applicant applicant1 = new Applicant("xx", 20);
        session.execute(applicant1);

        System.out.println(applicant1);
    }
}
