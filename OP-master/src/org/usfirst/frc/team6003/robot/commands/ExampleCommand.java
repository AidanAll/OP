/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team6003.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team6003.robot.Robot;

/**
 * An example command.  You can replace me with your own command.
 */
public class ExampleCommand extends Command {
	protected double power;
	protected double time;
	protected double endTime;
		
		public ExampleCommand(double power,double timeInMills) {
			
			this.power=power;	
			this.time = timeInMills;
			requires(Robot.drivetrain);
			
		}
		
		// Use requires() here to declare subsystem dependencies
		
	

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		long startTime = System.currentTimeMillis();
		endTime = startTime +this.time;
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.drivetrain.drive(power, -power);
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return System.currentTimeMillis()>= endTime;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.drivetrain.drive(0,0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
