/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  private Joystick driverJoystickLeft = new Joystick(Constants.DRIVER_JOYSTICK_LEFT);
  private Joystick driverJoystickRight= new Joystick(Constants.DRIVER_JOYSTICK_RIGHT);

  private XboxController operatorController = new XboxController(Constants.OPERATOR_CONTROLLER);

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  /*
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
  }
  */


  
  public double GetDriverJoystickLeftRawAxis(int axis) {
    return driverJoystickLeft.getRawAxis(axis);
  }
 
  public double GetDriverJoystickRightRawAxis(int axis) {
    return driverJoystickRight.getRawAxis(axis);
  }
 
  public Joystick getDriverLeft() {
    return driverJoystickLeft;
  }
 
  public Joystick getDriverRight() {
    return driverJoystickRight;
  }

  public double GetOperatorRawAxis(int axis) {
    return operatorController.getRawAxis(axis);
  }

  public XboxController getOperator(){
    return operatorController;
  }

}
