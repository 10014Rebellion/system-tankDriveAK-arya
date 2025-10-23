package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import edu.wpi.first.math.MathUtil;
import frc.robot.subsystems.TankdriveConstants.TalonFXConstants.TankdriveConfiguration;
import frc.robot.subsystems.TankdriveConstants.TalonFXConstants.TankdriveHardwareTalonFX;

public class TankdriveTalonFXIO implements TankdriveIO {
  private final TalonFX kMotor;
  private TalonFXConfiguration motorConfig = new TalonFXConfiguration();
  private TankdriveConfiguration tankdriveConfiguration;

  public TankdriveTalonFXIO(
      TankdriveHardwareTalonFX pTankdriveHardware, TankdriveConfiguration pTankdriveConfiguration) {
    kMotor = new TalonFX(pTankdriveHardware.kMotorPort(), pTankdriveHardware.canbus());

    tankdriveConfiguration = pTankdriveConfiguration;
    motorConfig.CurrentLimits.SupplyCurrentLimitEnable = true;
    motorConfig.CurrentLimits.SupplyCurrentLimit = tankdriveConfiguration.kSmartLimit();
    motorConfig.CurrentLimits.StatorCurrentLimitEnable = true;
    motorConfig.CurrentLimits.StatorCurrentLimit = tankdriveConfiguration.kSmartLimit();
    motorConfig.Voltage.PeakForwardVoltage = 12;
    motorConfig.Voltage.PeakReverseVoltage = -12;

    motorConfig.MotorOutput.NeutralMode = tankdriveConfiguration.kIdleMode();
    motorConfig.MotorOutput.Inverted =
        tankdriveConfiguration.kInverted()
            ? InvertedValue.CounterClockwise_Positive
            : InvertedValue.Clockwise_Positive;

    kMotor.getConfigurator().apply(motorConfig, 1.0);
  }

  @Override
  public void updateInputs(TankdriveIOInputs inputs) {
    inputs.isMotorConnected = true;
    inputs.appliedVoltage = kMotor.getMotorVoltage().getValueAsDouble();
    inputs.supplyCurrentAmps = 0.0;
    inputs.statorCurrentAmps = 0.0;
    inputs.temperatureCelsius = kMotor.getDeviceTemp().getValueAsDouble();
    inputs.motorOutput = 0.0;
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
