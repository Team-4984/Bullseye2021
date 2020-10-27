/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.Constants;


import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  /**
   * Creates a new DriveTrain.
   */


  private static CANSparkMax leftFrontDriveMotor = new CANSparkMax(Constants.MOTOR_LEFT_FRONT, MotorType.kBrushless);
  private static CANSparkMax leftBackDriveMotor = new CANSparkMax(Constants.MOTOR_LEFT_BACK, MotorType.kBrushless);
  private static CANSparkMax rightFrontDriveMotor = new CANSparkMax(Constants.MOTOR_RIGHT_FRONT, MotorType.kBrushless);
  private static CANSparkMax rightBackDriveMotor = new CANSparkMax(Constants.MOTOR_RIGHT_BACK, MotorType.kBrushless);

  public CANEncoder leftFrontDriveEncoder = leftFrontDriveMotor.getEncoder();
  private CANEncoder rightFrontDriveEncoder = rightFrontDriveMotor.getEncoder();

  public DriveTrain() {
    leftBackDriveMotor.follow(leftFrontDriveMotor);
    rightBackDriveMotor.follow(rightFrontDriveMotor);

    leftFrontDriveMotor.setOpenLoopRampRate(Constants.OPEN_LEFT_LOOP_RATE);
    rightFrontDriveMotor.setOpenLoopRampRate(Constants.OPEN_RIGHT_LOOP_RATE);
 
  }

  public static void setCoastMode() {
    leftFrontDriveMotor.setIdleMode(IdleMode.kCoast);
    //leftBackDriveMotor.setIdleMode(IdleMode.kCoast);
    rightFrontDriveMotor.setIdleMode(IdleMode.kCoast);
    //rightBackDriveMotor.setIdleMode(IdleMode.kCoast);
  }

  public static void tankDriveLeft(Joystick joystick) {
    leftFrontDriveMotor.set(joystick.getRawAxis(Constants.DRIVER_JOYSTICK_AXIS));
    //leftBackDriveMotor.set(joystick.getRawAxis(Constants.DRIVER_JOYSTICK_AXIS));
  }

  public static void tankDriveRight(Joystick joystick) {
    rightFrontDriveMotor.set(-joystick.getRawAxis(Constants.DRIVER_JOYSTICK_AXIS));
    //rightBackDriveMotor.set(-joystick.getRawAxis(Constants.DRIVER_JOYSTICK_AXIS));
  }

  public static void reverseTankDriveLeft(Joystick joystick) {
    leftFrontDriveMotor.set(-joystick.getRawAxis(Constants.DRIVER_JOYSTICK_AXIS));
  //  leftBackDriveMotor.set(-joystick.getRawAxis(Constants.DRIVER_JOYSTICK_AXIS));
  }

  public static void reverseTankDriveRight(Joystick joystick) {
    rightFrontDriveMotor.set(joystick.getRawAxis(Constants.DRIVER_JOYSTICK_AXIS));
   // rightBackDriveMotor.set(joystick.getRawAxis(Constants.DRIVER_JOYSTICK_AXIS));
  }

  public static void Drive(double left, double right) {
    leftFrontDriveMotor.set(left);
  //  leftBackDriveMotor.set(left);
    rightFrontDriveMotor.set(right);
   // rightBackDriveMotor.set(right);

  }

  public void ResetEncoders() {
    leftFrontDriveEncoder.setPosition(0.0);  
    rightFrontDriveEncoder.setPosition(0.0);  
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
