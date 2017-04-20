package com.gpengtao.example.stateless.test;

import com.google.common.collect.Lists;
import com.gpengtao.example.stateless.model.Applicant;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;

import java.util.List;

/**
 * 文档上的stateless例子
 * <p>
 * Created by pengtao.geng on 2016/11/15.
 */
public class ApplicantMainTest_1 {

    public static void main(String[] args) {

        KieServices kieServices = KieServices.Factory.get();
        KieContainer kieContainer = kieServices.newKieClasspathContainer();

        // 寻找default的并且是stateless的session
        StatelessKieSession session = kieContainer.newStatelessKieSession();

        Applicant applicant1 = new Applicant("a1", 20);
        session.execute(applicant1);

        System.out.println(applicant1);

        Applicant applicant2 = new Applicant("a2", 10);
        session.execute(applicant2);

        System.out.println(applicant2);

        /////////////////////////////////

        // 批量执行
        List<Applicant> list = Lists.newArrayList(new Applicant("b1", 25), new Applicant("b2", 15));
        System.out.println(list);

        session.execute(list);

        System.out.println(list);

    }
}
