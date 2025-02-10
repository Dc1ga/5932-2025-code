package frc.robot.subsystems;

//import edu.wpi.first.math.geometry.Rotation2d;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
//import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Configs.ArmIntakeModule;
import frc.robot.Constants.ArmConstants;

public class ArmSubsystem extends SubsystemBase {

    //Declarar los motores / encoders
    private final SparkMax m_armSpark;
    //private final RelativeEncoder m_armEncoder;


    // Este valor es cuantos grados tiene de offset el arm con respecto a los 90 grados, 
    //por defecto a 0 ya que es desconocido
    //private double m_armAngularOffset = 0;

    
    /**
     * Este subsistema controla el brazo del intake 
     */
    public ArmSubsystem () {

    // Declarar el motor como un brushless y asignar su encoder
    m_armSpark = new SparkMax(ArmConstants.kArmPivotCanId, MotorType.kBrushless);
    //m_armEncoder = m_armSpark.getEncoder();

    // Set can timeout. Because this project only sets parameters once on
    // construction, the timeout can be long without blocking robot operation. Code
    // which sets or gets parameters during operation may need a shorter timeout.
    m_armSpark.setCANTimeout(250);

    // Configurar el motor, esto usa los valores de configs.java
    m_armSpark.configure(ArmIntakeModule.armPivotConfig, ResetMode.kResetSafeParameters,
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
    public void setArmDegrees(double degrees){
        m_armSpark.set(degrees);
    }
}