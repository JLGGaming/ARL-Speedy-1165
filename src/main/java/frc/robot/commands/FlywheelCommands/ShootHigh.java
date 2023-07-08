// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.FlywheelCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Constants.FlywheelConstants;
import frc.robot.RobotContainer;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class ShootHigh extends SequentialCommandGroup {
  /** Creates a new ShootHigh. */
  public ShootHigh() {
    addCommands(   
      RobotContainer.m_flwheelSubsystem.extendTilt(),
      RobotContainer.m_flwheelSubsystem.retractPlunger(),
      RobotContainer.m_flwheelSubsystem.setFlywheelSpeed(FlywheelConstants.kSpeedHigh),
      new WaitCommand(1),
      RobotContainer.m_flwheelSubsystem.extendPlunger(),
      new WaitCommand(0.5),
      RobotContainer.m_flwheelSubsystem.retractTilt(),
      RobotContainer.m_flwheelSubsystem.retractPlunger(),
      RobotContainer.m_flwheelSubsystem.setFlywheelSpeed(0)
    );
  }
}
