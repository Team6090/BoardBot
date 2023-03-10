package frc.robot.subsystems.intake;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.CanIds;
// import frc.robot.subsystems.pixy.PixySystem;
import frc.robot.subsystems.Sensors;

public class IntakeSystem extends SubsystemBase {

  VictorSP intakeMotor;
  Solenoid intakeSolenoid;

//   PixySystem pixySystem;

  boolean isIntakeSolenoidEnabled;

  public IntakeSystem() {
    // intakeMotor = new VictorSP(CanIds.IntakeMotorId);
    // intakeSolenoid =
    //     new Solenoid(CanIds.PCMModuleId, PneumaticsModuleType.CTREPCM, CanIds.IntakeSolenoidId);
    // pixySystem = new PixySystem();
  }

//   public void EnableIntakeSolenoid(boolean enable) {
//     intakeSolenoid.set(enable);
//     isIntakeSolenoidEnabled = enable;
//   }

//   public void EnableIntakeMotor(boolean enable, boolean isReverse) {
//     if (enable) {
//       if (!isReverse) {
//         intakeMotor.set(0.2);
//       } else {
//         intakeMotor.set(-0.2);
//       }
//     } else {
//       intakeMotor.set(0);
//     }
//   }

//   public boolean DetectedObject() {
//     if (pixySystem.ObjectCount() > 0) {
//       return true;
//     }
//     return false;
//   }

//   public int GetCurrentObjectSig() {
//     return pixySystem.GetObjectSig();
//   }

  public boolean ObjectInIntake() {
    double prox = Sensors.IntakeSensorProx();
    if (prox > 100) {
      return true;
    }
    return false;
  }

  public String ObjectType(){
    if (ObjectInIntake()) {
        Color intakeSensorColor = Sensors.IntakeSensorColor();
        if (intakeSensorColor.blue > intakeSensorColor.green || intakeSensorColor.blue > intakeSensorColor.red) {return "Cube"; }
        return "Cone";
    }else{
        return "No Object";
    }
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Prox", Sensors.IntakeSensorProx());
    SmartDashboard.putNumber("Red", Sensors.IntakeSensorColor().red);
    SmartDashboard.putNumber("Green", Sensors.IntakeSensorColor().green);
    SmartDashboard.putNumber("Blue", Sensors.IntakeSensorColor().blue);

    SmartDashboard.putBoolean("ObjectInIntake", ObjectInIntake());
    SmartDashboard.putString("Object Type", ObjectType());
  }
}
