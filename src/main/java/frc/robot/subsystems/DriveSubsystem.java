// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMax.IdleMode;
import frc.robot.Constants.SparkMaxConstants;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;


public class DriveSubsystem extends SubsystemBase {
  /** Creates a new DriveSubsystem. */
  CANSparkMax frontLeft = new CANSparkMax(SparkMaxConstants.kLeftMotorFront, MotorType.kBrushless);
  CANSparkMax backLeft = new CANSparkMax(SparkMaxConstants.kLeftMotorBack, MotorType.kBrushless);

  CANSparkMax frontRight = new CANSparkMax(SparkMaxConstants.kRightMotorFront, MotorType.kBrushless);
  CANSparkMax backRight = new CANSparkMax(SparkMaxConstants.kRightMotorBack, MotorType.kBrushless);

  MotorControllerGroup leftDriveMotors = new MotorControllerGroup(frontLeft, backLeft);
  MotorControllerGroup rightDriveMotors = new MotorControllerGroup(frontRight, backRight);

  DifferentialDrive drive = new DifferentialDrive(leftDriveMotors, rightDriveMotors);

  public DriveSubsystem() {
    configMotors();
    setBrakeMode();
  }

  private void configMotors() {
    frontLeft.setInverted(true);
    backLeft.setInverted(true);
    frontRight.setInverted(false);
    backRight.setInverted(false);
     
    frontLeft.setOpenLoopRampRate(0.20);
    frontRight.setOpenLoopRampRate(0.20);
    backLeft.setOpenLoopRampRate(0.20);
    backRight.setOpenLoopRampRate(0.20);


    System.out.println("Motors Configured!"); 
  }


  public void DriveArcade(double xSpeed, double ySpeed) {
    drive.arcadeDrive(xSpeed, ySpeed*0.8);
  }

  public void DriveTank(double left, double right) {
    drive.tankDrive(left, right);
  }

  
  public void stopDrive() {
    leftDriveMotors.set(0);
    rightDriveMotors.set(0);
  }

  public void setCoastMode() {
    frontLeft.setIdleMode(IdleMode.kCoast);
    backLeft.setIdleMode(IdleMode.kCoast);
    frontRight.setIdleMode(IdleMode.kCoast);
    backRight.setIdleMode(IdleMode.kCoast);
  }

  public void setBrakeMode() {
    frontLeft.setIdleMode(IdleMode.kBrake);
    backLeft.setIdleMode(IdleMode.kBrake);
    frontRight.setIdleMode(IdleMode.kBrake);
    backRight.setIdleMode(IdleMode.kBrake);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }


 

  


  
 


}
