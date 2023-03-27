package frc.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class TalkCommand extends CommandBase {

    TalkCommand() {

    }

    @Override
    public void initialize() {
        SmartDashboard.putNumber("Test", DriverStation.getMatchTime());
    }  


}