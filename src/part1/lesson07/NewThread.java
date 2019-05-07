package part1.lesson07;

import java.security.SecureRandom;

/**
 * Запускаем вычисление факториала случайного числа в новом потоке
 */
public class NewThread implements Runnable {
    private String name;
    private Thread t;
    private int value;

    NewThread(String threadName, int value){
        name = threadName;
        this.value = value;
        t = new Thread(this, name);
        t.start();
    }

    @Override
    public void run() {
        Factorial fact = new Factorial();
        SecureRandom rand = new SecureRandom();
        try {
            synchronized (this){
                fact.count(value);
            }
        }
        catch (Exception e) {
            System.err.println(name + " is interrupted because of " + e.getLocalizedMessage());
        }
    }
}
