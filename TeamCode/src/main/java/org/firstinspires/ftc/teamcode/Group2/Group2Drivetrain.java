package org.firstinspires.ftc.teamcode.Group2;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name="Group 2 Drivetrain Code")
public class Group2Drivetrain extends OpMode {

    // Declare the motors
    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor backLeft;
    DcMotor backRight;
    DcMotor flywheel;

    // Declare the variables
    double leftPow;
    double rightPow;

    boolean slowMode = false;
    @Override
    public void init() {
        // Define the motors using the hardware map stored on the driver hub
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        flywheel = hardwareMap.get(DcMotor.class, "flywheel");

        // Set the direction of the motors to account for mounting orientation
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        frontLeft.setDirection(DcMotorSimple.Direction.FORWARD);
        backRight.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeft.setDirection(DcMotorSimple.Direction.FORWARD);
    }

    @Override
    public void loop() {
        double y = -gamepad1.left_stick_y; // Remember, Y stick is reversed!
        double x = gamepad1.left_stick_x;
        double rx = gamepad1.right_stick_x;

        frontLeft.setPower(y + x + rx);
        backLeft.setPower(y - x + rx);
        frontRight.setPower(y - x - rx);
        backRight.setPower(y + x - rx);
    }
}