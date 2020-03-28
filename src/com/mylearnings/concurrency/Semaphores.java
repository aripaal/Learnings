package com.mylearnings.concurrency;

/**
 * Created by ronnie on 4/30/17.
 */
public class Semaphores {

    public static class SimpleSemaphore{
        public boolean signal=true;
        public synchronized void take() throws InterruptedException{
            signal=false;
            notifyAll();
        }
        public synchronized void release() throws InterruptedException{
            while(signal)wait();
            signal=true;
        }
    }



    public static class CountingSemaphore{
        int signal=0;
        public synchronized void take() throws InterruptedException{
            ++signal;
            notifyAll();
        }
        public synchronized void release() throws InterruptedException{
            while(signal==0)wait();
            --signal;
        }

    }

    public static class BoundedSemaphore{
        int signal=0;
        int bound=0;

        public BoundedSemaphore(int bound) {
            this.bound = bound;
        }

        public void take() throws InterruptedException{
            if(signal==bound)wait();
            ++signal;
            notifyAll();


        }
        public synchronized void release() throws InterruptedException{
            if(signal==0)wait();
            --signal;
            notifyAll();
        }

    }


}
