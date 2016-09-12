package com.gpengtao.test;

import com.gpengtao.model.Payment;
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
 * generate drl string, and test
 * <p>
 * Created by pengtao.geng on 2016/9/7.
 */
public class GenDrlTest {

    public static void main(String[] args) {

        String drl = getPackage1();
        String drl2 = getPackage2();

        System.out.println(drl);
        System.out.println(drl2);

        KieServices services = KieServices.Factory.get();

        KieModuleModel kieModuleModel = services.newKieModuleModel();
        KieFileSystem kieFileSystem = services.newKieFileSystem();

        // 一个container下多个modelModel，这个new多个就可以
        KieBaseModel baseModel = kieModuleModel.newKieBaseModel("kie-base-rule");
        baseModel.addPackage("com.gpengtao.file.drl");// 需要和src/main/resources下一致
        baseModel.newKieSessionModel("rule_xxx");

        KieBaseModel baseModel2 = kieModuleModel.newKieBaseModel("kie-base-rule2");
        baseModel2.addPackage("com.gpengtao.file.drl2");
        baseModel2.newKieSessionModel("rule_xxx2");

        String moduleXml = kieModuleModel.toXML();
        System.out.println(moduleXml);

        kieFileSystem.writeKModuleXML(moduleXml);
        kieFileSystem.write("src/main/resources/com.gpengtao.file.drl/xxx.drl", ResourceFactory.newByteArrayResource(drl.getBytes()));
        kieFileSystem.write("src/main/resources/com.gpengtao.file.drl2/xxx.drl", ResourceFactory.newByteArrayResource(drl2.getBytes()));

        KieBuilder kieBuilder = services.newKieBuilder(kieFileSystem);
        kieBuilder.buildAll();

        KieContainer container = services.newKieContainer(services.getRepository().getDefaultReleaseId());

        KieSession session = container.newKieSession("rule_xxx2");

        Payment payment = new Payment(0);

        session.insert(payment);
        session.fireAllRules();

        session.dispose();

        System.out.println(payment);
    }

    private static String getPackage1() {
        Import imp = new Import();
        imp.setClassName(Payment.class.getName());

        Rule rule1 = getRule1();
        Rule rule2 = getRule2();

        // package
        Package rulePackage = new Package("com.gpengtao");
        rulePackage.addRule(rule1);
        rulePackage.addRule(rule2);
        rulePackage.addImport(imp);

        final DRLOutput out = new DRLOutput();
        rulePackage.renderDRL(out);
        return out.getDRL();
    }

    private static String getPackage2() {
        Import imp = new Import();
        imp.setClassName(Payment.class.getName());

        Rule rule1 = getRule1();

        // package
        Package rulePackage = new Package("com.gpengtao");
        rulePackage.addRule(rule1);
        rulePackage.addImport(imp);

        final DRLOutput out = new DRLOutput();
        rulePackage.renderDRL(out);
        return out.getDRL();
    }

    private static Rule getRule1() {
        // condition
        Condition condition1 = new Condition();
        condition1.setSnippet("model:Payment(money == 0)");

        // consequence
        Consequence print1 = new Consequence();
        print1.setSnippet("System.out.println(\"hello 111 \" + model);");

        Consequence add1 = new Consequence();
        add1.setSnippet("model.setMoney(model.getMoney() + 100);");

        // rule1
        Rule rule1 = new Rule("rule_1", 1, 3);
        rule1.addCondition(condition1);
        rule1.addConsequence(add1);
        rule1.addConsequence(print1);
        rule1.setComment("test");
        return rule1;
    }

    private static Rule getRule2() {
        // rule2
        Condition condition2 = new Condition();
        condition2.setSnippet("model:Payment(money == 0)");

        Consequence print2 = new Consequence();
        print2.setSnippet("System.out.println(\"hello 222 \" + model);");

        Consequence add2 = new Consequence();
        add2.setSnippet("model.setMoney(model.getMoney() + 200);");

        Rule rule2 = new Rule("rule_2", 2, 3);
        rule2.addCondition(condition2);
        rule2.addConsequence(add2);
        rule2.addConsequence(print2);
        rule2.setComment("test");
        return rule2;
    }

}
