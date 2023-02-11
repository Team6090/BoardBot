package frc.robot.subsystems;

import com.revrobotics.ColorSensorV3;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.util.Color;

public interface Sensors {

  static final I2C.Port i2cPort = I2C.Port.kOnboard;

  static ColorSensorV3 IntakeSensor = new ColorSensorV3(i2cPort);

  public static double IntakeSensorProx() {
    return IntakeSensor.getProximity();
  }

  public static Color IntakeSensorColor(){
    return IntakeSensor.getColor();
  }
}
