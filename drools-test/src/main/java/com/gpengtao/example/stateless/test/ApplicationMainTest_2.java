package com.gpengtao.example.stateless.test;

import com.google.common.collect.Lists;
import com.gpengtao.example.stateless.model.Applicant;
import com.gpengtao.example.stateless.model.Application;
import org.kie.api.KieServices;
import org.kie.api.command.Command;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;

import java.util.Date;

/**
 * 执行command
 * <p>
 * <p>
 * Created by pengtao.geng on 2016/11/15.
 */
public class ApplicationMainTest_2 {

    public static void main(String[] args) {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer container = kieServices.newKieClasspathContainer();
        StatelessKieSession session = container.newStatelessKieSession("application-rules");

        Applicant applicant = new Applicant("a1", 20);
        Application application = new Application(new Date());

        Command command = kieServices.getCommands().newInsertElements(Lists.newArrayList(applicant, application));

        session.execute(command);

        System.out.println(applicant);
        System.out.println(application);

    }
}
