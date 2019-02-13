package com.rea.toyrobot.command;

import com.rea.toyrobot.configuration.Configuration;

import java.util.function.UnaryOperator;

/**
 * Commands take an input configuration and transform it to an output configuration,
 * based on their respective implementation.
 */
public interface Command extends UnaryOperator<Configuration> {
    /**
     * Transform an input configuration.
     *
     * @param configuration The input configuration.
     * @return The altered configuration.
     */
    @Override
    Configuration apply(Configuration configuration);
}
