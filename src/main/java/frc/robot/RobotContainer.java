// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.Tankdrive;
import frc.robot.subsystems.TankdriveIOSim;

public class RobotContainer {
  public Tankdrive mTankDrive;
  public CommandXboxController mController = new CommandXboxController(0);

  public RobotContainer() {

    // switch (Constants.currentMode) {
    //   case REAL:
    //     break;
    //   case SIM:
    //     mTankDrive = new Tankdrive(new TankdriveIOSim(DCMotor.getNeoVortex(1), 1, 3));
    //     break;
    //   default:
    //     break;
    // }

    configureBindings();
  }

  private void configureBindings() {
    mController.a().whileTrue(mTankDrive.setVoltsCmd());
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
