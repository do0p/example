package mixins;

import java.util.function.Consumer;

import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;

public interface MouseListenerMixin {

	void addMouseListener(MouseListener listener);
	
	default void addMouseDoubleClickedListener(Consumer<MouseEvent> consumer) {
		addMouseListener(new MouseListenerAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				consumer.accept(e);
			}
		});
	}
	
	default void addMouseDownListener(Consumer<MouseEvent> consumer) {
		addMouseListener(new MouseListenerAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				consumer.accept(e);
			}
		});
	}
	
	default void addMouseUpListener(Consumer<MouseEvent> consumer) {
		addMouseListener(new MouseListenerAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				consumer.accept(e);
			}
		});
	}
}
