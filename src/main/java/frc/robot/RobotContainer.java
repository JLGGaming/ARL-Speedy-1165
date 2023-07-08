// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;

import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.commands.AutoCommands.Taxi;
import frc.robot.commands.AutoCommands.ShootMidTaxi;
import frc.robot.commands.AutoCommands.ShootHighTaxi;
import frc.robot.commands.DriveCommands.DriveArcade;
import frc.robot.commands.DriveCommands.TurnToDegree;
import frc.robot.commands.FlywheelCommands.LoadIn;
import frc.robot.commands.FlywheelCommands.ShootHigh;
import frc.robot.commands.FlywheelCommands.ShootLow;
import frc.robot.commands.FlywheelCommands.ShootMid;
import frc.robot.Constants.OperatorConstants;

import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.FlywheelSubsystem;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  // private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  public final static DriveSubsystem m_driveSubsystem = new DriveSubsystem();
  public final static FlywheelSubsystem m_flwheelSubsystem = new FlywheelSubsystem();

  public static final CommandXboxController m_xboxDriverController =
      new CommandXboxController(OperatorConstants.kXboxControllerPort);

  public static final CommandXboxController m_xboxCoDriverController =
      new CommandXboxController(OperatorConstants.kCoXboxControllerPort);


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
    m_driveSubsystem.setDefaultCommand(new DriveArcade());
    m_flwheelSubsystem.setDefaultCommand(new LoadIn());
  }

  private void configureBindings() {
    //Driver
    m_xboxDriverController.povUp().onTrue(new TurnToDegree(0).withTimeout(1));
    m_xboxDriverController.povDown().onTrue(new TurnToDegree(180).withTimeout(1));
    m_xboxDriverController.povLeft().onTrue(new TurnToDegree(-90).withTimeout(1));
    m_xboxDriverController.povRight().onTrue(new TurnToDegree(90).withTimeout(1));
    m_xboxDriverController.x().onTrue(m_driveSubsystem.resetGyro());
    //Co Driver
    m_xboxCoDriverController.povUp().onTrue(new ShootHigh());
    m_xboxCoDriverController.povLeft().onTrue(new ShootMid());
    m_xboxCoDriverController.povRight().onTrue(new ShootMid());
    m_xboxCoDriverController.povDown().onTrue(new ShootLow());
  } 

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand(String auto) {
    // An example command will be run in autonomous
    if (auto.equals("Taxi")){
      return new Taxi();
    }
    else if (auto.equals("ShootHighTaxi")){
      return new ShootHighTaxi();
    }
    else if (auto.equals("ShootMidTaxi")){
      return new ShootMidTaxi();
    }
    else if (auto.equals("ShootMid")) {
      return new ShootMid();
    }
    else if (auto.equals("ShootHigh")) {
      return new ShootHigh();
    }
    else if (auto.equals("None")) {
      System.out.println("No Auto Running");
      return null;
    }
    System.out.println("Failed to select auto!");
    return null;
  }
}
