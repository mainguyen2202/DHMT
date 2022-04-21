package exercise2;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import jgl.GL;
import jgl.GLCanvas;

public class Bai5 extends GLCanvas {
	double X = 0.5, Y = 0.5;
	double R = 0.25;
	int a = 50;
	private char unit;

	private void myinit() {
		myGL.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
		myGL.glMatrixMode(GL.GL_PROJECTION);
		myGL.glLoadIdentity();
		myGL.glOrtho(-1.0f, 1.0f, -1.0f, 1.0f, 0.0f, 0.0f);
	}

	public void display() {
		myGL.glClear(GL.GL_COLOR_BUFFER_BIT);
		myGL.glLoadIdentity();
		myGL.glRotated(30, 1, 0, 0);

		myGL.glColor3f(1.0f, 1.0f, 0.0f);
//		myGL.glBegin(GL.GL_LINE_STRIP);
		myGL.glBegin(GL.GL_TRIANGLE_STRIP);
//		myGL.glBegin(10);
		for (double theta = 0; theta <= Math.PI; theta = (Math.PI * 2) / a + theta) {
			for (double phi = 0; phi <= Math.PI * 2; phi = (Math.PI * 2) / a + phi) {
				myGL.glVertex3d(R * Math.cos(theta) * Math.cos(phi), R * Math.sin(theta),
						R * Math.cos(theta) * Math.sin(phi));

			}

		}
		
		myGL.glOrtho(-1.0f, 1.0f, -1.0f, 1.0f, 0.0f, 0.0f);


		myGL.glEnd();

		myGL.glFlush();
	}

	public void init() {
		myUT.glutInitWindowSize(500, 500);
		myUT.glutInitWindowPosition(0, 0);
		myUT.glutCreateWindow(this);
		myinit();
		myUT.glutDisplayFunc("display");
		myUT.glutMainLoop();

	}

	public static void main(String[] args) throws IOException {
		Frame mainFrame = new Frame();
		mainFrame.setSize(508, 524);
		Bai5 mainCanvas = new Bai5();
		mainCanvas.init();
		mainFrame.add(mainCanvas);
		mainFrame.setVisible(true);
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}

}