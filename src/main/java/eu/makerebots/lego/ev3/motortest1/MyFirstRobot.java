package eu.makerebots.lego.ev3.motortest1;

import ev3dev.actuators.LCD;
import ev3dev.sensors.Button;
import lejos.hardware.lcd.GraphicsLCD;
import lejos.robotics.Color;
import lejos.utility.Delay;

public class MyFirstRobot {

    public static void main(final String[] args){

        prepareAndWait();

        Task1RoomToRoom task1 = new Task1RoomToRoom();
        task1.go();

        System.exit(0);
    }

    private static void prepareAndWait() {

        GraphicsLCD lcd = LCD.getInstance();
        clear(lcd);

        System.out.println("Brick is ready, disconnect from usb.");

        //writeMessage("Press RIGHT to start", lcd);
        //wait to start after load
        //Button.RIGHT.waitForPress();
        Delay.msDelay(10000);
    }

    private static void sayHi(){

        GraphicsLCD lcd = LCD.getInstance();
        clear(lcd);
        writeMessage("hi!", lcd);
        Delay.msDelay(10000);
    }

    private static void writeMessage(final String message, GraphicsLCD lcd){
        lcd.setColor(Color.BLACK);
        lcd.drawString(message, 50,50, 0);
        lcd.refresh();
    }

    private static void clear(GraphicsLCD lcd){
        lcd.setColor(Color.WHITE);
        lcd.fillRect(0,0, lcd.getWidth(), lcd.getHeight());
    }

}
