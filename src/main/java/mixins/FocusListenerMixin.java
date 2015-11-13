package mixins;

import java.util.function.Consumer;

import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;

public interface FocusListenerMixin {

	void addFocusListener(FocusListener listener);
	
	default void addFocusGainedListener(Consumer<FocusEvent> consumer) {
		addFocusListener(new FocusListenerAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				consumer.accept(e);
			}
		});
	}
	
	default void addFocusLostListener(Consumer<FocusEvent> consumer) {
		addFocusListener(new FocusListenerAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				consumer.accept(e);
			}
		});
	}
}
