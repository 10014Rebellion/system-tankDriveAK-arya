package frc.robot.subsystems;

import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.math.system.plant.LinearSystemId;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.simulation.DCMotorSim;

public class TankdriveIOSim implements TankdriveIO {
  private final DCMotorSim sim;
  private final DCMotor gearbox;

  private double driveAppliedVolts = 0.0;

  public TankdriveIOSim(DCMotor pGearBox, double reduction, double moi) {
    gearbox = pGearBox;
    sim = new DCMotorSim(LinearSystemId.createDCMotorSystem(gearbox, moi, reduction), gearbox);
  }

  @Override
  public void updateInputs(TankdriveIOInputs inputs) {
    if (DriverStation.isDisabled()) {
      setVoltage(0);
    }
    inputs.driveAppliedVolts = driveAppliedVolts;
    inputs.driveStatorCurrentAmps = Math.abs(sim.getCurrentDrawAmps());
    inputs.driveTemperatureCelsius = 0.0;

    sim.update(0.02);
  }
}
