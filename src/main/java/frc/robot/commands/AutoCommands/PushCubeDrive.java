// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.AutoCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveTank;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class PushCubeDrive extends SequentialCommandGroup {
  /** Creates a new DriveForwardBack. */
  public PushCubeDrive() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new DriveTank(0.8, 0.8).withTimeout(1.5),
      new DriveTank(-0.5, -0.5).withTimeout(2),
      new DriveTank(0.8, 0.8).withTimeout(1.5),
      new DriveTank(-0.6, -0.6).withTimeout(4)
  );}
}
