package com.rea.toyrobot.command;

import com.rea.toyrobot.configuration.Configuration;

/**
 * Returns the unmodified input, thus causes no configuration change.
 * Used as null-object in fault cases.
 */
public class NullCommand implements Command {
    @Override
    public Configuration apply(Configuration configuration) {
        return configuration;
    }
}
