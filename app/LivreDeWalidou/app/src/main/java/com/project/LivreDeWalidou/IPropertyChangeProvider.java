package com.project.LivreDeWalidou;

import java.beans.PropertyChangeListener;

public interface IPropertyChangeProvider {
    void addPropertyChangeListener(PropertyChangeListener listener);
    void removePropertyChangeListener(PropertyChangeListener listener);
    void addPropertyChangeListener(String property, PropertyChangeListener listener);
    void removePropertyChangeListener(String property, PropertyChangeListener listener);
}
