package kungzhi.muse.ui;

import kungzhi.muse.model.Headband;
import kungzhi.muse.osc.service.MessageDispatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.time.Clock;

import static kungzhi.muse.osc.service.MessagePath.MELLOW;

@Controller
public class MellowChartController
        extends SingleNumberChartController {

    @Autowired
    public MellowChartController(Clock clock, Headband headband,
                                 MessageDispatcher dispatcher) {
        super(clock, headband, dispatcher, MELLOW, "model.algorithm.mellow");
    }
}
