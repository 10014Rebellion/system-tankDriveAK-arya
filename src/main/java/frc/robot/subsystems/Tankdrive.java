package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.littletonrobotics.junction.Logger;

public class Tankdrive extends SubsystemBase {
  private TankdriveIO mTankdriveIOhardware;
  private final TankdriveIOInputsAutoLogged inputs = new TankdriveIOInputsAutoLogged();

  public Tankdrive(TankdriveIO pIo) {
    mTankdriveIOhardware = pIo;
  }

  @Override
  public void periodic() {
    mTankdriveIOhardware.updateInputs(inputs);
    Logger.processInputs("Tankdrive", inputs);
    
  }
}
