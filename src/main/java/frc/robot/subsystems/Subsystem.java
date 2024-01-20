package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.IntakeConstants.IntakeState;

import com.revrobotics.CANSparkFlex;
import com.revrobotics.CANSparkLowLevel.MotorType;

public class Subsystem extends SubsystemBase{
    private CANSparkFlex m1;
    private CANSparkFlex m2;
    private IntakeState intakeState;

    public Subsystem(){
        m1 = new CANSparkFlex(Constants.IntakeConstants.m1ID, MotorType.kBrushless);
        m2 = new CANSparkFlex(Constants.IntakeConstants.m2ID, MotorType.kBrushless);
        m2.follow(m1);
        m2.setInverted(true);
        intakeState = IntakeState.OFF;
    }
    @Override
    public void periodic(){
        m1.set(intakeState.speed);
    }

    public void setIntakeState(IntakeState state){
        intakeState = state;
    }
}
