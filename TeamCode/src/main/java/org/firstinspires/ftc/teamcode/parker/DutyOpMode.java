package org.firstinspires.ftc.teamcode.parker;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;


public class DutyOpMode extends OpMode {

    private DcMotor exampleMotor;

    @Override
    public void init() {

    }

    @Override
    public void loop() {
        if (gamepad1.y) {
            exampleMotor.setPower(1);
            telemetry.addLine("Gamepad 1 Y is pressed");
        }
        else {
            exampleMotor.setPower(0);
            telemetry.addLine("Gamepad 1 Y is not pressed");
        }
    }
}
