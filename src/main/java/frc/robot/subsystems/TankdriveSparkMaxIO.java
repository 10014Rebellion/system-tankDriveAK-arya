package frc.robot.subsystems;

import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;
import edu.wpi.first.math.MathUtil;
import frc.robot.subsystems.TankdriveConstants.TankdriveConfiguration;
import frc.robot.subsystems.TankdriveConstants.TankdriveHardware;

public class TankdriveSparkMaxIO implements TankdriveIO {

  private final SparkMax kMotor;
  private SparkMaxConfig motorConfig = new SparkMaxConfig();

  private final TankdriveConfiguration tankdriveConfiguration;

  public TankdriveSparkMaxIO(
      TankdriveHardware hardware, TankdriveConfiguration pTankdriveConfiguration) {
    kMotor = new SparkMax(hardware.kMotorPort(), hardware.kMotorType());
    tankdriveConfiguration = pTankdriveConfiguration;

    motorConfig.inverted(tankdriveConfiguration.kInverted());
    motorConfig.idleMode(tankdriveConfiguration.kIdleMode());
    motorConfig.smartCurrentLimit(tankdriveConfiguration.kSmartLimit());

    kMotor.configure(motorConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
  }

  @Override
  public void updateInputs(TankdriveIOInputs inputs) {
    inputs.isMotorConnected = true;
    inputs.appliedVoltage = kMotor.getAppliedOutput() * kMotor.getBusVoltage();
    inputs.temperatureCelsius = kMotor.getMotorTemperature();
    inputs.motorOutput = kMotor.getAppliedOutput();
  }

  @Override
  public void setVoltage(double pVolts) {
    pVolts = MathUtil.clamp(pVolts, -12, 12);
    kMotor.setVoltage(pVolts);
  }

  @Override
  public void stop() {
    kMotor.stopMotor();
  }
}
