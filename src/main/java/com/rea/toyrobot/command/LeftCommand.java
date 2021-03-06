package com.rea.toyrobot.command;

import com.rea.toyrobot.configuration.Configuration;

public class LeftCommand extends AbstractCommand {
    @Override
    public Configuration applyInternal(Configuration configuration) {
        return new Configuration(configuration.position(), configuration.orientation().left());
    }
}
