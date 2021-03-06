package com.jy.bron.core.utils;

/**
 * Obeserver.
 *
 * @author <a href="mailto:liaochuntao@live.com">liaochuntao</a>
 */
public interface Observer {
    
    /**
     * This method is called whenever the observed object is changed. An application calls an {@code Observable}
     * object's {@code notifyObservers} method to have all the object's observers notified of the change.
     *
     * @param o   the observable object.
     * @param arg an argument passed to the {@code notifyObservers} method.
     */
    void update(Observable o, Object arg);
    
}
