package com.gpengtao.example.statefull.test;

import com.gpengtao.example.statefull.model.Fire;
import com.gpengtao.example.statefull.model.Room;
import com.gpengtao.example.statefull.model.Sprinkler;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

import java.io.File;
import java.io.IOException;

/**
 * Created by pengtao.geng on 2016/11/15.
 */
public class SimpleTest {

    public static void main(String[] args) {
        KieContainer container = KieServices.Factory.get().newKieClasspathContainer();
        KieSession session = container.newKieSession("fire-rules");// stateFull的session

        Room livingRoom = new Room("客厅");
        Room kitchenRoom = new Room("厨房");
        Room bedroom = new Room("卧室");
        Room office = new Room("办公室");

        Sprinkler livingRoomSprinkler = new Sprinkler(livingRoom);
        Sprinkler kitchenRoomSprinkler = new Sprinkler(kitchenRoom);
        Sprinkler bedroomSprinkler = new Sprinkler(bedroom);
        Sprinkler officeSprinkler = new Sprinkler(office);

        session.insert(livingRoom);
        session.insert(bedroom);
        session.insert(kitchenRoom);
        session.insert(office);

        session.insert(livingRoomSprinkler);
        session.insert(kitchenRoomSprinkler);
        session.insert(bedroomSprinkler);
        session.insert(officeSprinkler);

        session.fireAllRules();

        pause();

        Fire bedroomFire = new Fire(bedroom);
        Fire livingRoomFire = new Fire(livingRoom);

        FactHandle bedroomFireHandler = session.insert(bedroomFire);
        FactHandle livingRoomFireHandler = session.insert(livingRoomFire);

        session.fireAllRules();

        pause();

        session.delete(bedroomFireHandler);
        session.fireAllRules();

        pause();

        session.delete(livingRoomFireHandler);
        session.fireAllRules();

        session.dispose();
    }

    private static void pause() {
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
