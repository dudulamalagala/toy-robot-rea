package com.rea.toyrobot.command;

import com.rea.toyrobot.configuration.Configuration;

/**
 * Possible, but yet unused command to take the robot off the tabletop.
 */
public class UnplaceCommand implements Command {
    @Override
    public Configuration apply(Configuration configuration) {
        return null;
    }
}
