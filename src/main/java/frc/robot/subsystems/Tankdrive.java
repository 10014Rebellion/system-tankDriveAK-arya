package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.littletonrobotics.junction.Logger;

public class Tankdrive extends SubsystemBase {
  private TankdriveIO mTankdriveIOhardware;
  private final TankdriveIOInputsAutoLogged inputs = new TankdriveIOInputsAutoLogged();

  // private SparkMax kLeftFront;
  // private SparkMax kLeftBack;

  // private SparkMax kRightFront;
  // private SparkMax kRightBack;

  public Tankdrive(TankdriveIO pIo) {

    mTankdriveIOhardware = pIo;

    // kLeftFront = new SparkMax(LeftConstants.kLeftFrontMotorID, LeftConstants.kMotorType);
    // kLeftBack = new SparkMax(LeftConstants.kLeftBackMotorID, LeftConstants.kMotorType);

    // kRightFront = new SparkMax(RightConstants.kRightFrontMotorID, RightConstants.kMotorType);
    // kRightBack = new SparkMax(RightConstants.kRightBackMotorID, RightConstants.kMotorType);

    // kLeftFront.configure(
    //     LeftConstants.kConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    // kLeftBack.configure(
    //     LeftConstants.kConfig.follow(LeftConstants.kLeftFrontMotorID),
    //     ResetMode.kResetSafeParameters,
    //     PersistMode.kPersistParameters);

    // kRightFront.configure(
    //     RightConstants.kConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    // kRightBack.configure(
    //     RightConstants.kConfig.follow(RightConstants.kRightFrontMotorID),
    //     ResetMode.kResetSafeParameters,
    //     PersistMode.kPersistParameters);
  }

  // public void setLeftVolts(double pVolts) {
  //   kLeftFront.setVoltage(pVolts);
  // }

  // public void setRightVolts(double pVolts) {
  //   kRightFront.setVoltage(pVolts);
  // }

  // public void setBothVolts(double pVolts) {
  //   kRightFront.setVoltage(pVolts);
  //   kLeftFront.setVoltage(pVolts);
  // }

  @Override
  public void periodic() {
    mTankdriveIOhardware.updateInputs(inputs);
    Logger.processInputs("Tankdrive", inputs);
  }
}
