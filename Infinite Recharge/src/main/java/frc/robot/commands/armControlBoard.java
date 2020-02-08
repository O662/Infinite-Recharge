/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class armControlBoard extends Command {
  /**
   * Creates a new armControlBoard.
   */
  public armControlBoard() {
    // Use addRequirements() here to declare subsystem dependencies.
    requires(Robot.armControl);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //TODO:Robot.armControl.setArmHeight(the control board height);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end() {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
