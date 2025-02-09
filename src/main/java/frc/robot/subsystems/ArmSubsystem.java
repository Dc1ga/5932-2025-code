package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
//import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Configs;
import frc.robot.Constants.ArmConstants;

public class ArmSubsystem extends SubsystemBase {

    private final SparkMax m_armSpark;
    //private final RelativeEncoder m_armEncoder;

    
    /**
     * Este subsistema controla los rollers del intake / arm 
     */
    public ArmSubsystem () {

    // Declarar el motor como un brushless
    m_armSpark = new SparkMax(ArmConstants.kArmPivotCanId, MotorType.kBrushless);
    //m_armEncoder = m_armSpark.getEncoder();

    // Set can timeout. Because this project only sets parameters once on
    // construction, the timeout can be long without blocking robot operation. Code
    // which sets or gets parameters during operation may need a shorter timeout.
    m_armSpark.setCANTimeout(250);

    // Create and apply configuration for arm motor. Voltage compensation helps
    // the arm behave the same as the battery
    // voltage dips. The current limit helps prevent breaker trips or burning out
    // the motor in the event the arm stalls.
    m_armSpark.configure(Configs.ArmIntakeModule.armPivotConfig, ResetMode.kResetSafeParameters,
        PersistMode.kPersistParameters);
    }

    @Override
    public void periodic() {
    }
    /** 
     * This is a method that makes the arm move at your desired speed
     *  Positive values make it spin forward and negative values spin it in reverse
     * 
     * @param speed motor speed from -1.0 to 1, with 0 stopping it
     */
    public void runArm(double speed){
        m_armSpark.set(speed);
    }
}