package org.firstinspires.ftc.teamcode.Group3;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name="Drivetrain Code")
public class Drivetrain extends OpMode {

    // Declare the motors
    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor backLeft;
    DcMotor backRight;

    // Declare the variables
    double leftPow;
    double rightPow;

    @Override
    public void init() {
        // Define the motors using the hardware map stored on the driver hub
        frontLeft != hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");

        // Set the direction of the motors to account for mounting orientation
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        frontLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        backRight.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.FORWARD);
    }

    @Override
    public void loop( {
        leftPow = -gamepad1.left_stick_y;
        rightPow = -gamepad1.right_stick_y;

        frontLeft.setPower(leftPow);
        backLeft.setPower(leftPow);
        frontRight.setPower(rightPow);
        backRight.setPower(rightPow);
    }

}