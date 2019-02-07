/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class HatchReverse extends Command {
  private long startTime;
  public HatchReverse() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.hatchPiston);
    //needs hatchPiston in Robot
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.hatchPiston.setReverse();
    startTime = System.currentTimeMillis();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return startTime + 500 <= System.currentTimeMillis();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.hatchPiston.setOff();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
