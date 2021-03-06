package kungzhi.muse.ui.chart;

import kungzhi.muse.model.Headband;
import kungzhi.muse.osc.service.MessageDispatcher;
import kungzhi.muse.repository.Bands;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.time.Clock;

@Controller
public class RelativeBandPowerController
        extends BandPowerController {

    @Autowired
    public RelativeBandPowerController(
            Clock clock,
            Bands bands,
            Headband headband,
            MessageDispatcher dispatcher) {
        super(clock, bands, headband, dispatcher, true);
    }
}
