package frc.robot.subsystems;

import com.ctre.phoenix6.signals.NeutralModeValue;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;

public class TankdriveConstants {

  public record TankdriveHardware(int kMotorPort, MotorType kMotorType) {}

  public record TankdriveConfiguration(int kSmartLimit, IdleMode kIdleMode, boolean kInverted) {}

  public static class LeftConstants {
    public static int kLeftFrontMotorID = 10;
    public static int kLeftBackMotorID = 11;

    public static SparkMaxConfig kConfig = new SparkMaxConfig();
    public static MotorType kMotorType = MotorType.kBrushed;
    public static IdleMode kIdleMode = IdleMode.kCoast;
    public static int kSmartCurrentLimit = 60;
    public static boolean kInvertedLeft = true;

    public static TankdriveHardware tankDriveHardwareLeftFront =
        new TankdriveHardware(kLeftFrontMotorID, kMotorType);
    public static TankdriveHardware tankDriveHardwareLeftBack =
        new TankdriveHardware(kLeftBackMotorID, kMotorType);
  }

  public static class RightConstants {
    public static int kRightFrontMotorID = 12;
    public static int kRightBackMotorID = 13;

    public static SparkMaxConfig kConfig = new SparkMaxConfig();
    public static MotorType kMotorType = MotorType.kBrushed;
    public static IdleMode kIdleMode = IdleMode.kCoast;
    public static int kSmartCurrentLimit = 60;
    public static boolean kInvertedRight = true;

    public static TankdriveHardware tankDriveHardwareRightFront =
        new TankdriveHardware(kRightFrontMotorID, kMotorType);
    public static TankdriveHardware tankdriveHardwareRightBack =
        new TankdriveHardware(kRightBackMotorID, kMotorType);

    public static TankdriveConfiguration motorConfigurationRight =
        new TankdriveConfiguration(kSmartCurrentLimit, kIdleMode, kInvertedRight);
  }

  public static class TalonFXConstants {
    public static int kMotorID = 67;
    public static NeutralModeValue kIdleMode = NeutralModeValue.Brake;
    public static boolean kInverted = true;
    public static int kSmartCurrentLimit = 60;

    public static TankdriveHardwareTalonFX tankdriveHardware =
        new TankdriveHardwareTalonFX(kMotorID, "drivetrain");
    public static TankdriveConfiguration tankdriveConfiguration =
        new TankdriveConfiguration(kSmartCurrentLimit, kIdleMode, kInverted);

    public record TankdriveHardwareTalonFX(int kMotorPort, String canbus) {}

    public record TankdriveConfiguration(
        int kSmartLimit, NeutralModeValue kIdleMode, boolean kInverted) {}
  }
}
