package com.tlc.crm.crud;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

    /**
     * Start the bundle
     *
     * @param context
     */
    public void start(BundleContext context) {
        System.out.println("Starting the bundle");
    }

    /**
     * Stop the bundle
     *
     * @param context
     */
    public void stop(BundleContext context) {
        System.out.println("Stopping the bundle");
    }
}