package com.gpengtao.test;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.Message;
import org.kie.api.builder.model.KieBaseModel;
import org.kie.api.builder.model.KieModuleModel;
import org.kie.api.io.KieResources;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * Created by pengtao.geng on 2016/9/9.
 */
public class MessageTest {

    public static void main(String[] args) {
        KieServices kieServices = KieServices.Factory.get();
        KieResources resources = kieServices.getResources();
        KieModuleModel kieModuleModel = kieServices.newKieModuleModel();

        KieBaseModel baseModel = kieModuleModel.newKieBaseModel("FileSystemKBase");
        baseModel.addPackage("rules");
        baseModel.newKieSessionModel("message-session");

        KieFileSystem fileSystem = kieServices.newKieFileSystem();

        String xml = kieModuleModel.toXML();
        System.out.println(xml);
        fileSystem.writeKModuleXML(xml);

        fileSystem.write("src/main/resources/rules/rule.drl", resources.newClassPathResource("drlFile/hello.drl"));

        KieBuilder kb = kieServices.newKieBuilder(fileSystem);
        kb.buildAll();

        if (kb.getResults().hasMessages(Message.Level.ERROR)) {
            throw new RuntimeException("Build Errors:\n" + kb.getResults().toString());
        }

        KieContainer kContainer = kieServices.newKieContainer(kieServices.getRepository().getDefaultReleaseId());

        KieSession kSession = kContainer.newKieSession("message-session");

        kSession.fireAllRules();

    }
}
