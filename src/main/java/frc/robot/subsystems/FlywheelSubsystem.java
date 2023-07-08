// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.FlywheelConstants;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class FlywheelSubsystem extends SubsystemBase {
  /** Creates a new FlywheelSubsystem. */

  WPI_TalonSRX leftFlywheelMotor = new  WPI_TalonSRX (FlywheelConstants.kLeftFlywheelMotor);
  WPI_TalonSRX  rightFlywheelMotor = new  WPI_TalonSRX (FlywheelConstants.kRightFlywheelMotor);
 
  Compressor phCompressor = new Compressor(1, PneumaticsModuleType.CTREPCM);
  Solenoid plungerSolenoid = new Solenoid(PneumaticsModuleType.CTREPCM, 0);
  Solenoid tiltSolenoid = new Solenoid(PneumaticsModuleType.CTREPCM, 1);

  public FlywheelSubsystem() {
    configMotors();
    retractPlunger();
    retractTilt();
  }
    
  public void configMotors(){
    leftFlywheelMotor.setNeutralMode(NeutralMode.Coast);
    rightFlywheelMotor.setNeutralMode(NeutralMode.Coast);

    leftFlywheelMotor.setInverted(true);
  }

  public CommandBase setFlywheelSpeed(double speed){
    return runOnce(() -> {
      leftFlywheelMotor.set(speed);
      rightFlywheelMotor.set(speed);
    });
  }

  public void loadIn(double speed){
    leftFlywheelMotor.set(speed);
    rightFlywheelMotor.set(speed);
  }

  public CommandBase extendPlunger() {
    return runOnce(() -> { 
      plungerSolenoid.set(true);
    });
  }

  public CommandBase retractPlunger() {
    return runOnce(() -> { 
      plungerSolenoid.set(false);
    });
  }

  public CommandBase extendTilt() {
    return runOnce(() -> {
      tiltSolenoid.set(true);
    });
  }

  public CommandBase retractTilt() {
    return runOnce(() -> {
      tiltSolenoid.set(false);
    });
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
