package com.rea.toyrobot.robot;

import com.rea.toyrobot.command.MoveCommand;
import com.rea.toyrobot.command.PlaceCommand;
import com.rea.toyrobot.configuration.Configuration;
import com.rea.toyrobot.configuration.Orientation;
import com.rea.toyrobot.configuration.Position;
import com.rea.toyrobot.configuration.Transition;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class RobotImplTest {
    private Robot robot;

    @Before
    public void setUp() throws Exception {
        this.robot = new RobotBuilder()
                .mandatoryNorthEastBoundary(new Position(2, 2))
                .build();
    }

    @Test
    public void testUnplaced() throws Exception {
        Transition transition = this.robot.apply(new MoveCommand());
        assertNull(transition.to());
    }

    @Test
    public void testMove() throws Exception {
        this.robot.apply(new PlaceCommand(0, 0, Orientation.NORTH));
        Transition transition = this.robot.apply(new MoveCommand());
        assertEquals(new Configuration(0, 1, Orientation.NORTH), transition.to());
    }

    @Test
    public void testBoundary() throws Exception {
        this.robot.apply(new PlaceCommand(0, 0, Orientation.NORTH));
        this.robot.apply(new MoveCommand());
        Transition transition = this.robot.apply(new MoveCommand());
        assertEquals(new Configuration(0, 1, Orientation.NORTH), transition.to());
    }

    @Test
    public void transitionToEqualsConfigurationA() throws Exception {
        Transition transition = this.robot.apply(new PlaceCommand(0, 0, Orientation.NORTH));
        assertEquals(this.robot.configuration(), transition.to());
    }

    @Test
    public void transitionToEqualsConfigurationB() throws Exception {
        this.robot.apply(new PlaceCommand(0, 0, Orientation.NORTH));
        Transition transition = this.robot.apply(new MoveCommand());
        assertEquals(this.robot.configuration(), transition.to());
    }

}
