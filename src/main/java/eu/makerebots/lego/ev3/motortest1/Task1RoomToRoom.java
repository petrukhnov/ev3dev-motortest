package eu.makerebots.lego.ev3.motortest1;

import ev3dev.actuators.lego.motors.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.utility.Delay;

/**
 * Created by jax on 2017-10-16.
 */
public class Task1RoomToRoom {

    private static final int TURN_RIGHT = 1;
    private static final int TURN_LEFT = -1;


    private final EV3LargeRegulatedMotor motorLeft = new EV3LargeRegulatedMotor(MotorPort.A);
    private final EV3LargeRegulatedMotor motorRight = new EV3LargeRegulatedMotor(MotorPort.B);


    public void go() {

        //pause after upload

        //To Stop the motor in case of pkill java for example
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                System.out.println("Emergency Stop");
                motorLeft.stop();
                motorRight.stop();
            }
        }));

        motorLeft.brake();
        motorRight.brake();

        moveForward(200);

        turnRight90();
        //moveForward(20);
        //turnRight90();
        //moveForward(2000);
        //turnRight90();
        //moveForward(20);

        //back
        turn(TURN_LEFT, 180);

        //moveForward(20);
        //turnLeft90();
        //moveForward(2000);
        //turnLeft90();
        //turnLeft90();

    }

    private void moveForward(int cm) {

        final int motorSpeed = 500;
        motorLeft.setSpeed(motorSpeed);
        motorRight.setSpeed(motorSpeed);

        motorLeft.forward();
        motorRight.forward();

        Delay.msDelay(cm*100);

        motorLeft.stop();
        motorRight.stop();

    }

    private void turnRight90() {
        turn(TURN_RIGHT,90);
    }

    private void turnLeft90() {
        turn(TURN_LEFT,90);
    }

    private void turn(int direction, int degree) {

        final int motorSpeed = 200;
        motorLeft.setSpeed(motorSpeed);
        motorRight.setSpeed(motorSpeed);

        if (direction == TURN_RIGHT) {
            motorLeft.backward();
            motorRight.forward();
        } else {
            motorLeft.forward();
            motorRight.backward();
        }

        Delay.msDelay(10*degree);

        motorLeft.stop();
        motorRight.stop();
    }


}
