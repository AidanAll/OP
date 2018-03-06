package org.usfirst.frc.team6003.robot.subsystems;

import org.usfirst.frc.team6003.robot.RobotMap;
import org.usfirst.frc.team6003.robot.commands.JoystickElevator;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {

	private TalonSRX elevator = new TalonSRX(RobotMap.elevator);
	public double holdingPosition;
	public Elevator()
	{
		elevator.setNeutralMode(NeutralMode.Brake);
		
		elevator.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
		elevator.setSensorPhase(false);
		
		elevator.config_kP(0, .2, 0);
		
		elevator.selectProfileSlot(0, 0);
		
	}
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new JoystickElevator());
    }
    
    public void elevatorDrive(Joystick j)
    {
    	double moveSpeed = j.getY();
    	if(moveSpeed == 0)
    	{
    		elevatorStop();
    	}
    	else
    	{
    		elevator.set(ControlMode.PercentOutput, moveSpeed);
    		setHoldingPosition();
    	}
    }
    //Make this hold position later
    public void elevatorStop()
    {
    	elevator.set(ControlMode.Position, holdingPosition);
    }
    
    public double getPosition()
    {
    	return elevator.getSelectedSensorPosition(0);
    }
    public void setHoldingPosition()
    {
    	holdingPosition = getPosition();
    	System.out.println(holdingPosition);
    }
}

