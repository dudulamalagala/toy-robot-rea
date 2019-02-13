package com.rea.toyrobot.robot;

import com.rea.toyrobot.configuration.Configuration;
import com.rea.toyrobot.configuration.Orientation;
import com.rea.toyrobot.configuration.Position;

/**
 * Builder to create the toy robot for the simulator.
 *
 * As only the boundary is mandatory it could have been provided though the constructor.
 * Also the initial configuration can be set through a place command.
 * As a result, builder pattern is rather oversized here, but shows I know yet another pattern ;-)
 */
public class RobotBuilder {

    private Position boundary;
    private Configuration configuration;

    public RobotBuilder optionalInitialConfiguration(Configuration configuration) {
        this.configuration = configuration;
        return this;
    }

    public RobotBuilder optionalInitialConfiguration(Position position, Orientation orientation) {
        this.optionalInitialConfiguration(new Configuration(position, orientation));
        return this;
    }

    public RobotBuilder mandatoryNorthEastBoundary(Position position) {
        this.boundary = position;
        return this;
    }

    public Robot build() {
        if (this.boundary == null) {
            throw new IllegalStateException("No boundaries for movement are set.");
        }
        return new RobotImpl(this.configuration, this.boundary);
    }

}
