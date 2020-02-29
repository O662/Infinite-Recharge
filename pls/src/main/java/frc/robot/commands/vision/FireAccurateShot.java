/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.vision;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Robot;
import frc.robot.RobotPreferences;

public class FireAccurateShot extends CommandBase {

  boolean isFinished = false;
  double distFromBase,tx;
  WaitCommand w = new WaitCommand(1);
  
  public FireAccurateShot() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    addRequirements(Robot.limelight);
    addRequirements(Robot.driveTrain);
    addRequirements(Robot.shooter);
    
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    SmartDashboard.putBoolean("Ready to Fire", isFinished);
    distFromBase = Robot.limelight.getDistance();//might have to fix getDistance()
    tx = Robot.limelight.getTx();
    if(distFromBase < RobotPreferences.kDistFromBaseMax && distFromBase > RobotPreferences.kDistFromBaseMin)
    {
      while(tx < -.5)
      {
        Robot.driveTrain.driveMotors(.2, -.2);
      }
      while(tx > .5)
      {
        Robot.driveTrain.driveMotors(-.2, .2);
      }
      if(tx > -.5 && tx < .5)
      {
        Robot.driveTrain.driveMotors(0, 0);
        Robot.shooter.revMotor(distFromBase * 3568);//rev motor of dist * by some constant to properly place the ball TODO
        w.initialize();
        isFinished = true;
      }
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return isFinished;
  }

  // Called once after isFinished returns true
  @Override
  public void end(boolean interrupted) {
  }
}
