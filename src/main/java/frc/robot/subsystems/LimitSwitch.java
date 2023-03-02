package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LimitSwitch extends SubsystemBase {
    DigitalInput limitSwitch;

    public LimitSwitch (){
        limitSwitch = new DigitalInput(0);
    }

    @Override
    public void periodic() {
        SmartDashboard.putBoolean("Limit Switch", limitSwitch.get());
    }

}

