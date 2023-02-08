package frc.robot.operator_interface;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public interface OperatorInterface {
    XboxController xboxController = new XboxController(1);

    public default Trigger moveArmForward() {
        return new Trigger(()-> xboxController.getAButton());
    }

    public default Trigger moveArmBackward() {
        return new Trigger(()-> xboxController.getBButton());
    }

}