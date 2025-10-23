package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DriverStation;
import frc.robot.subsystems.TankdriveConstants.TankdriveConfiguration;
import frc.robot.subsystems.TankdriveConstants.TankdriveHardware;

public class TankdriveIOSim implements TankdriveIO {
  private final TankdriveSparkMaxIO sim;
  private final TankdriveHardware hardware;
  private final TankdriveConfiguration tankdriveConfiguration;

  private double driveAppliedVolts = 0.0;

  public TankdriveIOSim(TankdriveHardware phTankdrive, TankdriveConfiguration pConfig) {
    hardware = phTankdrive;
    tankdriveConfiguration = pConfig;

    sim = new TankdriveSparkMaxIO(hardware, tankdriveConfiguration);
  }

  @Override
  public void updateInputs(TankdriveIOInputs inputs) {
    if (DriverStation.isDisabled()) {
      setVoltage(0);
    }

    inputs.driveAppliedVolts = driveAppliedVolts;
    inputs.driveTemperatureCelsius = 0.0;
  }
}
