package kungzhi.muse.model;

import kungzhi.muse.active.ActiveItem;
import kungzhi.muse.active.ActiveItemListener;
import kungzhi.muse.active.ActiveItemSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class ActiveModel<M extends ActiveItem<M> & Model>
        extends AbstractModel
        implements ActiveItem<M> {
    protected final Logger log = LoggerFactory.getLogger(getClass());
    private final transient ActiveItemSupport<M> support =
            new ActiveItemSupport<>();

    public ActiveModel(long time) {
        super(time);
    }

    @Override
    public void addActiveItemListener(ActiveItemListener<M> listener) {
        support.addActiveItemListener(listener);
    }

    @Override
    public void removeActiveItemListener(ActiveItemListener<M> listener) {
        support.removeActiveItemListener(listener);
    }

    @Override
    public final M copy() {
        return newInstance()
                .copyFrom((M) this);
    }

    @Override
    public final boolean updateFrom(M model) {
        if (differsFrom(model)) {
            M previous = copy();
            M current = copyFrom(model);
            log.info("{} has been modified: {}", getClass().getSimpleName(), current);
            support.modified(current, previous);
            return true;
        }
        return false;
    }

    protected abstract M copyFrom(M item);


    protected abstract ActiveModel<M> newInstance();
}
