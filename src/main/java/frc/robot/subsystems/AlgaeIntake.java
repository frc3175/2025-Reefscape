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

public class  AlgaeIntake extends SubsystemBase {
  


TalonFX m_roller;
TalonFX m_pivot;

VelocityDutyCycle intakeVelocity; 
MotionMagicVoltage m_motmag;

DutyCycleOut intakePercentOutput;


public AlgaeIntake() {
    m_roller = new TalonFX(Constants.AlgaeIntakeConstants.ROLLERID , Constants.CANIVORE);
    m_pivot = new TalonFX(Constants.AlgaeIntakeConstants.PIVOTID , Constants.CANIVORE);
   

    m_motmag = new MotionMagicVoltage(0);

    var talonFXConfigs = new TalonFXConfiguration();
    
    var slot0Configs = talonFXConfigs.Slot0;
    slot0Configs.kS = 0.24; // add 0.24 V to overcome friction
    slot0Configs.kV = 0.12; // apply 12 V for a target velocity of 100 rps
    // PID runs on position

    slot0Configs.kP = 2; // change as needed
    slot0Configs.kI = 0;
    slot0Configs.kD = 0;

    var motionMagicConfigs = talonFXConfigs.MotionMagic;
    motionMagicConfigs.MotionMagicCruiseVelocity = 120; // 80 rps cruise velocity
    motionMagicConfigs.MotionMagicAcceleration = 240; // 160 rps/s acceleration (0.5 seconds)
    motionMagicConfigs.MotionMagicJerk = 800; // 1600 rps/s^2 jerk (0.1 seconds)

    m_motmag.EnableFOC = true;
    
    m_pivot.getConfigurator().apply(talonFXConfigs, 0.050);
    m_pivot.setNeutralMode(NeutralModeValue.Brake);
    // periodic, run Motion Magic with slot 0 configs,
  
    intakeVelocity = new VelocityDutyCycle(0);

    // periodic, run Motion Magic with slot 0 configs,
  }
  
  @Override
  public void periodic() {
    m_motmag.Slot = 0;
    SmartDashboard.putNumber("algae intake angle", getpose());
  }

  
 

  

  

  public void intakerun(double velocity){
    intakeVelocity.Velocity = velocity;
        m_roller.setControl(intakeVelocity);
  }

  public void intakePercentOutput(double percentOutput) {

    // intakePercentOutput.Output = percentOutput;
    // m_roller.setControl(intakePercentOutput);

    m_roller.set(percentOutput);


}

public void setangle(double angle){

  m_pivot.setControl(m_motmag.withPosition(-angle));


}

public Double getpose(){ // if you need negative pos, you need to change this
  return  m_pivot.getPosition().getValueAsDouble();

 

  }
}




