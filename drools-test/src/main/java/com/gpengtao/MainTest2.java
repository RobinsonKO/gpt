package com.gpengtao;

import org.drools.template.model.*;
import org.drools.template.model.Package;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.model.KieBaseModel;
import org.kie.api.builder.model.KieModuleModel;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;

/**
 * Created by pengtao.geng on 2016/9/7.
 */
public class MainTest2 {

    public static void main(String[] args) {

        Import imp = new Import();
        imp.setClassName(Payment.class.getName());

        Condition condition = new Condition();
        condition.setSnippet("model:Payment(model.getMoney() == 100)");

        Consequence consequence = new Consequence();
        consequence.setSnippet("System.out.println(\"hello\");");

        Rule rule = new Rule("rule_1", null, 3);
        rule.addCondition(condition);
        rule.addConsequence(consequence);
        rule.setComment("test");

        Package rulePackage = new Package("gpt_template");
        rulePackage.addRule(rule);
        rulePackage.addImport(imp);

        final DRLOutput out = new DRLOutput();
        rulePackage.renderDRL(out);
        String drl = out.getDRL();

        System.out.println(drl);

        KieServices services = KieServices.Factory.get();

        KieModuleModel kieModuleModel = services.newKieModuleModel();
        KieFileSystem kieFileSystem = services.newKieFileSystem();

        KieBaseModel baseModel = kieModuleModel.newKieBaseModel("kbase-rule_1");
        baseModel.addPackage("gpt_template");
        baseModel.newKieSessionModel("rule_1");

        kieFileSystem.writeKModuleXML(kieModuleModel.toXML());
        kieFileSystem.write("src/main/resources/gpt_template/rule_1.drl",ResourceFactory.newByteArrayResource(drl.getBytes()));

        KieBuilder kieBuilder = services.newKieBuilder(kieFileSystem);
        kieBuilder.buildAll();

        KieContainer container = services.newKieContainer(services.getRepository().getDefaultReleaseId());

        KieSession session = container.newKieSession("rule_1");

        session.insert(new Payment(100));
        session.fireAllRules();

        session.dispose();
    }

}
