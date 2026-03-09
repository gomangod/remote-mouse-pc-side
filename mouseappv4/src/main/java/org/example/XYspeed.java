package org.example;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.im.spi.InputMethod;

public class XYspeed {



        static int speedx;
        static int speedy;
        static Robot robo;

    static {
        try {
            robo = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }




    public int getSpeedx() {
            return speedx;
        }

        public void setSpeedx(int speedx) {
            this.speedx = speedx;
        }

        public int getSpeedy() {
            return speedy;
        }

        public void setSpeedy(int speedy) {
            this.speedy = speedy;
        }

        public static void moveingmouse() throws AWTException {
            Point currentlocation = MouseInfo.getPointerInfo().getLocation();
            robo.mouseMove(currentlocation.x - speedx, currentlocation.y - speedy);
        }

        public static void Leftclick(){
            robo.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robo.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        }

        public static void Rightclick(){
            robo.mousePress(InputEvent.BUTTON3_DOWN_MASK);
            robo.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
        }
        public static void Middleclick(){
            robo.mousePress(InputEvent.BUTTON2_DOWN_MASK);
            robo.mouseRelease(InputEvent.BUTTON2_DOWN_MASK);
        }
    public static void Scroll(boolean sidescroll, int i){
        if(sidescroll){
            robo.keyPress(KeyEvent.VK_SHIFT);
            robo.mouseWheel(i);
            robo.keyRelease(KeyEvent.VK_SHIFT);
        }
        else {
            robo.mouseWheel(i);
        }
    }

}
