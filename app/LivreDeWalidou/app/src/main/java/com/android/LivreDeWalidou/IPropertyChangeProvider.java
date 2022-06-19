package com.android.LivreDeWalidou;

import java.beans.PropertyChangeListener;

public interface IPropertyChangeProvider {
    void addPropertyChangeListener(PropertyChangeListener listener);
    void removePropertyChangeListener(PropertyChangeListener listener);
}
