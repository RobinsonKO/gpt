package com.gpengtao.main;

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
 * Created by pengtao.geng on 2016/9/7.
 */
public class GenerateDrlTest {

    public static void main(String[] args) {

        Package rulePackage1 = getPackage1();
        Package rulePackage2 = getPackage2();

        String drl1 = getDrlString(rulePackage1);
        String drl2 = getDrlString(rulePackage2);

        System.out.println(drl1);
        System.out.println(drl2);

        KieServices services = KieServices.Factory.get();

        // moduleModel 和 fileSystem是单独的对象，这里只是new出来，实际和services没关联
        KieModuleModel kieModuleModel = services.newKieModuleModel();
        KieFileSystem kieFileSystem = services.newKieFileSystem();

        // 一个container下多个modelModel，这个new多个就可以
        KieBaseModel baseModel = kieModuleModel.newKieBaseModel("kie-base-rule111");
        baseModel.addPackage("package_111");// 决定了资源文件的目录，即 src/main/resources/package_111
        baseModel.newKieSessionModel("rule_111");

        KieBaseModel baseModel2 = kieModuleModel.newKieBaseModel("kie-base-rule222");
        baseModel2.addPackage("package_222");
        baseModel2.newKieSessionModel("rule_222");

        String moduleXml = kieModuleModel.toXML();
        System.out.println(moduleXml);

        kieFileSystem.writeKModuleXML(moduleXml);
        kieFileSystem.write("src/main/resources/package_111/xxx.drl", ResourceFactory.newByteArrayResource(drl1.getBytes()));
        kieFileSystem.write("src/main/resources/package_222/xxx.drl", ResourceFactory.newByteArrayResource(drl2.getBytes()));

        KieBuilder kieBuilder = services.newKieBuilder(kieFileSystem);
        kieBuilder.buildAll();

        KieContainer container = services.newKieContainer(services.getRepository().getDefaultReleaseId());

        KieSession session = container.newKieSession("rule_111");

        Payment payment = new Payment(0);

        session.insert(payment);
        session.fireAllRules();

        session.dispose();

        System.out.println(payment);
    }

    private static String getDrlString(Package rulePackage) {
        DRLOutput out = new DRLOutput();
        rulePackage.renderDRL(out);
        return out.getDRL();
    }

    private static Package getPackage1() {
        Import imp = new Import();
        imp.setClassName(Payment.class.getName());

        Rule rule1 = getRule1();
        Rule rule2 = getRule2();

        // package
        Package rulePackage = new Package("com.gpengtao");
        rulePackage.addRule(rule2);
        rulePackage.addRule(rule1);
        rulePackage.addImport(imp);
        return rulePackage;
    }

    private static Package getPackage2() {
        Import imp = new Import();
        imp.setClassName(Payment.class.getName());

        Rule rule1 = getRule1();

        // package
        Package rulePackage = new Package("com.gpengtao");
        rulePackage.addRule(rule1);
        rulePackage.addImport(imp);
        return rulePackage;
    }

    private static Rule getRule1() {
        // condition
        Condition condition = new Condition();
        condition.setSnippet("model:Payment(money == 0)");

        // consequence
        Consequence add = new Consequence();
        add.setSnippet("model.setMoney(model.getMoney() + 100);");

        Consequence print = new Consequence();
        print.setSnippet("System.out.println(\"hello rule 111 \" + model);");// 分号不能少

        // rule1
        Rule rule1 = new Rule("rule_1", 1, 0);
        rule1.addCondition(condition);
        rule1.addConsequence(add);
        rule1.addConsequence(print);
        rule1.setComment("test");
        return rule1;
    }

    private static Rule getRule2() {
        // rule2
        Condition condition = new Condition();
        condition.setSnippet("model:Payment(money == 0)");

        Consequence add2 = new Consequence();
        add2.setSnippet("model.setMoney(model.getMoney() + 200);");

        Consequence print = new Consequence();
        print.setSnippet("System.out.println(\"hello rule 222 \" + model);");

        Rule rule2 = new Rule("rule_2", 2, 0);
        rule2.addCondition(condition);
        rule2.addConsequence(add2);
        rule2.addConsequence(print);
        rule2.setComment("test");
        return rule2;
    }

}
