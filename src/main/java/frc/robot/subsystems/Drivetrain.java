/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.DriveArcade;
//import com.ctre.phoenix.motorcontrol.can.Talon;
/**
 * Add your docs here.
 */
public class Drivetrain extends Subsystem {
Talon rTalon = null;
Talon rTalon2 = null;
Talon lTalon = null;
Talon lTalon2 = null;

DifferentialDrive differentialDrive = null;

public Drivetrain () {
  lTalon = new Talon(RobotMap.DRIVETRAIN_LEFT_FRONT_TALON);
  lTalon2 = new Talon(RobotMap.DRIVETRAIN_LEFT_BACK_TALON);
  rTalon = new Talon(RobotMap.DRIVETRAIN_RIGHT_FRONT_TALON);
  rTalon2 = new Talon(RobotMap.DRIVETRAIN_RIGHT_BACK_TALON);

  SpeedControllerGroup leftMotors = new SpeedControllerGroup(lTalon, lTalon2);
  SpeedControllerGroup rightMotors = new SpeedControllerGroup(rTalon, rTalon2);

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
