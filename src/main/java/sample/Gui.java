package sample;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.TypedEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import mixins.KeyListenerAdapter;
import mixins.MouseListenerAdapter;

public class Gui {

	public static void main(String[] args) {
		new Gui();
	}
	
	public Gui() {

		Display display = new Display();

		Shell shell = new Shell(display);
		GridLayout layout = new GridLayout(1, false);
		shell.setLayout(layout);
		shell.setText("example");

		LambdaLabel label = new LambdaLabel(shell, SWT.TOP);
		label.setLayoutData(new GridData(400, 300));
		label.setText("this is a " + label.getClass().getSimpleName());

		addAdapterListeners(label);
		addLambdaListeners(label);

		try {
			shell.pack();
			shell.open();

			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}

			}
		} finally {
			display.dispose();
		}
	}

	private void addAdapterListeners(LambdaLabel lLabel) {
		lLabel.addDisposeListener(new DisposeListener() {
			@Override
			public void widgetDisposed(DisposeEvent event) {
				logEvent(event);
			}
		});
		lLabel.addMouseListener(new MouseListenerAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent event) {
				onMouseDoubleClick(event);
			}
		});
		lLabel.addMouseListener(new MouseListenerAdapter() {
			@Override
			public void mouseDown(MouseEvent event) {
				onMouseDown(event);
			}
		});
		lLabel.addKeyListener(new KeyListenerAdapter() {
			@Override
			public void keyPressed(KeyEvent event) {
				onKeyPressed(event);
			}
		});
		lLabel.addKeyListener(new KeyListenerAdapter() {
			@Override
			public void keyReleased(KeyEvent event) {
				onKeyReleased(event);
			}
		});
	}
	
	private void addLambdaListeners(LambdaLabel lLabel) {
		lLabel.addDisposeListener(event -> logEvent(event));
		lLabel.addMouseDoubleClickedListener(event -> onMouseDoubleClick(event));
		lLabel.addMouseDownListener(event -> onMouseDown(event));
		lLabel.addKeyPressedListener(event -> onKeyPressed(event));
		lLabel.addKeyReleasedListener(event -> onKeyReleased(event));
	}

	private void onKeyReleased(KeyEvent event) {
		logEvent(event, "key released " + event.keyCode);
	}

	private void onKeyPressed(KeyEvent event) {
		logEvent(event, "key pressed " + event.keyCode);
	}

	private void onMouseDoubleClick(MouseEvent event) {
		logEvent(event, "double click");
	}

	private void onMouseDown(MouseEvent event) {
		logEvent(event, "down");
	}

	private void logEvent(TypedEvent event) {
		doLog(String.format("Event %s occured on %s", event.getClass().getSimpleName(),
				event.getSource().getClass().getSimpleName()));
	}

	private void logEvent(TypedEvent event, String type) {
		doLog(String.format("Event %s of type %s occured on %s", event.getClass().getSimpleName(), type,
				event.getSource().getClass().getSimpleName()));
	}

	private void doLog(String message) {
		System.err.println(message);
	}


}