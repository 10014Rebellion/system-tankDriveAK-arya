package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.littletonrobotics.junction.Logger;

public class Tankdrive extends SubsystemBase {
  private TankdriveIO mTankdriveIOhardware;
  private final TankdriveIOInputsAutoLogged inputs = new TankdriveIOInputsAutoLogged();

  public Tankdrive(TankdriveIO pIo) {
    mTankdriveIOhardware = pIo;
  }

  public void setVolts(double pVolts) {
    mTankdriveIOhardware.setVoltage(pVolts);
  }

  public Command setVoltsCmd() {
    return new InstantCommand(() -> setVolts(5));
  }

  @Override
  public void periodic() {
    mTankdriveIOhardware.updateInputs(inputs);
    Logger.processInputs("Tankdrive", inputs);
  }
}
