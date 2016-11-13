package Test;

/**
 * Created by mcstarioni on 13.11.2016.
 */
    class AppThread extends Thread {

        public AppThread() {
        }

        public void run() {

            Thread ct = Thread.currentThread();
            System.out.println("Дочернийпоток - " + ct.getName());
            for(int i = 1; i <= 5; i++)
            {
                System.out.println("Значение цикла дочернего потока " + ct.getName() +" - " + i);
            }
            System.out.println("Работа дочернего потока завершена - " + ct.getName());
        }
    }
    class App {

        public static void main(String[] args) {
            System.out.println("Родительский поток.");
            for(int i = 1; i <= 10; i++){
                Thread t = new Thread(new AppThread());
                t.setName("Дочь - "+i);
                t.start();
                //Thread.yield();
            }
        }


    }
