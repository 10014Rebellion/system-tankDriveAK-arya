// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.DriveCommand;
import frc.robot.subsystems.Tankdrive;
import frc.robot.subsystems.TankdriveIOSim;

public class RobotContainer {
  public Tankdrive mTankDrive;
  public DriveCommand mDriveCommand;
  public CommandXboxController mController = new CommandXboxController(0);

  public RobotContainer() {
    mTankDrive = new Tankdrive(new TankdriveIOSim(DCMotor.getKrakenX60(1), 1, 3));

    mDriveCommand =
        new DriveCommand(
            mTankDrive,
            () -> MathUtil.applyDeadband(mController.getLeftY(), 0.6),
            () -> MathUtil.applyDeadband(mController.getRightX(), 0.6));

    configureBindings();
  }

  private void configureBindings() {
    mController.a().whileTrue(new InstantCommand(() -> mTankDrive.setBothVolts(5)));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
