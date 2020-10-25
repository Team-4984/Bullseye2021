/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveDistanceCommand extends CommandBase {
  private int d_Distance;
  private double m_left;
  private double m_right;

  public DriveDistanceCommand(int super11, double leftmotor, double rightmotor) {
    d_Distance = super11;
    m_left = leftmotor;
    m_right = rightmotor;
    addRequirements(Robot.driveTrain);

  }



  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Robot.driveTrain.ResetEncoders();

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.driveTrain.Drive(m_left, m_right); 
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.driveTrain.Drive(0.0, 0.0);   
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {

      return false;
     
    
  }
}
