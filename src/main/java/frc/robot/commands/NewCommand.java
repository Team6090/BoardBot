package frc.robot.commands;

import edu.wpi.first.wpilibj.CAN;
import edu.wpi.first.wpilibj2.command.PrintCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

public class NewCommand extends SequentialCommandGroup{
    
    public NewCommand() {
        addCommands(
            new WaitCommand(1),
            new WaitCommand(1),
            new WaitCommand(1),
            new TalkCommand(),
            new WaitCommand(.5)
        );
    }

}