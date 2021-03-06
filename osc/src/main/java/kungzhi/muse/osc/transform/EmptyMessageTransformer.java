package kungzhi.muse.osc.transform;

import com.illposed.osc.OSCMessage;
import kungzhi.muse.model.Model;

public class EmptyMessageTransformer<M extends Model>
        implements MessageTransformer<M> {

    @Override
    public M fromMessage(long time, OSCMessage message)
            throws Exception {
        return null;
    }
}
