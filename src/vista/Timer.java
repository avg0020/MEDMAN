package vista;

import javax.swing.JLabel;

public class Timer extends Thread{
	
	//Atributos
	private JLabel timer;
	private int m;
	private int s;
	private boolean isRunning, finish;
	
	//Constructores
	public Timer(JLabel timer) {
		super();
		this.timer = timer;
		this.isRunning = true;
		this.finish = false;
		this.m = 0;
		this.s = 0;
	}
	
	//Métodos
	@Override
	public void run() {
		super.run();
		while(isRunning && finish==false) {
			try {
				sleep(1000);
				s++;
				
				if (s>59) {
					s=0;
					m++;
				}
				
				String sTimer="";
				String mTimer="";
				
				if(s<10) {
					sTimer = "0"+s;
				}else {
					sTimer = String.valueOf(s);
				}
				
				if(m<10) {
					mTimer = "0"+m;
				}else {
					mTimer = String.valueOf(m);
				}
				
				timer.setText(mTimer+":"+sTimer);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}
	public int getS() {
		return s;
	}
	public void setS(int s) {
		this.s = s;
	}
	
	public boolean isRunning() {
		return isRunning;
	}

	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}
	
	public boolean isFinish() {
		return finish;
	}

	public void setFinish(boolean finish) {
		this.finish = finish;
	}
}
