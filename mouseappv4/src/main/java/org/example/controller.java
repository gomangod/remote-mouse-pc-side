package org.example;

import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Character;
import java.net.URLEncoder;
import java.util.Objects;

@RestController
@CrossOrigin
public class controller {


    static XYspeed Speed;
    static AsciiKeyTyper asciiKeyTyper;

    static {
        try {
            asciiKeyTyper = new AsciiKeyTyper();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    @RequestMapping(value = "/action/key", method = RequestMethod.POST)
    public void Key(@RequestBody String KEY) throws InterruptedException {
        CharSequence key = KEY;
        for(int i = 1; i < key.length()-1; i++){
            asciiKeyTyper.typeKey(key.charAt(i));
        }

    }

    @RequestMapping(value  = "/action/key/enter")
    public void enter(){
        asciiKeyTyper.typeKey('\n');
    }

    @RequestMapping(value = "/action/key/backspace")
    public void backspace(){
        asciiKeyTyper.BackSpace();
    }

    @RequestMapping(value = "/action/Scroll")
    public void Scroll(@RequestBody ScrollState scrollState){
        if(scrollState.Side){
            XYspeed.Scroll(true, scrollState.dis);
        }
        else{
            XYspeed.Scroll(false,scrollState.dis);
        }
    }
    @RequestMapping(value = "/sendspeed",method = RequestMethod.POST)
    public XYspeed setspeed(@RequestBody XYspeed speed) throws AWTException {
           Speed = speed;
           XYspeed.moveingmouse();
           return speed;
    }

    @RequestMapping(value = "/action/leftclick")
    public String leftclick(){
          XYspeed.Leftclick();
          return "Left click";
    }

    @RequestMapping(value = "/action/rightclick")
    public String rightclick(){
        XYspeed.Rightclick();
        return "Right click";
    }
    @RequestMapping(value = "/action/middleclick")
    public String middleclick(){
        XYspeed.Middleclick();
        return "Middle click";
    }

    @RequestMapping(value = "/cmd", method = RequestMethod.POST)
    public String cmd(@RequestBody String command) throws IOException {
        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", command);
        builder.redirectErrorStream(true);
        Process p = builder.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        StringBuilder output = new StringBuilder();
        String line;
        while ((line = r.readLine()) != null) {
            output.append(line).append("\n");
        }
        return output.toString();
    }
}
