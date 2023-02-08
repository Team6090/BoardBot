package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.sensors.CANCoder;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PivotSystem extends SubsystemBase{
        
    CANCoder pivotAngleCanCoder;
    
    TalonFX pivotMotorRight;
    TalonFX pivotMotorLeft;

    private static final boolean DEBUGGING = true;

    /* Instantiate the Motors and CANCoder */
    public PivotSystem() {
    pivotMotorLeft = new TalonFX(DrivetrainConstants.PivotMotorLeftID);
    pivotMotorRight = new TalonFX(DrivetrainConstants.PivotMotorRightID);
    pivotAngleCanCoder = new CANCoder(DrivetrainConstants.PivotAngleCanCoderID);
    
    if (DEBUGGING){
        pivotMotorLeft.setNeutralMode(NeutralMode.Coast);
        pivotMotorRight.setNeutralMode(NeutralMode.Coast); 
    }else{
        pivotMotorLeft.setNeutralMode(NeutralMode.Brake);
        pivotMotorRight.setNeutralMode(NeutralMode.Brake);
    }
    }

    /* Create code that moves the arm based on the power being applied */
    public Command PivotArm(double power) {
        pivotMotorLeft.set(TalonFXControlMode.Velocity, power);
        pivotMotorRight.set(TalonFXControlMode.Velocity, power);
        return null;
    }

    /* Retrive the cancoder's position to find the pivot of the arm */
    public double GetArmPivot() {
        return pivotAngleCanCoder.getPosition();
    }

    @Override
    public void periodic() {
        /* If you have anything you want logged do it here */
            SmartDashboard.putNumber("CanCoder Position", pivotAngleCanCoder.getPosition());
    }
}