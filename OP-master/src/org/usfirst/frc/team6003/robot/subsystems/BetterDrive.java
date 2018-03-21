package org.usfirst.frc.team6003.robot.subsystems;

import org.usfirst.frc.team6003.robot.RobotMap;
import org.usfirst.frc.team6003.robot.commands.DriveCommands.DriveArcadeCmd;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BetterDrive extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private TalonSRX frontLeftDrive = new TalonSRX(RobotMap.miLeftMotor);
	private TalonSRX rearLeftDrive = new TalonSRX(RobotMap.rLeftMotor);
	private TalonSRX frontRightDrive = new TalonSRX(RobotMap.miRightMotor);
	private TalonSRX rearRightDrive = new TalonSRX(RobotMap.rRightMotor);

	public BetterDrive()
	{
		//Slave
		this.rearLeftDrive.follow(frontLeftDrive);
		this.rearRightDrive.follow(frontRightDrive);
		//Invert
		this.rearRightDrive.setInverted(false);
		this.frontRightDrive.setInverted(false);
		this.frontLeftDrive.setInverted(true);
		this.rearLeftDrive.setInverted(true);
		
		
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DriveArcadeCmd());
    }
    
    public void drive(double powLeft, double powRight)
    {
    	this.frontLeftDrive.set(ControlMode.PercentOutput, powLeft);
    	this.frontRightDrive.set(ControlMode.PercentOutput, powRight);
    }
    public void driveArcade(double throttle, double turn)
    {
    	this.frontLeftDrive.set(ControlMode.PercentOutput, throttle - turn);
    	this.frontRightDrive.set(ControlMode.PercentOutput, throttle + turn);
    }
    
    
    public void enableBreakMode()
    {
    	this.frontLeftDrive.setNeutralMode(NeutralMode.Brake);
    	this.rearRightDrive.setNeutralMode(NeutralMode.Brake);
    }
    public void disableBreakMode()
    {
    	this.frontLeftDrive.setNeutralMode(NeutralMode.Coast);
		this.rearRightDrive.setNeutralMode(NeutralMode.Coast);
    }
}

