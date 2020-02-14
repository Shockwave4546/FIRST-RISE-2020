package frc.robot.subsystems.motors;

public class PID{
    private double P, I, D, E, d;
    private double integral, previousError, setPoint = 0;
    public PID(){
        P = 1;
        I = 1;
        D = 1;
        E = .25;
        d = .5;
    }
    public PID(double proportion, double integral, double derivative, double errorScale, double derivativeScale){
        P = proportion;
        I = integral;
        D = derivative;
        E = errorScale;
        d = derivativeScale;
    }

    public void setSetPoint(double input){
        setPoint = input;
    }

    public double getCalculation(double errorActual){
        // Error = Target - Actual
        double error = (setPoint - errorActual) * E;
        // Integral is increased by the error*time (which is .02 seconds using normal IterativeRobot)
        integral += (error * .005);
        double derivative = (error - previousError) / d;
        previousError = error;
        //System.out.println(P*error + I*integral + D*derivative);
        return (P * error) + (I * integral) + (D * derivative);
    }
}