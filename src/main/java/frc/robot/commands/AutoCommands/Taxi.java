// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.AutoCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.RobotContainer;
import frc.robot.commands.DriveCommands.DriveTank;
import frc.robot.commands.DriveCommands.TurnToDegree;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class Taxi extends SequentialCommandGroup {
  /** Creates a new Taxi. */
  public Taxi() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      RobotContainer.m_driveSubsystem.resetGyro(),
      new DriveTank(-0.25, -0.25).withTimeout(3),
      new WaitCommand(0.25),
      new TurnToDegree(180).withTimeout(5),
      RobotContainer.m_driveSubsystem.resetGyro()

    );
  }
}
