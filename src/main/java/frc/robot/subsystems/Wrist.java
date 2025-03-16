// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.MotionMagicVoltage;
import com.ctre.phoenix6.controls.PositionDutyCycle;
import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class Wrist extends SubsystemBase {
  

MotionMagicVoltage m_motmag;

PositionDutyCycle m_PositionDutyCycle;
TalonFX m_motor;
CANcoder m_canCoder;
double nudge = 0;


public Wrist() {
    m_motor = new TalonFX(Constants.WristConstants.MOTORID , Constants.CANIVORE);
    

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
    motionMagicConfigs.MotionMagicCruiseVelocity = 160; // 80 rps cruise velocity
    motionMagicConfigs.MotionMagicAcceleration = 240; // 160 rps/s acceleration (0.5 seconds)
    motionMagicConfigs.MotionMagicJerk = 600; // 1600 rps/s^2 jerk (0.1 seconds)

    m_motmag.EnableFOC = true;
    
    m_motor.getConfigurator().apply(talonFXConfigs, 0.050);
    m_motor.setNeutralMode(NeutralModeValue.Brake);
    // periodic, run Motion Magic with slot 0 configs,
  }
  
  @Override
  public void periodic() {
    m_motmag.Slot = 0;
    SmartDashboard.putNumber("wrist angle", getpose());
  }

  public Double getpose(){ // if you need negative pos, you need to change this
  return  m_motor.getPosition().getValueAsDouble();

 

  }

  public void setangle(double angle){

    m_motor.setControl(m_motmag.withPosition(angle+nudge));


  }
  public void setnudge(double change){
    nudge = nudge + change;
  }

}




