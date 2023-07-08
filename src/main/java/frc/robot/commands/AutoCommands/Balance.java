// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.AutoCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveCommands.DriveTank;
import frc.robot.commands.DriveCommands.DriveToTilt;
import frc.robot.commands.FlywheelCommands.ShootHigh;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class Balance extends SequentialCommandGroup {
  /** Creates a new Balance. */
  public Balance() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new ShootHigh(),
      new DriveTank(-0.2, -0.2).withTimeout(3),
      new DriveToTilt()
    );
  }
}
