// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.CANrange;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.controls.VelocityDutyCycle;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class  Intake extends SubsystemBase {
  


  TalonFX m_coralMotor;
  TalonFX m_algaeMotor;
VelocityDutyCycle intakeVelocity; 

CANrange m_coralCanrange;
CANrange m_algaeCanrange;

DutyCycleOut intakePercentOutput;


public Intake() {
    m_coralMotor = new TalonFX(Constants.CoralIntakeConstants.MOTORID , Constants.CANIVORE);
    m_algaeMotor = new TalonFX(Constants.AlgaeIntakeConstants.MOTORID , Constants.CANIVORE);
     m_coralCanrange = new CANrange(Constants.CoralIntakeConstants.CANRANGEID, Constants.CANIVORE);
     m_algaeCanrange = new CANrange(Constants.CoralIntakeConstants.CANRANGEID, Constants.CANIVORE);
    final TalonFXConfiguration configuration = new TalonFXConfiguration();
    configuration.CurrentLimits.withStatorCurrentLimitEnable(true);
    configuration.CurrentLimits.withStatorCurrentLimit(40);
   

    m_coralMotor.getConfigurator().apply(configuration, 0.050);

    intakeVelocity = new VelocityDutyCycle(0);

    // periodic, run Motion Magic with slot 0 configs,
  }
  
  @Override
  public void periodic() {
    
    SmartDashboard.putNumber("intake height", 0);
  }

  
 

  

  

  public void intakerun(double velocity){
    intakeVelocity.Velocity = velocity * 5;
        m_coralMotor.setControl(intakeVelocity);

    // m_motor.set(velocity);

    
  }

  public void coralintakerunvoltage(double velocity){
    m_coralMotor.setVoltage(velocity);

// m_motor.set(velocity);


}

public void algaeintakerunvoltage(double velocity){
    m_algaeMotor.setVoltage(velocity);

// m_motor.set(velocity);


}

public void CORALOUTTAKE(double velocity){
// intakeVelocity.Velocity = velocity;
//     m_motor.setControl(intakeVelocity);

m_coralMotor.set(velocity);

if(SmartDashboard.getNumber("coral intake speed", 1) > 0.1 ){
  m_coralMotor.set(velocity);
} else {
  m_coralMotor.set(Constants.CoralIntakeConstants.L1);
}
}

public void ALGAEOUTTAKE(double velocity){
// intakeVelocity.Velocity = velocity;
//     m_motor.setControl(intakeVelocity);

m_algaeMotor.set(velocity);

// if(SmartDashboard.getNumber("algae intake speed", 1) > 0.1 ){
//   m_algaeMotor.set(velocity);
// } else {
//   m_algaeMotor.set(Constants.AlgaeIntakeConstants.L1);
// }
}

public void coralIntakePercentOutput(double percentOutput) {

intakePercentOutput.Output = percentOutput;
m_coralMotor.setControl(intakePercentOutput);

}

public void algaeIntakePercentOutput(double percentOutput) {

intakePercentOutput.Output = percentOutput;
m_algaeMotor.setControl(intakePercentOutput);


}

public boolean HasCoral(){
return m_coralCanrange.getDistance().getValueAsDouble() <= 0.051;

}

public boolean HasAlgae(){
return m_algaeCanrange.getDistance().getValueAsDouble() <= 0.051;
}

public enum IntakeState{
  HOME(Constants.CoralIntakeConstants.HOLD),
  INTAKE(Constants.CoralIntakeConstants.INTAKE),
  OUTTAKE(Constants.CoralIntakeConstants.OUTTAKE),
  L1(Constants.CoralIntakeConstants.HOLD),
  L2(Constants.CoralIntakeConstants.HOLD),
  L3(Constants.CoralIntakeConstants.HOLD),
  L4(Constants.CoralIntakeConstants.HOLD),
  CLIMB(Constants.CoralIntakeConstants.STOP),
  ALGAET2(Constants.AlgaeIntakeConstants.INTAKE),
  ALGAET3(Constants.AlgaeIntakeConstants.INTAKE),
  NET(Constants.AlgaeIntakeConstants.HOLD);

  

  public double speed;
  IntakeState(double speed){
    this.speed = speed;
  }
  
}
}




