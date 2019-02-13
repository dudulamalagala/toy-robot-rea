package com.rea.toyrobot.integration;

import com.rea.toyrobot.command.ReportCommand;
import com.rea.toyrobot.configuration.Configuration;
import com.rea.toyrobot.configuration.Position;
import com.rea.toyrobot.configuration.Transition;
import com.rea.toyrobot.input.CommandParser;
import com.rea.toyrobot.input.Sanitiser;
import com.rea.toyrobot.robot.Robot;
import com.rea.toyrobot.robot.RobotBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class ToyRobotSimulatorIT {

    private Robot robot;

    @Before
    public void setUp() {
        this.robot = new RobotBuilder()
                .mandatoryNorthEastBoundary(new Position(5, 5))
                .build();
    }

    @Test
    public void testInputA() throws Exception {
        assertEquals("0,1,NORTH", runSimulator("PLACE 0,0,NORTH", "MOVE", "REPORT"));
    }

    @Test
    public void testInputB() throws Exception {
        assertEquals("0,0,WEST", runSimulator("PLACE 0,0,NORTH", "LEFT", "REPORT"));
    }

    @Test
    public void testInputC() throws Exception {
        assertEquals("3,3,NORTH", runSimulator("PLACE 1,2,EAST", "MOVE", "MOVE", "LEFT", "MOVE", "REPORT"));
    }

    private String runSimulator(String... commands) {
        List<String> output = Stream.of(commands)
                .map(new Sanitiser())
                .map(new CommandParser())
                .map(this.robot)
                .filter(transition -> transition.by() instanceof ReportCommand)
                .map(Transition::to)
                .map(Configuration::toString)
                .collect(Collectors.toList());
        assertEquals(1, output.size());
        return output.get(0);
    }

}
