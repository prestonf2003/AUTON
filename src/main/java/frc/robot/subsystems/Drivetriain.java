/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.DriveArcade;

/**
 * Add your docs here.
 */
public class Drivetrain extends Subsystem {
CANTalon rCANTalon = null;
CANTalon rCANTalon2 = null;
CANTalon lCANTalon = null;
CANTalon lCANTalon2 = null;

DifferentialDrive differentialDrive = null;

public Drivetrain () {
  lCANTalon = new CANTalon(RobotMap.DRIVETRAIN_LEFT_FRONT_TALON);
  lCANTalon2 = new CANTalon(RobotMap.DRIVETRAIN_LEFT_BACK_TALON);
  rCANTalon = new CANTalon(RobotMap.DRIVETRAIN_RIGHT_FRONT_TALON);
  rCANTalon2 = new CANTalon(RobotMap.DRIVETRAIN_RIGHT_BACK_TALON);

  SpeedControllerGroup leftMotors = new SpeedControllerGroup(lCANTalon, lCANTalon2);
  SpeedControllerGroup rightMotors = new SpeedControllerGroup(rCANTalon, rCANTalon2);

  differentialDrive = new DifferentialDrive(leftMotors, rightMotors);

}
public void arcadeDrive(double moveSpeed, double rotateSpeed) {
  differentialDrive.arcadeDrive(moveSpeed, rotateSpeed);
}


  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new DriveArcade());
    
  }
}
