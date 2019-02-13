package com.rea.toyrobot.command;

import com.rea.toyrobot.configuration.Configuration;

/**
 * Applies no transition to the robot but indicates a report should be made in the simulator's main().
 */
public class ReportCommand extends AbstractCommand {
    @Override
    public Configuration applyInternal(Configuration configuration) {
        return configuration;
    }
}
