package de.behring.trainingDB.core;

import com.db4o.ObjectContainer;

/**
 * User: carsten
 * Date: Jan 24, 2010
 * Time: 8:05:09 PM
 */
public abstract class AbstractCommand {
    private final ObjectContainer objectContainer;
    public AbstractCommand(ObjectContainer objectContainer) {
        this.objectContainer=objectContainer;
    }
    public final void execute() {
        executeInObjectContainer(objectContainer);
    }

    public abstract  void executeInObjectContainer(ObjectContainer objectContainer);
}
