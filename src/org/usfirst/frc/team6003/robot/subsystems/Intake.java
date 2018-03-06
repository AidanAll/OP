package org.usfirst.frc.team6003.robot.subsystems;

import org.usfirst.frc.team6003.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {

	private Spark leftIntake = new Spark(RobotMap.lIntake);
	private Spark rightIntake = new Spark(RobotMap.rIntake);
	private DoubleSolenoid armSolenoid = new DoubleSolenoid(0,1);
	public boolean openState = false;
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void openArm()
    {
    	armSolenoid.set(DoubleSolenoid.Value.kForward);
    	openState = false;
    }
    
    public void closeArm()
    {
    	armSolenoid.set(DoubleSolenoid.Value.kReverse);
    	openState = true;
    }
    public void grabIntake()
    {
    	leftIntake.set(1);
    	rightIntake.set(-1);
    }
    
    public void releaseIntake()
    {
    	leftIntake.set(-1);
    	rightIntake.set(1);
    }
    public void stopIntake()
    {
    	leftIntake.set(0);
    	rightIntake.set(0);
    }
    

}

