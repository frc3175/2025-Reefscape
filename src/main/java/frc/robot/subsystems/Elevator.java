// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.MotionMagicVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class Elevator extends SubsystemBase {
  

MotionMagicVoltage m_motmag;
TalonFX m_right;
TalonFX m_left;


public Elevator() {
    m_right = new TalonFX(Constants.ElevatorConstants.BACKID , Constants.CANIVORE);
    m_left = new TalonFX(Constants.ElevatorConstants.FRONTID , Constants.CANIVORE);

    


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
    motionMagicConfigs.MotionMagicCruiseVelocity = 80; // 80 rps cruise velocity
    motionMagicConfigs.MotionMagicAcceleration = 120; // 160 rps/s acceleration (0.5 seconds)
    motionMagicConfigs.MotionMagicJerk = 600; // 1600 rps/s^2 jerk (0.1 seconds)
    m_motmag.EnableFOC = true;



    m_left.getConfigurator().apply(talonFXConfigs, 0.050);
    m_left.setNeutralMode(NeutralModeValue.Brake);
    m_right.getConfigurator().apply(talonFXConfigs, 0.050);
    m_right.setNeutralMode(NeutralModeValue.Brake);
    // periodic, run Motion Magic with slot 0 configs,
  }
  
  @Override
  public void periodic() {
    m_motmag.Slot = 0;
    SmartDashboard.putNumber("Elevator height", getpose());
    SmartDashboard.putNumber("Elevator Right Pose", m_right.getPosition().getValueAsDouble());
    SmartDashboard.putNumber("Elevator Left Pose", m_left.getPosition().getValueAsDouble());
  }

public Double getpose(){ // if you need negative pos, you need to change this
  return Math.abs(Math.abs(m_left.getPosition().getValueAsDouble())+ Math.abs(m_right.getPosition().getValueAsDouble())) / 2;
}

public void setpose(double pose){
  m_left.setControl(m_motmag.withPosition(-pose));
  m_right.setControl(m_motmag.withPosition(pose));
}


}




