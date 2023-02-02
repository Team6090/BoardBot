package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;

import com.revrobotics.ColorSensorV3;

public class Sensors extends SubsystemBase {
    
    final I2C.Port i2cPort = I2C.Port.kOnboard;

    ColorSensorV3 colorSensorV3 = new ColorSensorV3(i2cPort);

    public Color GetColor() {
        return colorSensorV3.getColor();
    }

    public double GetIR() {
        return colorSensorV3.getIR();
    }
    
    public double GetDistance() {
        return colorSensorV3.getProximity();
    }

    @Override
    public void periodic() {
        
        SmartDashboard.putNumber("Red", GetColor().red);
        SmartDashboard.putNumber("Green", GetColor().green);
        SmartDashboard.putNumber("Blue", GetColor().blue);

        SmartDashboard.putNumber("Distance", GetDistance());

        SmartDashboard.putNumber("IR", GetIR());
    }
}
