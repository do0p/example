package mixins;

import java.util.function.Consumer;

import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;

public interface KeyListenerMixin {

	void addKeyListener(KeyListener listener);
	
	default void addKeyPressedListener(Consumer<KeyEvent> consumer) {
		addKeyListener(new KeyListenerAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				consumer.accept(e);
			}
		});
	}
	
	default void addKeyReleasedListener(Consumer<KeyEvent> consumer) {
		addKeyListener(new KeyListenerAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				consumer.accept(e);
			}
		});
	}
	
	
}
