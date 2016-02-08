package by.epam.jmp.multithreading.bean;

/**
 * Created by Alexandr on 07.02.2016.
 */
public class FactorialResult {
    private int number;
    private int factorial;

    public FactorialResult(int factorial) {
        this.factorial = factorial;
    }

    public FactorialResult(int number, int factorial) {
        this.number = number;
        this.factorial = factorial;
    }

    public int getFactorial() {
        return factorial;
    }

    public void setFactorial(int factorial) {
        this.factorial = factorial;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "FactorialResult{" +
                "number=" + number +
                ", factorial=" + factorial +
                '}';
    }
}
