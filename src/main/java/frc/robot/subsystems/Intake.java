// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.MotionMagicVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.controls.VelocityDutyCycle;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class  Intake extends SubsystemBase {
  


TalonFX m_motor;
VelocityDutyCycle intakeVelocity; 

DutyCycleOut intakePercentOutput;


public Intake() {
    m_motor = new TalonFX(Constants.IntakeConstants.MOTORID , Constants.CANIVORE);
    final TalonFXConfiguration configuration = new TalonFXConfiguration();
    configuration.CurrentLimits.withStatorCurrentLimitEnable(true);
    configuration.CurrentLimits.withStatorCurrentLimit(40);
   

    m_motor.getConfigurator().apply(configuration, 0.050);

    intakeVelocity = new VelocityDutyCycle(0);

    // periodic, run Motion Magic with slot 0 configs,
  }
  
  @Override
  public void periodic() {
    
    SmartDashboard.putNumber("intake height", 0);
  }

  
 

  

  

  public void intakerun(double velocity){
    intakeVelocity.Velocity = velocity * 5;
        m_motor.setControl(intakeVelocity);

    // m_motor.set(velocity);

    
  }

  public void intakerunvoltage(double velocity){
        m_motor.setVoltage(velocity);

    // m_motor.set(velocity);

    
  }

  public void OUTTAKE(double velocity){
    // intakeVelocity.Velocity = velocity;
    //     m_motor.setControl(intakeVelocity);

    m_motor.set(velocity);

    if(SmartDashboard.getNumber("intake speed", 1) > 0.1 ){
      m_motor.set(velocity);
    } else {
      m_motor.set(Constants.IntakeConstants.L1);
    }
  }

  public void intakePercentOutput(double percentOutput) {

    intakePercentOutput.Output = percentOutput;
    m_motor.setControl(intakePercentOutput);


}
}




