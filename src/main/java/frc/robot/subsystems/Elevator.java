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

private ElevatorState elevState;

public Elevator() {

    m_right = new TalonFX(Constants.ElevatorConstants.BACKID , Constants.CANIVORE);
    m_left = new TalonFX(Constants.ElevatorConstants.FRONTID , Constants.CANIVORE);

    config();

  }

  public void setpose(double pose){
    m_left.setControl(m_motmag.withPosition(-pose));
    m_right.setControl(m_motmag.withPosition(pose));
  }

  public Double getpose(){
    return Math.abs(Math.abs(m_left.getPosition().getValueAsDouble())+ Math.abs(m_right.getPosition().getValueAsDouble())) / 2;
  }

  public void setElevatorState(ElevatorState state) {
    setpose(state.elevSetpoint);
    elevState = state;
  }

  public ElevatorState getElevatorState() {
    return elevState;
  }
  
  @Override
  public void periodic() {
    m_motmag.Slot = 0;
    SmartDashboard.putNumber("Elevator height", getpose());
    SmartDashboard.putNumber("Elevator Right Pose", m_right.getPosition().getValueAsDouble());
    SmartDashboard.putNumber("Elevator Left Pose", m_left.getPosition().getValueAsDouble());
  }



  public enum ElevatorState {

    L1(Constants.ElevatorConstants.L1),
    L2(Constants.ElevatorConstants.L2),
    L3(Constants.ElevatorConstants.L3),
    L4(Constants.ElevatorConstants.L4),
    BARGE(Constants.ElevatorConstants.BARGE),
    ALGAET2(Constants.ElevatorConstants.ALGAET2),
    ALGAET3(Constants.ElevatorConstants.ALGAET3),
    HP(Constants.ElevatorConstants.HUMAN),
    HOME(Constants.ElevatorConstants.HOME);

    public double elevSetpoint;
    private ElevatorState(double setpoint) {
        this.elevSetpoint = setpoint;
    }
    
  }




public void config(){
  m_motmag = new MotionMagicVoltage(0);    

  var talonFXConfigs = new TalonFXConfiguration();
    talonFXConfigs.CurrentLimits.withStatorCurrentLimitEnable(Constants.ElevatorConstants.CurrentLimitEnable);
    talonFXConfigs.CurrentLimits.withStatorCurrentLimit(Constants.ElevatorConstants.CurrentLimit);
    
  var slot0Configs = talonFXConfigs.Slot0;
    slot0Configs.kS = 0.24; // add 0.24 V to overcome friction
    slot0Configs.kV = 0.12; // apply 12 V for a target velocity of 100 rps

    
    slot0Configs.kP = Constants.ElevatorConstants.kp;
    slot0Configs.kI = Constants.ElevatorConstants.ki;
    slot0Configs.kD = Constants.ElevatorConstants.kD;

    slot0Configs.kV = Constants.ElevatorConstants.kV;
    slot0Configs.kS = Constants.ElevatorConstants.kS;
    slot0Configs.kG = Constants.ElevatorConstants.kG;

    var motionMagicConfigs = talonFXConfigs.MotionMagic;
    motionMagicConfigs.MotionMagicCruiseVelocity = Constants.ElevatorConstants.MotionMagicCruiseVelocity; // 80 rps cruise velocity
    motionMagicConfigs.MotionMagicAcceleration   = Constants.ElevatorConstants.MotionMagicAcceleration; // 160 rps/s acceleration (0.5 seconds)
    motionMagicConfigs.MotionMagicJerk           = Constants.ElevatorConstants.MotionMagicJerk; // 1600 rps/s^2 jerk (0.1 seconds)
    m_motmag.EnableFOC = Constants.ElevatorConstants.EnableFOC;



    m_left.getConfigurator().apply(talonFXConfigs, 0.050);
    m_left.setNeutralMode(NeutralModeValue.Brake);
    m_right.getConfigurator().apply(talonFXConfigs, 0.050);
    m_right.setNeutralMode(NeutralModeValue.Brake);

}

}




