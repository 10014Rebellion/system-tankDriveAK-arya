package frc.robot.subsystems;

import org.littletonrobotics.junction.AutoLog;

public interface TankdriveIO {

  @AutoLog
  public static class TankdriveIOInputs {
    public boolean isMotorConnected = false;

    public double appliedVoltage = 0.0;
    public double temperatureCelsius = 0.0;
    public double positionMeters = 0.0;
    public double motorOutput = 0.0;
    public double supplyCurrentAmps = 0.0;
    public double statorCurrentAmps = 0.0;

    public boolean isDriveConnected = true;
    public double drivePositionM = 0.0;
    public double driveVelocityMPS = 0.0;
    public double driveStatorCurrentAmps = 0.0;
    public double driveSupplyCurrentAmps = 0.0;
    public double driveTorqueCurrentAmps = 0.0;
    public double driveTemperatureCelsius = 0.0;
    public double driveAppliedVolts = 0.0;
    public double driveMotorVolts = 0.0;
    public double driveAccelerationMPSS = 0.0;
  }

  /**
   * Write data from the hardware to the inputs object
   *
   * @param inputs The inputs object
   */
  public default void updateInputs(TankdriveIOInputs inputs) {}
  ;

  /**
   * @param volts The voltage that should be applied to the motor from -12 to 12
   */
  public default void setVoltage(double volts) {}

  /**
   * Commands the hardware to stop. When using TalonFX, this commands the motors to a Neutral
   * control
   */
  public default void stop() {}
}
