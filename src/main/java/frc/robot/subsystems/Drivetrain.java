/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.DriveArcade;

/**
 * Add your docs here.
 */
public class Drivetrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private Talon leftTalon;
  private Talon rightTalon;
  private DifferentialDrive diffDrive;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new DriveArcade());
  }

  public Drivetrain() {
    leftTalon = new Talon(RobotMap.LEFT_TALON_PORT);
    rightTalon = new Talon(RobotMap.RIGHT_TALON_PORT);

    diffDrive = new DifferentialDrive(leftTalon, rightTalon);
  }

  public void drive(double moveSpeed, double rotateSpeed) {
    diffDrive.arcadeDrive(moveSpeed, rotateSpeed);
    //diffDrive.tankDrive(leftSpeed, rightSpeed);
    //diffDrive.curvatureDrive(moveSpeed, rotateSpeed, quickTurn);
  }
}
