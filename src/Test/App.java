package Test;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
    class App extends JFrame implements KeyListener {

        public static void main(String[] args) {
            App ap = new App();

        }
        App()
        {
            super("MaxLox");
            this.setVisible(true);
            this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            this.setContentPane(new JPanel());
            this.getContentPane().setFocusable(true);
            this.getContentPane().addKeyListener(this);
        }


        @Override
        public void keyTyped(KeyEvent e) {
            System.out.println(e.getKeyChar());
        }

        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println(e.getKeyChar());
                    /*writingLabel.setText(writingLabel.getText() + e.getKeyChar());
                    writingLabel.repaint();*/
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println(" c " + e.getKeyChar());
        }
    }
