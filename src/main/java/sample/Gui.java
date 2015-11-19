package sample;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.TypedEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import mixins.KeyListenerAdapter;
import mixins.MouseListenerAdapter;

/**
 * Example gui demonstrating various possibilities to register listeners.
 */
public class Gui {

	public static void main(String[] args) {
		new Gui();
	}

	public Gui() {
		Display display = new Display();
		Shell shell = createShell(display);

		LambdaLabel lambdaLabel = createLambdaLabel(shell);
		addListeners(lambdaLabel, "interface");
		addAdapterListeners(lambdaLabel, "adapter");
		addLambdaListeners(lambdaLabel, "mixin");

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

	/**
	 * Adds listeners as anonymous subclasses of the listener interfaces. Every
	 * method in the interface must be overridden.
	 */
	private void addListeners(LambdaLabel lLabel, String name) {
		lLabel.addDisposeListener(new DisposeListener() {
			@Override
			public void widgetDisposed(DisposeEvent event) {
				onDispose(event, name);
			}
		});
		lLabel.addMouseListener(new MouseListener() {
			@Override
			public void mouseDoubleClick(MouseEvent event) {
				onMouseDoubleClick(event, name);
			}

			@Override
			public void mouseDown(MouseEvent event) {
				// nothing todo
			}

			@Override
			public void mouseUp(MouseEvent e) {
				// nothing todo
			}
		});
		lLabel.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent event) {
				onKeyPressed(event, name);
			}

			@Override
			public void keyReleased(KeyEvent event) {
				onKeyReleased(event, name);
			}
		});
	}

	/**
	 * Adds listeners as anonymous subclasses of the listener adapter
	 * interfaces. Only the method of interest has to be overridden, because
	 * there are default implementations of all methods.
	 */
	private void addAdapterListeners(LambdaLabel lLabel, String name) {
		lLabel.addDisposeListener(new DisposeListener() {
			@Override
			public void widgetDisposed(DisposeEvent event) {
				onDispose(event, name);
			}
		});
		lLabel.addMouseListener(new MouseListenerAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent event) {
				onMouseDoubleClick(event, name);
			}
		});
		lLabel.addKeyListener(new KeyListenerAdapter() {
			@Override
			public void keyPressed(KeyEvent event) {
				onKeyPressed(event, name);
			}
		});
		lLabel.addKeyListener(new KeyListenerAdapter() {
			@Override
			public void keyReleased(KeyEvent event) {
				onKeyReleased(event, name);
			}
		});
	}

	/**
	 * Adds listeners via the methods provided by the listener mixin interfaces.
	 * These additional methods take a functional interface as argument and can
	 * therefore be used with lambda expressions.
	 */
	private void addLambdaListeners(LambdaLabel lLabel, String name) {
		lLabel.addDisposeListener(event -> onDispose(event, name));
		lLabel.addMouseDoubleClickedListener(event -> onMouseDoubleClick(event, name));
		lLabel.addKeyPressedListener(event -> onKeyPressed(event, name));
		lLabel.addKeyReleasedListener(event -> onKeyReleased(event, name));
	}

	private void onDispose(DisposeEvent event, String name) {
		logEvent(event, "dispose", name);
	}

	private void onKeyReleased(KeyEvent event, String name) {
		logEvent(event, "key released " + event.keyCode, name);
	}

	private void onKeyPressed(KeyEvent event, String name) {
		logEvent(event, "key pressed " + event.keyCode, name);
	}

	private void onMouseDoubleClick(MouseEvent event, String name) {
		logEvent(event, "double click", name);
	}

	private void logEvent(TypedEvent event, String type, String name) {
		doLog(String.format("Event %s of type %s occured on %s of %s", event.getClass().getSimpleName(), type,
				event.getSource().getClass().getSimpleName(), name));
	}

	private void doLog(String message) {
		System.err.println(message);
	}

	private Shell createShell(Display display) {
		Shell shell = new Shell(display);
		GridLayout layout = new GridLayout(1, false);
		shell.setLayout(layout);
		shell.setText("example");
		return shell;
	}

	private LambdaLabel createLambdaLabel(Shell shell) {
		LambdaLabel label = new LambdaLabel(shell, SWT.TOP);
		label.setLayoutData(new GridData(400, 100));
		label.setText("this is a " + label.getClass().getSimpleName());
		return label;
	}
}