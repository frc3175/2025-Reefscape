package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.led.*;
import com.ctre.phoenix.led.CANdle.LEDStripType;

public class LED extends SubsystemBase {

  private CANdle m_candle;
  private boolean configured = false;
 

  public LED() {

    m_candle = new CANdle(Constants.CANdleConstants.CANdleID, Constants.RIO);
    Configure();
    setLEDs(255, 0, 0);
    
      
  }

  /** Creates a new Candle. */
  public void Configure() {
    if(!configured){
    CANdleConfiguration configAll = new CANdleConfiguration();
    configAll.statusLedOffWhenActive = true;
        configAll.disableWhenLOS = false;
        configAll.stripType = LEDStripType.RGB;
        configAll.brightnessScalar = 1;
        m_candle.configAllSettings(configAll, 100);
        configured = true;
    }

        
  }

 

  

 

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void setLEDs(int r, int g, int b){
    m_candle.setLEDs(r, g, b);
  }
}