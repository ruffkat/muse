package kungzhi.muse.osc.transform;

import de.sciss.net.OSCMessage;
import kungzhi.muse.model.HeadbandStatusStrict;
import kungzhi.muse.osc.service.Transformer;

import static kungzhi.muse.osc.service.MessagePath.HEADBAND_STATUS_STRICT;
import static kungzhi.muse.osc.transform.MessageHelper.extractArguments;

@Transformer(HEADBAND_STATUS_STRICT)
public class HeadbandStatusStrictTransformer
        implements MessageTransformer<HeadbandStatusStrict> {

    @Override
    public HeadbandStatusStrict fromMessage(long time, OSCMessage message)
            throws Exception {
        return new HeadbandStatusStrict(time, extractArguments(message, Float.class));
    }
}