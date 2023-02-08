package frc.robot.subsystems;

public final class DrivetrainConstants {

    private static final String CONSTRUCTOR_EXCEPTION = "constant class";
  
    private DrivetrainConstants() {
      throw new IllegalStateException(CONSTRUCTOR_EXCEPTION);
    }

    public static final int PivotAngleCanCoderID = 43;

    public static final int PivotMotorLeftID = 40; //TODO check ID numbers
    public static final int PivotMotorRightID = 41; //TODO check ID numbers
    
}