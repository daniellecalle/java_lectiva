package emisora;
/*
 * 1.1 Swing version.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/* 
 * Based on Arthur van Hoff's animation examples, this application
 * can serve as a template for all animation applications.
 */
public class AnimatorApplicationTimer extends JFrame implements ActionListener {
    BotonesReproducir miPlay = new BotonesReproducir();
    int frameNumber = -1;
    int delay;
    boolean frozen = false;
    JLabel label;
    Timer timer; //Is the priority of this thread too high?
		 //Sometimes I can't interrupt the program easily.

    public AnimatorApplicationTimer(int fps, String windowTitle) {
        super(windowTitle);
        delay = (int) miPlay.getTiempo();

        //Set up a timer that calls this object's action handler.
        timer = new Timer(delay, this);
        timer.setInitialDelay(0);
        timer.setCoalesce(true);

        

        Container contentPane = getContentPane();
        contentPane.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (frozen) {
                    frozen = false;
                    startAnimation();
                } else {
                    frozen = true;
                    stopAnimation();
                }
            }
        });

	label = new JLabel("Frame       ", JLabel.CENTER);
	contentPane.add("Center", label);
    }

    public void startAnimation() {
        if (frozen) {
            //Do nothing.  The user has requested that we
            //stop changing the image.
        } else {
            //Start (or restart) animating!
            timer.start();
        }
    }


    public void stopAnimation() {
        //Stop the animating thread.
        timer.stop();
    }

    public void actionPerformed(ActionEvent e) {
        //Advance the animation frame.
	frameNumber++;
        label.setText("Frame " + frameNumber);
    }

    public static void main(String args[]) {
        AnimatorApplicationTimer animator = null;
        int fps = 0;

        // Get frames per second from the command line argument
        if (args.length > 0) {
            try {
                fps = Integer.parseInt(args[0]);
            } catch (Exception e) {}
        }
        animator = new AnimatorApplicationTimer(fps, "Animator with Timer");
        animator.pack();
        animator.setVisible(true);
        animator.startAnimation();
    }
}