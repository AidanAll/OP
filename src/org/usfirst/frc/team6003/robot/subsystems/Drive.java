package org.usfirst.frc.team6003.robot.subsystems;

import org.usfirst.frc.team6003.robot.RobotMap;
import org.usfirst.frc.team6003.robot.commands.JoystickDrive;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class Drive extends Subsystem {

	//Subsystem devices
	private WPI_TalonSRX frontLeft = new WPI_TalonSRX(RobotMap.fLeftMotor);
	private WPI_TalonSRX frontRight = new WPI_TalonSRX(RobotMap.rRightMotor);
	private DifferentialDrive m_drive;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public Drive()
	{
		m_drive = new DifferentialDrive(frontLeft, frontRight);
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

