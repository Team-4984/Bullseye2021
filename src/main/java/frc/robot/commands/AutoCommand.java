/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class AutoCommand extends SequentialCommandGroup {
  /**
   * Creates a new AutoCommand.
   */
  public AutoCommand() {
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());
    super(new DriveDistanceCommand(Constants.SUPER_1_1, Constants.MOTOR_LEFT_FRONT, Constants.MOTOR_RIGHT_FRONT), // Step 1 GO Forward 1 Inch
         (new DriveDistanceCommand(Constants.SUPER_1_2, Constants.MOTOR_LEFT_FRONT, Constants.MOTOR_RIGHT_FRONT))); //Step 2 BACK 1 Inch

  }
}