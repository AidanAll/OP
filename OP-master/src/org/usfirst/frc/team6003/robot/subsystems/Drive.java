package org.usfirst.frc.team6003.robot.subsystems;

import org.usfirst.frc.team6003.robot.RobotMap;
import org.usfirst.frc.team6003.robot.commands.JoystickDrive;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class Drive extends Subsystem {

	//Subsystem devices
	private WPI_TalonSRX middleLeft = new WPI_TalonSRX(RobotMap.miLeftMotor);
	private WPI_TalonSRX middleRight = new WPI_TalonSRX(RobotMap.miRightMotor);
	private WPI_TalonSRX rearLeft = new WPI_TalonSRX(RobotMap.rLeftMotor);
	private WPI_TalonSRX rearRight = new WPI_TalonSRX(RobotMap.rRightMotor);
	
	//Group
	SpeedControllerGroup left = new SpeedControllerGroup(middleLeft, rearLeft);
	SpeedControllerGroup right = new SpeedControllerGroup(middleRight, rearRight);
	
	private DifferentialDrive m_drive;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public Drive()
	{
		m_drive = new DifferentialDrive(left, right);
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new JoystickDrive());
    }
    
    public void arcadeDrive(Joystick j)
    {
    	m_drive.arcadeDrive(j.getY(), j.getX());
    }
    public void stop()
    {
    	m_drive.tankDrive(0, 0);
    }
}

