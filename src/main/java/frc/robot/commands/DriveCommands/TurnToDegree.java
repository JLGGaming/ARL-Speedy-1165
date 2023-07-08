// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.DriveCommands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;


public class TurnToDegree extends CommandBase {
  /** Creates a new Turn90. */
  public PIDController turnController;

  public TurnToDegree(double setpoint) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.m_driveSubsystem);
    turnController = new PIDController(0, 0, 0);
    turnController.enableContinuousInput(-180.0f,  180.0f);
    turnController.setTolerance(0, 0.1);
    turnController.setSetpoint(setpoint);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    turnController.reset();
    turnController.calculate(RobotContainer.m_driveSubsystem.getGyroAngle());

    if (turnController.getPositionError() > 100 || turnController.getPositionError() < -100){
      turnController.setP(0.0055);
      turnController.setI(0.0013);
      turnController.setD(0);
      System.out.println("Turning Scaled"); 
    }
    else {
      turnController.setP(0.012);
      turnController.setI(0);
      turnController.setD(0);    
      System.out.println("Turning!");
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double left_command = turnController.calculate(RobotContainer.m_driveSubsystem.getGyroAngle());
    double right_command = turnController.calculate(RobotContainer.m_driveSubsystem.getGyroAngle());
    RobotContainer.m_driveSubsystem.DriveTank(left_command, right_command*-1);
    // System.out.println(RobotContainer.m_driveSubsystem.getGyroAngle());
    // System.out.println(turnController.getSetpoint());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.m_driveSubsystem.DriveTank(0, 0);
    System.out.println("Stopped Turning");
  }

  // Returns true when the command should end.
  @Override 
  public boolean isFinished() {
   return false;
  }

}
