import by.epam.jmp.multithreading.FactorialService;
import by.epam.jmp.multithreading.bean.FactorialResult;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MultithreadingMain {
    
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        int threadNum = 3;
        ExecutorService executor = Executors.newFixedThreadPool(threadNum);
        List<FutureTask<FactorialResult>> taskList = new ArrayList<FutureTask<FactorialResult>>();

        taskList.add(new FutureTask<FactorialResult>(() -> {return FactorialService.calculateFactorial(3);}));
        taskList.add(new FutureTask<FactorialResult>(() -> {return FactorialService.calculateFactorial(5);}));
        taskList.add(new FutureTask<FactorialResult>(() -> {return FactorialService.calculateFactorial(8);}));

        for (FutureTask<FactorialResult> futureTask : taskList) {
            executor.execute(futureTask);
            System.out.println("factorial = " + futureTask.get());
        }

        executor.shutdown();

    }
}
