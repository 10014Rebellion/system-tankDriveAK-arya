// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Tankdrive;
import java.util.function.DoubleSupplier;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class DriveCommand extends Command {
  private Tankdrive mTankdrive;
  private DoubleSupplier mLeftJoyStickInput;
  private DoubleSupplier mRightJoyStickInput;

  public DriveCommand(
      Tankdrive pTankdrive, DoubleSupplier pLeftJoyStickInput, DoubleSupplier pRightJoyStickInput) {
    mTankdrive = pTankdrive;
    mLeftJoyStickInput = pLeftJoyStickInput;
    mRightJoyStickInput = pRightJoyStickInput;

    addRequirements(mTankdrive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    mTankdrive.setBothVolts(mLeftJoyStickInput.getAsDouble() * 12);

    if (mRightJoyStickInput.getAsDouble() > 0) {
      mTankdrive.setRightVolts(-1 * mRightJoyStickInput.getAsDouble() * 12);
      mTankdrive.setLeftVolts(mRightJoyStickInput.getAsDouble() * 12);
    } else if (mRightJoyStickInput.getAsDouble() < 0) {
      mTankdrive.setRightVolts(mRightJoyStickInput.getAsDouble() * 12);
      mTankdrive.setLeftVolts(-1 * mRightJoyStickInput.getAsDouble() * 12);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
