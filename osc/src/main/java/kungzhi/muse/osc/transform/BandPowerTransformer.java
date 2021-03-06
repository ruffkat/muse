package kungzhi.muse.osc.transform;

import com.illposed.osc.OSCMessage;
import kungzhi.muse.model.Band;
import kungzhi.muse.model.BandPower;

import static kungzhi.muse.osc.transform.MessageHelper.extractArguments;

public class BandPowerTransformer
        implements MessageTransformer<BandPower> {
    private final Band band;
    private final boolean relative;

    public BandPowerTransformer(Band band, boolean relative) {
        this.band = band;
        this.relative = relative;
    }

    @Override
    public BandPower fromMessage(long time, OSCMessage message)
            throws Exception {
        return new BandPower(time, band, relative, extractArguments(message));
    }
}
