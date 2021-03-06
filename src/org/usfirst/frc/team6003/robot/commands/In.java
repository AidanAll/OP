package org.usfirst.frc.team6003.robot.commands;

import org.usfirst.frc.team6003.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class In extends Command {

    public In() {
    	requires(Robot.armtake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.armtake.grabIntake();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.armtake.stopIntake();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
