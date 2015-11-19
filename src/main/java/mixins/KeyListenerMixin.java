package mixins;

import java.util.function.Consumer;

import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.widgets.Control;

/**
 * Defines additional methods with functional interfaces as arguments, in order
 * to be used with lambda expressions.
 */
public interface KeyListenerMixin {

	/**
	 * This method is defined in {@link Control}.
	 */
	void addKeyListener(KeyListener listener);

	/**
	 * The given consumer will receive a {@link KeyEvent} when a key is pressed.
	 */
	default void addKeyPressedListener(Consumer<KeyEvent> consumer) {
		addKeyListener(new KeyListenerAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				consumer.accept(e);
			}
		});
	}

	/**
	 * The given consumer will receive a {@link KeyEvent} when a key is
	 * released.
	 */
	default void addKeyReleasedListener(Consumer<KeyEvent> consumer) {
		addKeyListener(new KeyListenerAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				consumer.accept(e);
			}
		});
	}
}
