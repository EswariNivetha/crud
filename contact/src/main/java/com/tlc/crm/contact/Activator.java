package com.tlc.crm.contact;

import com.tlc.crm.contact.api.Contact;
import com.tlc.crm.contact.api.ContactManager;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * @author Abishek
 * @version 1.0
 */
public class Activator implements BundleActivator
{
    private static final ContactManager contactManager = ContactManager.getInstance();
    @Override
    public void start(BundleContext bundleContext)
    {
        System.out.println("test");
       // contactManager.create(new Contact());

        //System.out.println( "Id"+ContactManager.getInstance().get(Long.valueOf("234")));

    }

    @Override
    public void stop(BundleContext bundleContext)
    {

    }
}
