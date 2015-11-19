package mixins;

import java.util.function.Consumer;

import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.widgets.Control;

/**
 * Defines additional methods with functional interfaces as arguments, in order
 * to be used with lambda expressions.
 */
public interface MouseListenerMixin {

	/**
	 * This method is defined in {@link Control}.
	 * 
	 * @param listener
	 */
	void addMouseListener(MouseListener listener);
	
	/**
	 * The given consumer will receive a {@link MouseEvent} when a double click occurs.
	 * 
	 * @param consumer
	 */
	default void addMouseDoubleClickedListener(Consumer<MouseEvent> consumer) {
		addMouseListener(new MouseListenerAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				consumer.accept(e);
			}
		});
	}
	
	/**
	 * The given consumer will receive a {@link MouseEvent} when a mouse button is pressed.
	 * 
	 * @param consumer
	 */
	default void addMouseDownListener(Consumer<MouseEvent> consumer) {
		addMouseListener(new MouseListenerAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				consumer.accept(e);
			}
		});
	}
	
	/**
	 * The given consumer will receive a {@link MouseEvent} when a mouse button is released.
	 * 
	 * @param consumer
	 */
	default void addMouseUpListener(Consumer<MouseEvent> consumer) {
		addMouseListener(new MouseListenerAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				consumer.accept(e);
			}
		});
	}
}
