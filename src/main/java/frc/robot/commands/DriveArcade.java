/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class DriveArcade extends Command {
  public DriveArcade() {
    requires(Robot.m_drivetrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  double LTrigger = Robot.m_oi.driverController.getRawAxis(RobotMap.DRIVER_CONTROLLER_TRIGGER_L_AXIS)
  double RTrigger = Robot.m_oi.driverController.getRawAxis(RobotMap.DRIVER_CONTROLLER_TRIGGER_R_AXIS)
  boolean slow = Robot.m_oi.driverController.getRawButton(3);
  double throttle = (RTrigger - LTrigger);
  if (slow == true)
  throttle = throttle * 0.5;

  double rotateSpeed = Robot.m_oi.driverController.getRawAxis(RobotMap.OI_DRIVER_CONTROLLER_ROTATE_AXIS);
  if (slow == true)
  rotateSpeed = rotateSpeed * 0.5;

  Robot.m_drivetrain.arcadeDrive(throttle, rotateSpeed);

  }



  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  Robot.m_drivetrain.arcadeDrive(0, 0);
  }


  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    
  }
}
