package frc.robot.subsystems;

import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.TankdriveConstants.LeftConstants;
import frc.robot.subsystems.TankdriveConstants.RightConstants;

public class Tankdrive extends SubsystemBase {
  private TankdriveIO mTankdriveIO;
  private final TankdriveIOInputsAutoLogged inputs = new TankdriveIOInputsAutoLogged();

  private SparkMax kLeftFront;
  private SparkMax kLeftBack;

  private SparkMax kRightFront;
  private SparkMax kRightBack;

  public Tankdrive(TankdriveIO pIo) {

    mTankdriveIO = pIo;

    kLeftFront = new SparkMax(LeftConstants.kLeftFrontMotorID, LeftConstants.kMotorType);
    kLeftBack = new SparkMax(LeftConstants.kLeftBackMotorID, LeftConstants.kMotorType);

    kRightFront = new SparkMax(RightConstants.kRightFrontMotorID, RightConstants.kMotorType);
    kRightBack = new SparkMax(RightConstants.kRightBackMotorID, RightConstants.kMotorType);

    kLeftFront.configure(
        LeftConstants.kConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    kLeftBack.configure(
        LeftConstants.kConfig.follow(LeftConstants.kLeftFrontMotorID),
        ResetMode.kResetSafeParameters,
        PersistMode.kPersistParameters);

    kRightFront.configure(
        RightConstants.kConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    kRightBack.configure(
        RightConstants.kConfig.follow(RightConstants.kRightFrontMotorID),
        ResetMode.kResetSafeParameters,
        PersistMode.kPersistParameters);
  }

  public void setLeftVolts(double pVolts) {
    kLeftFront.setVoltage(pVolts);
  }

  public void setRightVolts(double pVolts) {
    kRightFront.setVoltage(pVolts);
  }

  public void setBothVolts(double pVolts) {
    kRightFront.setVoltage(pVolts);
    kLeftFront.setVoltage(pVolts);
  }

  public void periodic() {
    mTankdriveIO.updateInputs(null);
  }
}
