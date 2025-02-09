// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.MotionMagicVoltage;
import com.ctre.phoenix6.controls.PositionDutyCycle;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class Wrist extends SubsystemBase {
  

MotionMagicVoltage m_motmag;

PositionDutyCycle m_PositionDutyCycle;
TalonFX m_motor;

private WristState wristState;


public Wrist() {
    m_motor = new TalonFX(Constants.WristConstants.MOTORID , Constants.CANIVORE);
    config();
}

  public void SetWristState(Wriststate state) {
    setangle(state.wristPosition);
    wristState = state;
  }

  public GetWristState() {
    return wristState;
  }

  public void setangle(double angle){
    m_motor.setControl(m_motmag.withPosition(angle));
  }

  public Double getpose(){ // if you need negative pos, you need to change this
  return  m_motor.getPosition().getValueAsDouble();
  }

  @Override
  public void periodic() {
    m_motmag.Slot = 0;
    SmartDashboard.putNumber("wrist angle", getpose());
  }



  public enum Wriststate {

    HP(Constants.WristConstants.HUMAN),
    HOME(Constants.WristConstants.HOME);

    public double wristPosition;
    // public double wristVelocity;
    // public double wristAcceleration;
    // public int wristCurve;
    private IntakeState(double wristPosition/* , double wristVelocity, double wristAcceleration, int wristCurve*/){
        this.wristPosition = wristPosition;
        // this.wristVelocity = wristVelocity;
        // this.wristAcceleration = wristAcceleration;
        // this.wristCurve = wristCurve;
    }
  }





  public void config(){
    m_motmag = new MotionMagicVoltage(0);    
  
    var talonFXConfigs = new TalonFXConfiguration();
      talonFXConfigs.CurrentLimits.withStatorCurrentLimitEnable(Constants.WristConstants.CurrentLimitEnable);
      talonFXConfigs.CurrentLimits.withStatorCurrentLimit(Constants.WristConstants.CurrentLimit);
      
    var slot0Configs = talonFXConfigs.Slot0;
      slot0Configs.kS = 0.24; // add 0.24 V to overcome friction
      slot0Configs.kV = 0.12; // apply 12 V for a target velocity of 100 rps
  
      
      slot0Configs.kP = Constants.WristConstants.kp;
      slot0Configs.kI = Constants.WristConstants.kI;
      slot0Configs.kD = Constants.WristConstants.kD;
  
      var motionMagicConfigs = talonFXConfigs.MotionMagic;
      motionMagicConfigs.MotionMagicCruiseVelocity = Constants.WristConstants.MotionMagicCruiseVelocity; // 80 rps cruise velocity
      motionMagicConfigs.MotionMagicAcceleration   = Constants.WristConstants.MotionMagicAcceleration; // 160 rps/s acceleration (0.5 seconds)
      motionMagicConfigs.MotionMagicJerk           = Constants.WristConstants.MotionMagicJerk; // 1600 rps/s^2 jerk (0.1 seconds)
      m_motmag.EnableFOC = Constants.WristConstants.EnableFOC;
  
  
  
      m_motor.getConfigurator().apply(talonFXConfigs, 0.050);
      m_motor.setNeutralMode(NeutralModeValue.Brake);
  
  }

}




