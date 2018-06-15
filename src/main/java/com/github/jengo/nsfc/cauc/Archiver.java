package com.github.jengo.nsfc.cauc;

import com.github.jengo.nsfc.cauc.domain.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * {@link Archiver}
 */
public class Archiver {
    private static final Logger LOG = LoggerFactory.getLogger(Archiver.class);

    private static final String USAGE = "Usage: java Archiver <inDir> <inSuffix> <outDir>";

    public static void main(String[] args) throws Exception {
        if (3 != args.length) {
            throw new RuntimeException(USAGE);
        }
        System.setProperty("sun.java2d.cmm", "sun.java2d.cmm.kcms.KcmsServiceProvider");
        Context context = new Context(args[0], args[1], args[2]);

        LOG.info("Starting extract ...");
        Extracter.extract(context);
        LOG.info("Finished extract .");

        LOG.info("Starting print ...");
        Printer.print(context);
        LOG.info("Finished print .");
    }

}
