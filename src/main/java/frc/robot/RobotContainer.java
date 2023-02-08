// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.operator_interface.OperatorInterface;
import frc.robot.subsystems.PivotSystem;

public class RobotContainer {

  private OperatorInterface oi = new OperatorInterface() {};
  private PivotSystem pivotSystem = new PivotSystem();

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    oi.moveArmForward().onTrue(pivotSystem.PivotArm(0.2));
    oi.moveArmBackward().onTrue(pivotSystem.PivotArm(-0.2));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}